package org.levi.reusable.memorytest;

import java.lang.reflect.Field;
import java.nio.DoubleBuffer;

import sun.misc.Unsafe;

public class DirectMemoryOOM {
	
	private static final int _1MB = 1024*1024;
	
	public static void main(String [] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		Field field = Unsafe.class.getDeclaredField("theUnsafe");
		field.setAccessible(true);
		Unsafe unsafe = (Unsafe)field.get(null);
		while(true){
			unsafe.allocateMemory(_1MB);
		}
	}

}
