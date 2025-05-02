package com.tap.recursion;

public class Recursion {

	static void printNum(int n) {
		if(n<1) {
			return;
		}
		System.out.println(n);
		printNum(n-1);
	}
	private static int factorial(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		return n * factorial(n-1);
	}
	
	public static void main(String[] args) {
		int n = 5;
//		printNum(n);
		System.out.print(factorial(n));
	}
StringBuilder sb = new StringBuilder();

}
