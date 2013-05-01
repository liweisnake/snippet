package org.levi.reusable.reflect;

import org.junit.Test;
import org.springframework.util.ReflectionUtils;

public class ReflectTest {

	public String testStr = "abc";
	
	@Test
	public void reflect() throws IllegalArgumentException, IllegalAccessException{
		//Can only access public field with this method
		System.out.println(ReflectionUtils.getField(ReflectionUtils.findField(this.getClass(), "testStr"), this));
	}

}
