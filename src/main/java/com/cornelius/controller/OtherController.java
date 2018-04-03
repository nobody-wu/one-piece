package com.cornelius.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 各种样式的页面
 * @author wxk
 *
 */
@Controller
@RequestMapping("/other")
public class OtherController {

	@RequestMapping("/pricing")
	public ModelAndView pricing(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/other/pricing"); 
		return mv;
	}
	@RequestMapping("/faq")
	public ModelAndView faq(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/other/faq"); 
		return mv;
	}
	@RequestMapping("/full-width")
	public ModelAndView fullWidth(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/other/full-width"); 
		return mv;
	}
	@RequestMapping("/sidebar")
	public ModelAndView sidebar(Model model,HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView("/other/sidebar"); 
		return mv;
	}
}
