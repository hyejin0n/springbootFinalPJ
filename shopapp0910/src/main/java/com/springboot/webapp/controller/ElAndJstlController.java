package com.springboot.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ElAndJstlController {
	
	@RequestMapping(value = "registerForm")
	public String registerForm() {
		System.out.println("registerForm() 처리");
		
		return "registerForm";
	}
	
	@RequestMapping(value = "registerProc")
	public String registerProc() {
		System.out.println("registerProc() 처리");
		
		return "registerProc";
	}
	
	@RequestMapping(value = "productList")
	public String productList() {
		System.out.println("productList() 처리");
		
		return "productList";
	}
	
	@RequestMapping(value = "productSel")
	public String productSel() {
		System.out.println("productSel() 처리");
		
		return "productSel";
	}
	
//	jstl 연습을 위한 뷰어 호출
	@RequestMapping(value = "jstlEx")
	public String jstlEx() {
		System.out.println("jstlEx() 처리");
		
		return "jstlEx";
	}
	
}
