package com.modlix.lamda;

import java.util.function.Predicate;

interface Cab{
//	void bookCab();
//	void bookCab(String source, String destination);
	String bookCab1(String source, String destination);
}

//normal way
class OlaCab implements Cab{
	public void bookCab() {
		System.out.println("ola cab booked");
	}
	
	public void bookCab(String source, String destination) {
		System.out.println("ola cab is booked from "+source+" To "+destination);
	}
	
	public String bookCab1(String source, String destination) {
		System.out.println("ola cab is booked from "+source+" To "+destination);
		return "Price :650 Rs";
	}
}





public class LambdaExpression {

	public static void main(String[] args) {
//		OlaCab olaCab = new OlaCab();
//		olaCab.bookCab();
//		Cab cab = ()-> System.out.print("Ola Cab is booked");
//		cab.bookCab();
		
//		OlaCab olaCab = new OlaCab();
//		olaCab.bookCab("Btm", "indiraNagar");
		
//		Cab cab = (source,destination)->System.out.println("Ola cab is booked from "+source+" to "+destination);
//		cab.bookCab("vijanagar", "indiraNagar");
		
//		OlaCab olaCab = new OlaCab();
//		olaCab.bookCab1("Hosalli", "Mejestic");
		
		Cab cab = (source,destination)->{
			System.out.print("Ola cab is booked from "+ source+" To "+destination);
			return "Price 1000Rs";
		};
		System.out.println(cab.bookCab1("RajajiNagar", "KR Market"));
		
	}

}
