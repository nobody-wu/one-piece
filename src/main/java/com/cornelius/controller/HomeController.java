package com.cornelius.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("/index")
	public ModelAndView home(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("home/home"); 
		return mv;
	}
	@RequestMapping("/about")
	public ModelAndView about(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("home/about"); 
		return mv;
	}
	@RequestMapping("/contact")
	public ModelAndView contact(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("home/contact"); 
		return mv;
	}
}
