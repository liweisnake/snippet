package org.levi.reusable.web;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.util.WebUtils;

public class WebUtilsTest {

	/**
	 * 如果后续代码直接访问返回的结果将引发一个 NullPointerException 异常，
	 * 而 WebApplicationContextUtils 另一个 getRequiredWebApplicationContext(ServletContext sc) 
	 * 方法要求 ServletContext 属性列表中一定要包含一个有效的 WebApplicationContext 对象，
	 * 否则马上抛出一个 IllegalStateException 异常
	 */
	@Test
	public void test() {
		ServletContext servletContext = null;
		WebApplicationContext wac =WebApplicationContextUtils. 
				 getWebApplicationContext(servletContext); 
		
		wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		
		HttpServletRequest request = null;
		String name = "";
		WebUtils.getCookie(request, name);
		WebUtils.getSessionAttribute(request, name);
		WebUtils.getRequiredSessionAttribute(request, name);
		WebUtils.getSessionId(request);
		WebUtils.exposeRequestAttributes(request, new HashMap<String, String>());
	}

}
