package org.levi.reusable.inputvalidate;

import org.junit.Test;
import org.springframework.util.Assert;

public class AssertTest {

	@Test
	public void testSpringAssert() {
		String file = "";
		Assert.hasText(file, "file入参不是有效的文件地址");
	}

}
