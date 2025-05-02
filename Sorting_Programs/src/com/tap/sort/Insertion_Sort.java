package com.tap.sort;
import java.util.Scanner;
public class Insertion_Sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i=0;i<array.length;i++) {
			array[i] = sc.nextInt();
		}
		printInsertionSort(array);
	}
	static void printInsertionSort(int[] array) {
		for(int i=1;i<array.length;i++) {
			int temp = array[i];
			int j = i-1;
			while(j>=0 && array[j]>temp) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = temp;
		}
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}
}
