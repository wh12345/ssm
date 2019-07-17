package com.wh.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping("/login")
	public  String login()throws Exception {
		return "login";
	}
	
	@RequestMapping("submit")
	public String submit(String username,String pwd,HttpSession session) throws Exception {
		session.setAttribute("username", username);
		return "redirect:/items/list";
	}
}
