package com.tb.tvshows.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tb.tvshows.models.LoginUser;
import com.tb.tvshows.models.Show;
import com.tb.tvshows.models.User;
import com.tb.tvshows.services.ShowService;
import com.tb.tvshows.services.UserService;


@Controller
public class MainController {
    private final UserService userServ;
    private final ShowService showServ;

    public MainController(UserService userServ, ShowService showServ) {
    	this.userServ = userServ;
    	this.showServ = showServ;
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
        } else {
            //user ID put in session
            session.setAttribute("user_id", newUser.getId());
            return "redirect:/dashboard";
        }
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
  		public String dashboard(HttpSession session, Model model, RedirectAttributes flash) {
  			Long userId = (Long) session.getAttribute("user_id");
  	    	if(userId == null) {
  	    		flash.addFlashAttribute("login", "Please login/register before using site!");
  	    		return "redirect:/";}	
  	    	
  	    		User user = userServ.getUserInfo(userId);
  	    		model.addAttribute("loggedUser", user);
  	    		
  	    		List<Show> shows = showServ.getAllShows();
  	    		model.addAttribute("shows", shows);
  	    		return "dashboard.jsp";
  		}
    
  //===========================
  //Render new show page
  //============================
  	@GetMapping("/shows/new")
  		public String newShow(HttpSession session, RedirectAttributes flash, Model model) {
  		Long userId = (Long) session.getAttribute("user_id");
  		if(userId==null) {
  			flash.addFlashAttribute("login", "Please login/register before using site!");
  			return "redirect:/";
  		}
  		model.addAttribute("userId", userId);
  		model.addAttribute("newShow", new Show());
  		return "newShow.jsp";
  	}
    
  //===========================
  //process new show page (create)
  //============================
  	@PostMapping("/create")
  	public String createShow(@Valid @ModelAttribute("newShow") Show show, 
              BindingResult result, Model model, HttpSession session) {
  		if(result.hasErrors()) {
  			Long userId = (Long) session.getAttribute("user_id");
  			model.addAttribute("userId", userId);
  			return "newShow.jsp";
  		} else {
  			showServ.saveShow(show);
  			return "redirect:/dashboard";
  		}
  	}
  //===========================
  //Render one show page (show one)
  //============================	
  	
  	@GetMapping("/shows/{id}")
  	public String showOneShow(@PathVariable("id") Long showId,
  			HttpSession session,
  			Model model,
  			RedirectAttributes flash) {
  		Long userId = (Long) session.getAttribute("user_id");
  		if(userId==null) {
  			flash.addFlashAttribute("login", "Please login/register before using site!");
  			return "redirect:/";
  		}
  		User user = userServ.getUserInfo(userId);
		model.addAttribute("loggedUser", user);
		
  		Show show = showServ.findOneShow(showId);
  		model.addAttribute("show", show);
  		return  "oneShow.jsp";
  	}
  //===========================
  //Render Edit Page
  //============================	
	@GetMapping("/shows/edit/{id}")
	public String showedit(@PathVariable("id") Long showId,
			HttpSession session,
			Model model,
			RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId==null) {
			flash.addFlashAttribute("login", "Please login/register before using site!");
			return "redirect:/";
		}
		Show show = showServ.findOneShow(showId);
		if(show.getUser().getId().equals(userId)) {
			model.addAttribute("show", show);
			return "editShow.jsp";
		}
		flash.addFlashAttribute("useredit", "You can't edit someone else's show!");
		return "redirect:/dashboard";
	} 	
//===========================
//Process Edit Page
//============================	
		@PutMapping("/update/{id}")
		public String updateShow(@Valid @ModelAttribute("show") Show show, BindingResult result) {
			if (result.hasErrors()) {
				return "editShow.jsp";
			} else {
				showServ.saveShow(show);
				return "redirect:/dashboard";
			}
		}	
//===========================
//Delete Routes
//============================	
		@DeleteMapping("/delete/{id}")
		public String deleteShow(@PathVariable("id") Long showId,
				HttpSession session,
				Model model,
				RedirectAttributes flash) {
			Long userId = (Long) session.getAttribute("user_id");
			Show show = showServ.findOneShow(showId);
			if(show.getUser().getId().equals(userId)) {
//						model.addAttribute("book", book);
				showServ.deleteShow(showId);
				return "redirect:/dashboard";
			} else {
				flash.addFlashAttribute("userdelete", "You can't delete someone else's show!");
				return "redirect:/dashboard";
			}
		}
	
	
	
	
	
    
}
