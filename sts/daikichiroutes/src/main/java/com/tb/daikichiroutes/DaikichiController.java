package com.tb.daikichiroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	
	@RequestMapping("")
	public String index(){
		return "Welcome!";
	}
	
	@RequestMapping("/today")
	public String one(){
		return "Today you will find luck in all endeavors!";
	}
	
	@RequestMapping("/tomorrow")
	public String two(){
		return "You will have a great opportunity tomorrow!";
	}
	
	@RequestMapping("/me")
	public String me(){
		return "You will find a penny today!";
	}
	
	@RequestMapping("/{verb}/{location}")
		public String travel(@PathVariable("verb") String verb, @PathVariable("location") String location) {
		return "Congratulations! You will soon " + verb + " to " + location +"!";
	}
	
	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable("number") String number) {
		//how to ensure a number entered
		try {
			int num = Integer.parseInt(number);
			if(num%2==0) {
				return "You will take a grand journey in the near future, but be weary of tempting offers.";
			} else if (num%2!=0){
				return "You have enjoyed the fruits of your labor ut now is a great time to spend time with family and friends";
			}
		} 
		catch(NumberFormatException nfe){
			return "Pick a valid number!";
		}
		return "returned";
//		if(!int number) {
//			return "Pick a valid number!";
//		}
//		if(number/number!=1) {
//			return "Pick a number!";
//		}
	
}
	
	
	
}
