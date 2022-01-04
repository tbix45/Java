package com.tb.firstproject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("")
	public String home(Model model) {
		
		String firstName = "Tom";
		String lastName = "Allan";
		
		model.addAttribute("first", firstName);
		model.addAttribute("last", lastName);

		return "index.jsp";
	}
	
	@RequestMapping("/new_route")
	public String newest(Model model) {
		model.addAttribute("fruit", "Not a banana");
		return "firstproject.jsp";
	}
}
