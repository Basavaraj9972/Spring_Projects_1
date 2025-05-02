package com.tap.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

	@RequestMapping("/first")
	public String firstController(@RequestParam String id,@RequestParam String name,@RequestParam String email,@RequestParam String address,Model model) {
		System.out.println("hello first");
		return "success.jsp";
	}
}
