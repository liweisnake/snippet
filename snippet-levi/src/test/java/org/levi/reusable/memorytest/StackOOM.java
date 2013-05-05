package org.levi.reusable.memorytest;


public class StackOOM {
	
	private static void recusiveCall(){
		recusiveCall();
	}

	public static void main(String [] args){
		recusiveCall();
	}

}
