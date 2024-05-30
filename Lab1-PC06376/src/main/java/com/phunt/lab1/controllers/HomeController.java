package com.phunt.lab1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("message", "Chào mừng lớp SD18306");
		return "client/index";
	}
}
