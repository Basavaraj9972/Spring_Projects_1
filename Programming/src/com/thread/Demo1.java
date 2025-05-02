package com.thread;


public class Demo1 extends Thread {
	public static int  count = 0;
	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		demo1.start();
		try {
            // Make the main thread wait for the new thread to finish
            demo1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println(count);
		count++;
		System.out.println(count);
	}
	
	public void run() {
		count++;
	}

}
