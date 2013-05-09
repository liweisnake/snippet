package org.levi.reusable.memorytest;

import java.util.ArrayList;
import java.util.List;

public class ConstantOOM {
	
	//http://renxiangzyq.iteye.com/blog/549554
	public static void main(String [] args){
		int i = 0;
		try{
			List<String> list = new ArrayList<String>();
		
			while(true){
				System.out.println(++i);
				list.add(String.valueOf(i).intern());
			}
		}catch(Throwable t){
			System.out.println(i);
		}
	}

}
