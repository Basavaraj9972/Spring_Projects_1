package com.modlix.lamda.predefFunctionalInf.ConsumerFunction;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierFunction {

	public static void main(String[] args) {
		Supplier<Date> s = ()->new Date();
		System.out.println(s.get());
	}

}
