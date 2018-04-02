package com.cornelius.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service")
public class ServiceController {
	@RequestMapping("/services")
	public ModelAndView services(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("service/services"); 
		return mv;
	}
	
}
