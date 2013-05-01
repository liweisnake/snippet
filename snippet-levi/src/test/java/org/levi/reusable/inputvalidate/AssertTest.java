package org.levi.reusable.inputvalidate;

import org.junit.Test;
import org.springframework.util.Assert;

public class AssertTest {

	@Test
	public void testSpringAssert() {
		String file = "";
		Assert.hasText(file, "file鍏ュ弬涓嶆槸鏈夋晥鐨勬枃浠跺湴鍧�");
	}

}
