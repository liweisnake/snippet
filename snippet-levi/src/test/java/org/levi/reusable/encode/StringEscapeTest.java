package org.levi.reusable.encode;

import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.Assert;
import org.junit.Test;

public class StringEscapeTest {

	@Test
	public void test_StringEscapeUtils() {
		Assert.assertEquals("\\\\\\n\\t\\r", StringEscapeUtils.escapeJava("\\\n\t\r")); // escapes
																					// the
																					// Java
																					// String
		Assert.assertEquals("\\\n\t\r",
				StringEscapeUtils.unescapeJava("\\\\\\n\\t\\r")); // unescapes
																	// the Java
																	// String
		Assert.assertEquals("I didn\\'t say \\\"you to run!\\\"",
				StringEscapeUtils
						.escapeEcmaScript("I didn't say \"you to run!\""));// escapes
																			// the
																			// Javascript
		Assert.assertEquals("&lt;xml&gt;", StringEscapeUtils.escapeXml("<xml>"));// escapes
																			// the
																			// xml
	}

}
