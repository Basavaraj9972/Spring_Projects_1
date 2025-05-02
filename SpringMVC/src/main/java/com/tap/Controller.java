package com.tap;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("/first")
	public void firstController() {
		System.out.println("This is first Controller");
	}
	
	@RequestMapping("/Second")
	public void secondController() {
		System.out.println("This is second controller");
	}
	
	@RequestMapping("/third")
	public void thirdController() {
		System.out.println("This is third controller");
	}
	
}

