package com.tb.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/your_server/counter")
	public String index(HttpSession session, Model model) {
		session.getAttribute("count");
		Integer updatedCount = (Integer) session.getAttribute("count");
		
		
		return "index.jsp";
	}
	@RequestMapping("/your_server")
	public String welcome(HttpSession session, Model model) {
		
		Integer currentCount = (Integer) session.getAttribute("count");
		
	    if (currentCount == null) {
			session.setAttribute("count", 0);
            // Use setAttribute to initialize the count in session
        }
        else {
            // increment the count by 1 using getAttribute and setAttribute
        	currentCount = currentCount +1;
        	session.setAttribute("count", currentCount);
        }
	    Integer updatedCount = (Integer) session.getAttribute("count");
		model.addAttribute("count", updatedCount);
		return "welcome.jsp";
	}
	
}

