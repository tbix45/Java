package com.tb.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tb.dojosandninjas.models.Dojo;
import com.tb.dojosandninjas.models.Ninja;
import com.tb.dojosandninjas.services.DojoService;
import com.tb.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	
	private final DojoService dojoServ;
	private final NinjaService ninjaServ;
	public MainController(DojoService dojoServ, NinjaService ninjaServ) {
		this.dojoServ = dojoServ;
		this.ninjaServ = ninjaServ;
	}

	//==========================
	//show routes
	//==========================
	@RequestMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "index.jsp";
		}
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> dojos = dojoServ.allDojos();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
		}
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoServ.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "showDojo.jsp";
	}
	
	//==========================
	//create routes
	//==========================
	//create ninja
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
		List<Dojo> dojos = dojoServ.allDojos();
		return "newNinja.jsp";
		} else {
			ninjaServ.createNinja(ninja);
			return "redirect:/dojos/new";
		}
	}
	//create dojo
	@RequestMapping(value="/createdojo", method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
//		List<Dojo> dojos = dojoServ.allDojos();
		return "index.jsp";
		} else {
			dojoServ.createDojo(dojo);
			return "redirect:/dojos/new";
		}
	}
	
}
