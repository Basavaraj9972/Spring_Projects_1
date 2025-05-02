package com.tap.sort;
import java.util.Scanner;
public class Bubble_Sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i=0;i<array.length;i++) {
			array[i] = sc.nextInt();
		}
		for(int i=0;i<array.length-1;i++) {
			int flag =0;
			for(int j=0;j<array.length-1-i;j++) {
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = 1;
				}
			}
			if(flag == 0) {
				break;
			}
		}
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
				
	}

}
