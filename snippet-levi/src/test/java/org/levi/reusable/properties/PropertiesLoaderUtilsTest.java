package org.levi.reusable.properties;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class PropertiesLoaderUtilsTest {

	@Test
	public void test() throws IOException {
		// ① jdbc.properties 是位于类路径下的文件
        Properties props = PropertiesLoaderUtils.loadAllProperties("jdbc.properties"); 
        System.out.println(props.getProperty("jdbc.driverClassName"));
        
        Resource resource = new ClassPathResource("conf/file1.txt");
        
        PropertiesLoaderUtils.loadProperties(resource);
        
        PropertiesLoaderUtils.fillProperties(props, resource);
	}

}
