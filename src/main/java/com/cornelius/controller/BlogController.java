package com.cornelius.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {
	@RequestMapping("/home-1")
	public ModelAndView home1(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("blog/blog-home-1"); 
		return mv;
	}
	@RequestMapping("/home-2")
	public ModelAndView home2(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("blog/blog-home-2"); 
		return mv;
	}
	@RequestMapping("/post")
	public ModelAndView post(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("blog/blog-post"); 
		return mv;
	}
}
