package com.ql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ql.entity.User;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserConnntroller {
	@Autowired
	HttpServletRequest request ;
	@RequestMapping("/user")
	public String display() {
		
		return "user-form";
	}
	@PostMapping("create")
	public String senddeltail() {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User u = new User(username, password);

		request.setAttribute("USER", u);
		
		return "detail";
	}
}
