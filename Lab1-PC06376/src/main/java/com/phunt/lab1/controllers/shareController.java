package com.phunt.lab1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class shareController {

	@Autowired
	ServletContext context;
	
	@Autowired
	HttpServletRequest request;
 
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;
	@RequestMapping("/Data")
	public String data(Model model) {
			String dataFromRequest = request.getParameter("data");
	        // Lưu giá trị vào session
	        session.setAttribute("dataSesion", dataFromRequest);
	        // Lưu giá trị vào servlet context
	        context.setAttribute("dataContext", dataFromRequest);
	        // Tạo và gửi cookie
	        Cookie cookie = new Cookie("dataCookie", dataFromRequest);
	        response.addCookie(cookie);
	       
		
		return "client/data";
	}
}
