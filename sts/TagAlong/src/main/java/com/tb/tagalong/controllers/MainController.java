package com.tb.tagalong.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tb.tagalong.models.LoginUser;
import com.tb.tagalong.models.Trip;
import com.tb.tagalong.models.User;
import com.tb.tagalong.services.TripService;
import com.tb.tagalong.services.UserService;


//import com.tb.tvshows.models.LoginUser;

@Controller
public class MainController {
	
	
	   private final UserService userServ;
	    private final TripService tripServ;


	    public MainController(UserService userServ, TripService tripServ) {
	    	this.userServ = userServ;
	    	this.tripServ = tripServ;
	 
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
  	    		
  	    		List<Trip> trips = tripServ.getAllTrips();
  	    		model.addAttribute("trips", trips);
  	    		return "dashboard.jsp";
  		}
	    
//===========================
//Process search bar 
//============================ 
	    @PostMapping("/form/submit")
	    public String search(@RequestParam(value="q", required = false) String search, Model model, HttpSession session, RedirectAttributes flash) {
	    	System.out.print("you searched " + search);
	    	Long userId = (Long) session.getAttribute("user_id");
  	    	if(userId == null) {
  	    		flash.addFlashAttribute("login", "Please login/register before using site!");
  	    		return "redirect:/";}
	    	
	    	User user = userServ.getUserInfo(userId);
	    		model.addAttribute("loggedUser", user);
	    		
	    	List<Trip> trips = tripServ.findBySearch(search);
	    	model.addAttribute("trips", trips);
	    	return "dashboard.jsp";
	    }

//===========================
//Save trip to favorite
//============================ 	    
	  @GetMapping("/{userId}/{tripId}")
	  public String favTrips(@PathVariable ("userId")Long userId, @PathVariable("tripId") Long tripId) {
	    User user = userServ.getUserInfo(userId);    
	    Trip trip = tripServ.findOneTrip(tripId);
	    
	    List <Trip> favtrips = user.getFavtrips();
	    if(favtrips.contains(trip)) {
			  return "redirect:/dashboard";
	    }
	    
	    user.getFavtrips().add(trip);
//	    List<Trip> trips = user.getFavtrips();
//	    System.out.println(trips);
//	    System.out.println(user);
//	    System.out.println(trip);
	    userServ.save(user); 		  
		  
		  return "redirect:/dashboard";
	  }
	  
	    //===========================
	    //remove trip from favorite
	    //============================ 	    
	  @GetMapping("/remove/{userId}/{tripId}")
	  public String removeFavTrips(@PathVariable ("userId")Long userId, @PathVariable("tripId") Long tripId) {
	    User user = userServ.getUserInfo(userId);    
	    Trip trip = tripServ.findOneTrip(tripId);
	    user.getFavtrips().remove(trip);
//	    List<Trip> trips = user.getFavtrips();
//	    System.out.println(trips);
//	    System.out.println(user);
//	    System.out.println(trip);
	    userServ.save(user); 		  
		  
		  return "redirect:/profile";
	  }
	  
	  
  //===========================
  //Render profile page
  //============================  
	 @GetMapping("/profile")
	 public String profile(HttpSession session, Model model,RedirectAttributes flash) {
	    	Long userId = (Long) session.getAttribute("user_id");
  	    	if(userId == null) {
  	    		flash.addFlashAttribute("login", "Please login/register before using site!");
  	    		return "redirect:/";}	
  	    	
  	    		User user = userServ.getUserInfo(userId);
  	    		model.addAttribute("loggedUser", user);
  	    		
  	    		
  	    		return "profile.jsp";
  		}
	 
//===========================
//Render new trip page
//============================
    	@GetMapping("/new/trip")
    		public String newTrip(HttpSession session, RedirectAttributes flash, Model model) {
    		Long userId = (Long) session.getAttribute("user_id");
    		if(userId==null) {
    			flash.addFlashAttribute("login", "Please login/register before using site!");
    			return "redirect:/";
    		}
    		model.addAttribute("userId", userId);
    		model.addAttribute("newTrip", new Trip());
    		return "newTrip.jsp";
    	}	
    	
 //===========================
  //process new show page (create)
  //============================
	  	@PostMapping("/create/trip")
	  	public String createTrip(@Valid @ModelAttribute("newTrip") Trip trip, 
	              BindingResult result, Model model, HttpSession session) {
	  		if(result.hasErrors()) {
	  			Long userId = (Long) session.getAttribute("user_id");
	  			model.addAttribute("userId", userId);
	  			return "newTrip.jsp";
	  		} else {
	  			tripServ.saveTrip(trip);
	  			return "redirect:/dashboard";
	  		}
	  	}	    
    //===========================
    //Render one show page (show one)
    //============================	
    	
    	@GetMapping("/trip/{id}")
    	public String showOneTrip(@PathVariable("id") Long tripId,
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
  		
    		Trip trip = tripServ.findOneTrip(tripId);
    		model.addAttribute("trip", trip);
    		return  "oneTrip.jsp";
    	}	    
	  //===========================
	  //Render Edit Page
	  //============================	
		@GetMapping("/trip/edit/{id}")
		public String tripedit(@PathVariable("id") Long tripId,
				HttpSession session,
				Model model,
				RedirectAttributes flash) {
			Long userId = (Long) session.getAttribute("user_id");
			if(userId==null) {
				flash.addFlashAttribute("login", "Please login/register before using site!");
				return "redirect:/";
			}
			Trip trip = tripServ.findOneTrip(tripId);
			if(trip.getUser().getId().equals(userId)) {
				model.addAttribute("trip", trip);
				return "editTrip.jsp";
			}
			flash.addFlashAttribute("useredit", "You can't edit someone else's trip!");
			return "redirect:/dashboard";
		} 	    
//===========================
//Process Edit Page
//============================	
		@PutMapping("/update/trip/{id}")
		public String updateTrip(@Valid @ModelAttribute("trip") Trip trip, BindingResult result) {
			if (result.hasErrors()) {
				return "editTrip.jsp";
			} else {
				tripServ.saveTrip(trip);
				return "redirect:/dashboard";
			}
		}	    
//===========================
//Delete Routes
//============================	
		@DeleteMapping("/delete/trip/{id}")
		public String deleteTrip(@PathVariable("id") Long tripId,
				HttpSession session,
				Model model,
				RedirectAttributes flash) {
			Long userId = (Long) session.getAttribute("user_id");
			Trip trip = tripServ.findOneTrip(tripId);
			if(trip.getUser().getId().equals(userId)) {
//								model.addAttribute("book", book);
				tripServ.deleteTrip(tripId);
				return "redirect:/dashboard";
			} else {
				flash.addFlashAttribute("userdelete", "You can't delete someone else's trip!");
				return "redirect:/dashboard";
			}
		}
		
		
		
		 	    
	//===========================
	//Process edit profile Page
	//============================	
//			@PutMapping("/update/user/{id}")
//			public String updateProfile(@Valid @ModelAttribute("user") User user, BindingResult result) {
//				if (result.hasErrors()) {
//					return "profile.jsp";
//				} else {
//					userServ.save(user);
//					return "redirect:/dashboard";
//				}
//			}
	    
}
