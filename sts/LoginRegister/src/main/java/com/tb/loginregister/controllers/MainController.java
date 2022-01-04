package com.tb.loginregister.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tb.loginregister.models.LoginUser;
import com.tb.loginregister.models.User;
import com.tb.loginregister.services.UserService;

@Controller
public class MainController {
		
	    private UserService userServ;
	    public MainController(UserService userServ) {
	    	this.userServ = userServ;
	    }	  

//===========================
//Render register/login page
//============================
	    
	    @GetMapping("/")
	    public String index(Model model) {
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "loginreg.jsp";
	    }
	    @GetMapping("/home")
	    public String home(Model model, HttpSession session) {
	    	if(session==null) {
	    		return "redirect:/";
	    	} else {
		    	return "home.jsp";
	    	}
	    }
	    
  //===========================
  //Process register route
  //============================
	    
	    @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        userServ.register(newUser, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newLogin", new LoginUser());
	            return "loginreg.jsp";
	        }
	        //user ID put in session
	        session.setAttribute("user_id", newUser.getId());
	        return "redirect:/dashboard";
	    }
	    
  //===========================
  //Process login route
  //============================    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        User user = userServ.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "loginreg.jsp";
	        }
	      //user ID put in session
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/dashboard";
	    }
	    
	    //===========================
	    //Logout route
	    //============================    
	    
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";
	    }
	    
  //===========================
  //Render dashboard page
  //============================
	    @GetMapping("/dashboard")
	    public String home(HttpSession session, Model model, RedirectAttributes flash) {
	    	Long userId = (Long) session.getAttribute("user_id");
	    	if(userId == null) {
	    		flash.addFlashAttribute("login", "Please login/register before using site!");
	    		return "redirect:/";}	
	    	
	    		User user = userServ.getUserInfo(userId);
	    		model.addAttribute("loggedUser", user);
		    	return "home.jsp";	
	    }
	    
	}
