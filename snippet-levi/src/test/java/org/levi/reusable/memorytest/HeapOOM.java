package org.levi.reusable.memorytest;

import java.util.HashMap;
import java.util.Map;

public class HeapOOM {

	private static Map<Object, Object> map = new HashMap<Object, Object>();
	
	static class HeapObject{
		
	}

	/**
	 * @param args
	 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
	 */
	public static void main(String[] args) {
		while (true) {
			Object object = new HeapObject();
			map.put(object, object);
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}

}
