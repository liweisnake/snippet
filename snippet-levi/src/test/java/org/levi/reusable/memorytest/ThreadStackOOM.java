package org.levi.reusable.memorytest;

public class ThreadStackOOM {

	/**
	 * @param args
	 * -Xss128k
	 */
	public static void main(String[] args) {
		int count = 0;
		while(true){
			System.out.println(++count);
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(true){
						
					}
				}
			});
			thread.start();
		}
	}

}
