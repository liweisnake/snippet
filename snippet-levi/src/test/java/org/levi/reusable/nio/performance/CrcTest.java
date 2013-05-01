package org.levi.reusable.nio.performance;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.zip.CRC32;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

public class CrcTest {
	
	public long checkSumInputStream(String fileName) throws IOException{
		InputStream in = new FileInputStream(fileName);
		CRC32 crc32 = new CRC32();
		int c;
		while((c = in.read()) != 1)
			crc32.update(c);
		return crc32.getValue();
	}

	public long checksumBufferedInputStream(String filename) throws IOException{
		InputStream inputStream = new BufferedInputStream(new FileInputStream(filename));
		CRC32 crc = new CRC32();
		
		int c;
		while((c = inputStream.read()) != 1)
			crc.update(c);
		return crc.getValue();
	}
	
	public long checksumRandomAccessFile(String filename) throws IOException{
		RandomAccessFile file = new RandomAccessFile(filename, "r");
		long length = file.length();
		CRC32 crc32 = new CRC32();
		for(long p = 0; p < length; p++){
			file.seek(p);
			int c = file.readByte();
			crc32.update(c);
		}
		return crc32.getValue();
	}
	
	public long checksumMappedFile(String filename) throws IOException {
		FileInputStream in = new FileInputStream(filename);
		FileChannel fChannel = in.getChannel();
		long length = fChannel.size();
		CRC32 crc32 = new CRC32();
		MappedByteBuffer mbb = fChannel.map(MapMode.READ_ONLY, 0, length);
		for(int p = 0; p < length; p++){
			int c = mbb.get(p);
			crc32.update(c);
		}
		return crc32.getValue();
	}
	
	@Test
	public void testCrcPerformance() throws IOException{
		ClassPathResource cpr = new ClassPathResource("niotest/maven-definitive-guide_zh.pdf");
		System.out.println("Input Stream:");
		long start = System.currentTimeMillis();
		long crcValue = checkSumInputStream(cpr.getFile().getAbsolutePath());
		long end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end - start) + " milliseconds");
		
		System.out.println("Input Stream buffer:");
		start = System.currentTimeMillis();
		crcValue = checksumBufferedInputStream(cpr.getFile().getAbsolutePath());
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end - start) + " milliseconds");
		
		System.out.println("Random Access File:");
		start = System.currentTimeMillis();
		crcValue = checksumRandomAccessFile(cpr.getFile().getAbsolutePath());
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end - start) + " milliseconds");
		
		System.out.println("Mapped File:");
		start = System.currentTimeMillis();
		crcValue = checksumMappedFile(cpr.getFile().getAbsolutePath());
		end = System.currentTimeMillis();
		System.out.println(Long.toHexString(crcValue));
		System.out.println((end - start) + " milliseconds");
	}
}
