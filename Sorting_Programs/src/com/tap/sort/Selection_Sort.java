package com.tap.sort;
import java.util.Scanner;
public class Selection_Sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i=0;i<array.length;i++) {
			array[i] = sc.nextInt();
		}
		printSelectionSort(array);
	}
	static void printSelectionSort(int[] array) {
		for(int i=0;i<array.length-1;i++) {
			int min =i;
			for(int j=i+1;j<array.length;j++) {
				if(array[j]<array[min]) {
					min =j;
				}
			}
			if(min != i) {
				int temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
		}
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}

}
