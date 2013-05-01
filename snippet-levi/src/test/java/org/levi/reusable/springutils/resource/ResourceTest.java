package org.levi.reusable.springutils.resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.support.ServletContextResource;

public class ResourceTest {

	/**
	 * 通过 FileSystemResource 以文件系统绝对路径的方式进行访问；
	 */
	@Test
	public void fileSourceTest() {
		System.out.println("start");
		try {

			// ② 使用类路径方式加载文件
			Resource res2 = new ClassPathResource("application.properties");
			
			InputStream ins2 = res2.getInputStream();
			System.out.println("res2:" + res2.getFile().getAbsolutePath());

			String filePath = res2.getFile().getAbsolutePath();
			// ① 使用系统文件路径方式加载文件
			Resource res1 = new FileSystemResource(filePath);
			InputStream ins1 = res1.getInputStream();
			System.out.println("res1:" + res1.getFilename());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ServletContextResource 以相对于 Web 应用根目录的方式访问文件资源
	 */
	@Test
	public void servletResourceTest() {
		ServletContext sc = null;
		Resource res3 = new ServletContextResource(sc,
				"/WEB-INF/classes/conf/file1.txt");
		System.out.print(res3.getFilename());
	}

	@Test
	public void resourceUtilTest() throws FileNotFoundException {
		File clsFile = ResourceUtils.getFile("classpath:conf/file1.txt");
		System.out.println(clsFile.isFile());

		String httpFilePath = "file:D:/masterSpring/chapter23/src/conf/file1.txt";
		File httpFile = ResourceUtils.getFile(httpFilePath);
		System.out.println(httpFile.isFile());
	}

}
