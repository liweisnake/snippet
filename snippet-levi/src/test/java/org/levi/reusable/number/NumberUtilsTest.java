package org.levi.reusable.number;

import org.junit.Test;
import org.springframework.util.NumberUtils;

public class NumberUtilsTest {

	@Test
	public void test(){
		Double i = NumberUtils.parseNumber("19.2", Double.class);
		System.out.println(i);
	}
	
}
