package org.levi.reusable.springusage;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class IocTest {
	
	@Test
	public void testBeanFactoryIoc() {
		ClassPathResource cpr = new ClassPathResource("applicationContext.xml");
		DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(lbf);
		reader.loadBeanDefinitions(cpr);
	}
	
//	@Test
//	public void testBeanFactoryIoc() {
//		ClassPathResource cpr = new ClassPathResource("applicationContext.xml");
//		DefaultListableBeanFactory lbf = new DefaultListableBeanFactory();
//		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(lbf);
//		reader.loadBeanDefinitions(cpr);
//	}

}
