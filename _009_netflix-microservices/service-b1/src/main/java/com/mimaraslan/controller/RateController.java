package com.mimaraslan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RefreshScope
@Controller
public class RateController {

	@Value("${processstart}")
	String processstart;

	@Value("${processstop}")
	String processstop;

	@Value("${rate}")
	String rate; 

	@Value("${price}")
	String price;
	
//  http://localhost:9002/rate
	@RequestMapping("/rate")
	public String getRate(Model m) {

		m.addAttribute("processstart", processstart);
		m.addAttribute("processstop", processstop);
		m.addAttribute("rate", rate);
		m.addAttribute("price", price);

		return "index";
	}
}