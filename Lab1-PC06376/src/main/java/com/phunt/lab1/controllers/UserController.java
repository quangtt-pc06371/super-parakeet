package com.phunt.lab1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.phunt.lab1.models.User;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("user")
public class UserController {
		@Autowired
		ServletContext context;
		
		@Autowired
		HttpServletRequest request;
		
		
		@Autowired
		HttpServletResponse response1;
		
		@GetMapping("create")
		public String createGet() {
			return "client/user_create";
		}
		
		@PostMapping("create")
		public String createPost() {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User user = new User(username,password);
			request.setAttribute("message", user);
		    Cookie Cookie = new Cookie(user.getUsername(), user.getPassword());
	        response.addCookie(Cookie);
			 System.out.println("Username: " + username);
		     System.out.println("Password: " + password);
		     System.out.println("User Cookie Value: " + user);
			return "client/index";
					
		}
		
}
