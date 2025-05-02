package com.tap.sort;

public class Merge_Sort {

	public static void main(String[] args) {
		int[] ar = {5,3,6,2,7};
		divide(ar,0,ar.length-1);
		for(int i=0;i<ar.length;i++) {
			System.out.print(ar[i]+" ");
		}
	}

	private static void divide(int[] ar,int si,int ei) {
		if(si>=ei) {
			return;
		}
		int mid = si + (ei-si)/2;
		divide(ar,si,mid-1);
		divide(ar,mid+1,ei);
		conquer(ar,si,mid,ei);
	}

	private static void conquer(int[] ar, int si, int mid, int ei) {
		int merge[] = new int[ei-si+1];
		int index1 = si;
		int index2 = mid+1;
		int x = 0;
		while(index1<=mid && index2 <=ei) {
			if(ar[index1]<=ar[index2]) {
				merge[x++] = ar[index1++];
			}
			else {
				merge[x++] = ar[index2++];
			}
		}
		while(index1<=mid) {
			merge[x++] = ar[index1++];
		}
		while(index2<=ei) {
			merge[x++] = ar[index2++];
		}
		for(int i=0,j=si;i<merge.length;i++,j++) {
			ar[j] = merge[i];
		}
	}

}
