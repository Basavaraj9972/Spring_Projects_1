package com.tap.pojo;

import java.time.LocalDate;

public class demo1 {

	public static void main(String[] args) {
		LocalDate lastDayOfLastMonth = LocalDate.now().minusMonths(1).withDayOfMonth(
	            LocalDate.now().minusMonths(1).lengthOfMonth()
	        );
	        System.out.println("Last day of last month: " + lastDayOfLastMonth);
	}

}
