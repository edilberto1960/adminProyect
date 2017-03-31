package com.vedatech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
//@SessionAttributes("resultado")
public class IndexController {
	
	@RequestMapping("/")
	public String showIndex(Model model) {
		model.addAttribute("resultado", "Resultado desde Session");
		return "index";
	}
	
	@RequestMapping("/about")
	public String showRoutes(Model model) {
		model.addAttribute("resultado", "Resultado desde Forecast");
		return "result";
	}
	@RequestMapping("/template")
	public String showTemplate(Model model) {
		model.addAttribute("resultado", "Resultado desde Forecast");
		return "/bank/bank_list";
	}

}
