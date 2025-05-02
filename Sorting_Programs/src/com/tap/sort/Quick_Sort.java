package com.tap.sort;
import java.util.Scanner;
public class Quick_Sort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for(int i=0;i<array.length;i++) {
			array[i] = sc.nextInt();
		}
		printQuickSort(array,0,array.length-1);
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
				
	}
	static void printQuickSort(int[] array,int lb,int ub) {
		if(lb<ub) {
			int end = partition(array,lb,ub);
			printQuickSort(array,lb,end-1);
			printQuickSort(array,end+1,ub);
		}
	}
	static int partition(int[] array,int lb,int ub) {
		int pivote = array[lb];
		int start = lb;
		int end = ub;
		while(start<end) {
			while(start<ub && array[start]<=pivote) {
				start++;
			}
			while(array[end]>pivote) {
				end--;
			}
			if(start<end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
			}
		}
		int temp = array[lb];
		array[lb] = array[end];
		array[end] = temp;
		return end;
	}

}
