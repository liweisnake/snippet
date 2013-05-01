package org.levi.reusable.encode;

import org.junit.Test;
import org.springframework.web.util.JavaScriptUtils;

public class JavascriptEscapeTest {
	
	@Test
	public void test() {
		String str = JavaScriptUtils.javaScriptEscape("\";alert();j=\"");
	}
}
