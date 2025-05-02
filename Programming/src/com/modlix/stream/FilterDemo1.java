package com.modlix.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterDemo1 {

	public static void main(String[] args) {
		 List<String> li = Arrays.asList("hi","ji");
		 List<String> l1 = Arrays.asList("hi", "ji");

		List<Integer> evenArrays = new ArrayList<Integer>();
		
		/*
		 * for(int num :asList) { if(num%2==0) { System.out.println(num); } }
		 */
		
		/*
		 * //1st way t display evenArrays =
		 * asList.stream().filter(n->n%2==0).collect(Collectors.toList());
		 * System.out.println(evenArrays);
		 */
		
		/*
		 * //2nd Way to display
		 * asList.stream().filter(n->n%2==0).forEach(n->System.out.println(n));
		 */
		
		/*
		 * //3rd way to display
		 * asList.stream().filter(n->n%2==0).forEach(System.out::println);
		 */
		
//		 List<String> city = new Arrays.asList("JayaNagar","VijayNagar","IndiraNagar","Kottige Palya","BTM","KSR");
		
		
		}

}
