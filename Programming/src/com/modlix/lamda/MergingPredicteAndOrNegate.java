package com.modlix.lamda;

import java.util.function.Predicate;

public class MergingPredicteAndOrNegate {

	public static void main(String[] args) {
		int nums[] = {13,22,25,29,48,57,60,67,87};
		
		Predicate<Integer> p1 = n->n%2==0;
		Predicate<Integer> p2 = n->n>40;
		
		
		/*
		 * for(int num : nums) { if(p1.test(num) && p2.test(num)) {
		 * System.out.println(num); } }
		 */
		
		/*
		 * //merging through and for(int num : nums) { if(p1.and(p2).test(num)) {
		 * System.out.println(num); } }
		 */
		
		/*
		 * //Merging through or for(int num : nums) { if(p1.or(p2).test(num)) {
		 * System.out.println(num); } }
		 */
		
		//Merging through Negate
		for(int num : nums) {
			if(p1.negate().test(num)) {
				System.out.println(num);
			}
		}
	}

}
