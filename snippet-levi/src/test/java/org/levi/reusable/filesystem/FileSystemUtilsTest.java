package org.levi.reusable.filesystem;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.springframework.util.FileSystemUtils;

public class FileSystemUtilsTest {
	
	@Test
	public void testDelete() throws IOException{
		System.out.println(org.apache.commons.io.FileSystemUtils.freeSpaceKb("c:"));
		
		File src = new File("levisrc");
		File dest = new File("levidest");
		FileSystemUtils.copyRecursively(src, dest);
	}

}
