package com.modlix.lamda;

import java.util.ArrayList;

interface StringFunction {
	  String run(String str);
	}

public class demo1 {

	public static void main(String[] args) {
		ArrayList<Object> arrayList = new ArrayList<>();
		StringFunction exclaim = (s) -> s + "!";
		StringFunction ask = (s) -> s + "?";
//	    System.err.println(exclaim);
//	    System.err.println(exclaim);
	    printFormatted("Hello", exclaim);
	    printFormatted("Hello", ask);
	  }
	  public static void printFormatted(String str, StringFunction format) {
	    String result = format.run(str);
	    System.out.println(result);
	  }

}
