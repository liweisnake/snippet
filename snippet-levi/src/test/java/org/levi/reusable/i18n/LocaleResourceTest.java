package org.levi.reusable.i18n;

import java.util.Locale;

import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.LocalizedResourceHelper;

public class LocaleResourceTest {

	@Test
	public void test() {
		LocalizedResourceHelper lrHalper = new LocalizedResourceHelper(); 
        // ① 获取对应美国的本地化文件资源
        Resource msg_us = lrHalper.findLocalizedResource("i18n/message", ".properties", 
        Locale.US); 
        // ② 获取对应中国大陆的本地化文件资源
        Resource msg_cn = lrHalper.findLocalizedResource("i18n/message", ".properties", 
        Locale.CHINA); 
        System.out.println("fileName(us):"+msg_us.getFilename()); 
        System.out.println("fileName(cn):"+msg_cn.getFilename()); 
	}

}
