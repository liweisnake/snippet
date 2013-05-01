package org.levi.reusable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GeneralTypeTest {

	@Test
	public void test() {
		method(new ArrayList<Integer>());
	}

	public int method(List<Integer> list) {
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "1");
		for(int i : list1){
			System.out.println(i);
		}
		return 1;
	}

//	public static String method(List<String> list) {
//		return "";
//	}

}
