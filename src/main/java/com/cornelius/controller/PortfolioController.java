package com.cornelius.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/portfolio")
public class PortfolioController {

	@RequestMapping("/1")
	public ModelAndView page1(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("portfolio/portfolio-1-col"); 
		return mv;
	}
	@RequestMapping("/2")
	public ModelAndView page2(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("portfolio/portfolio-2-col"); 
		return mv;
	}
	@RequestMapping("/3")
	public ModelAndView page3(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("portfolio/portfolio-3-col"); 
		return mv;
	}
	@RequestMapping("/4")
	public ModelAndView page4(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("portfolio/portfolio-4-col"); 
		return mv;
	}
	@RequestMapping("/item")
	public ModelAndView item(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("portfolio/item"); 
		return mv;
	}
}
