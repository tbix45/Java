package com.tb.bookclub.controllers;

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

import com.tb.bookclub.models.Book;
import com.tb.bookclub.models.LoginUser;
import com.tb.bookclub.models.User;
import com.tb.bookclub.services.BookService;
import com.tb.bookclub.services.UserService;


@Controller
public class MainController {
	
	    private final UserService userServ;
	    private final BookService bookServ;

	    public MainController(UserService userServ, BookService bookServ) {
	    	this.userServ = userServ;
	    	this.bookServ = bookServ;
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
		public String dashboard(HttpSession session, Model model, RedirectAttributes flash) {
			Long userId = (Long) session.getAttribute("user_id");
	    	if(userId == null) {
	    		flash.addFlashAttribute("login", "Please login/register before using site!");
	    		return "redirect:/";}	
	    	
	    		User user = userServ.getUserInfo(userId);
	    		model.addAttribute("loggedUser", user);
	    		
	    		List<Book> books = bookServ.getAllBooks();
	    		model.addAttribute("books", books);
	    		return "dashboard.jsp";
		}
//===========================
//Render new book page
//============================
	@GetMapping("/books/new")
		public String newBook(HttpSession session, RedirectAttributes flash, Model model) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId==null) {
			flash.addFlashAttribute("login", "Please login/register before using site!");
			return "redirect:/";
		}
		model.addAttribute("userId", userId);
		model.addAttribute("newBook", new Book());
		return "newbook.jsp";
	}
	
//===========================
//process new book page (create)
//============================
	@PostMapping("/create")
	public String createBook(@Valid @ModelAttribute("newBook") Book book, 
            BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("user_id");
			model.addAttribute("userId", userId);
			return "newbook.jsp";
		} else {
			bookServ.saveBook(book);
			return "redirect:/dashboard";
		}
	}
//===========================
//Render one book page (show one)
//============================	
	
	@GetMapping("/books/{id}")
	public String showOneBook(@PathVariable("id") Long bookId,
			HttpSession session,
			Model model,
			RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId==null) {
			flash.addFlashAttribute("login", "Please login/register before using site!");
			return "redirect:/";
		}
		Book book = bookServ.findOneBook(bookId);
		model.addAttribute("book", book);
		return  "showOneBook.jsp";
	}
	
//===========================
//Render Edit Page
//============================		
	@GetMapping("/books/edit/{id}")
	public String showedit(@PathVariable("id") Long bookId,
			HttpSession session,
			Model model,
			RedirectAttributes flash) {
		Long userId = (Long) session.getAttribute("user_id");
		if(userId==null) {
			flash.addFlashAttribute("login", "Please login/register before using site!");
			return "redirect:/";
		}
		Book book = bookServ.findOneBook(bookId);
		if(book.getUser().getId().equals(userId)) {
			model.addAttribute("book", book);
			return "editBook.jsp";
		}
		flash.addFlashAttribute("useredit", "You can't edit someone else's book!");
		return "redirect:/dashboard";
	}
	
//===========================
//Process Edit Page
//============================	
		@PutMapping("/update/{id}")
		public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
			if (result.hasErrors()) {
				return "editBook.jsp";
			} else {
				bookServ.saveBook(book);
				return "redirect:/dashboard";
			}
		}
	
//===========================
//Delete Routes
//============================	
		@DeleteMapping("/delete/{id}")
		public String deleteBook(@PathVariable("id") Long bookId,
				HttpSession session,
				Model model,
				RedirectAttributes flash) {
			Long userId = (Long) session.getAttribute("user_id");
			Book book = bookServ.findOneBook(bookId);
			if(book.getUser().getId().equals(userId)) {
//				model.addAttribute("book", book);
				bookServ.deleteBook(bookId);
				return "redirect:/dashboard";
			} else {
				flash.addFlashAttribute("userdelete", "You can't delete someone else's book!");
				return "redirect:/dashboard";
			}
		}
	
		
		
		
		
		//end
	
}
