package com.cybage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {
	
	@RequestMapping("/sayHello")
	public String greet()
	{
		return "First";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView welcome()
	{
		return new ModelAndView("Welcome","user","Prerana");
	}
}
