package com.mimaraslan.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RefreshScope
@Controller
public class HomeController {
	
//  http://localhost:8762/home
	@GetMapping({"/", "/home", "/index"})
	public String getHome(Model m) {
		return "index";
	}
}