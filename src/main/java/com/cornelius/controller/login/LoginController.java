package com.cornelius.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cornelius.bean.User;
import com.cornelius.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService service;
	
	@RequestMapping("/login")
	public ModelAndView login(Model model,HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="username")String userName,
			@RequestParam(value="password")String password){
		ModelAndView mv = new ModelAndView("login/success"); 
		User u = service.login(userName, password);
		mv.addObject("user", u);
		mv.addObject("string","sadasd");
		return mv;
	}
	@RequestMapping("/index")
	public String index(Model model,HttpServletRequest request,HttpServletResponse response){
		return "login/index";
	}
	
	
	
}
