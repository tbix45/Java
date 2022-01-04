package com.tb.controllerspractice;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//hello human assignment now 
//...
@RestController
@RequestMapping("/")
public class HomeController {
 @RequestMapping("")
 public String index(@RequestParam(value ="q", required=false) String firstName,@RequestParam(value ="ln", required=false) String lastName){
	 if((firstName!=null) & (lastName!=null)){
   return "Hello " +(firstName) + " " + (lastName) +"!";
 	} else if ((firstName!=null)& (lastName==null)){
 		return "Hello " + firstName +"!";
 	} 
	 else {
 		return "Hello Human!";
 	}
 }

 	// you can be explicit about the request as well
//	 @RequestMapping(value="/hello", method=RequestMethod.GET)
//	 public String hello(){
//	   return "Hello world! What route did you use to access me?";
//	 }
	 @RequestMapping("/goodbye")
	 public String goodbye(@RequestParam(value="q", required=false)String searchQuery, @RequestParam(value="numb", required=false)String times){
		 try {
			 int num = Integer.parseInt(times);
			 if((searchQuery!=null)&& (num>=0)) {
				 ArrayList<String> statement= new ArrayList<String>();
				 for(int i = 0; i<num; i=i+1){
					 System.out.println("worked");
					 statement.add("Goodbye "+ searchQuery);
				 }
				 String listString = String.join(", ", statement);
				 return listString;
//				 return "Goodbye " + searchQuery + ". "+ "Now print " + num + " times!";
		 }
		 }
		 
		 catch(NumberFormatException nfe) {
			 return "Goodbye " + searchQuery;
		 }
		return "hey";
	 }
//		 if((searchQuery!=null) & times!=null){
////			 int num = Integer.parseInt(times);
////			 String message = ("Goodbye " +(searchQuery) +"! This many times: " + times);
////			 String dupmessage = message*num;
////			 for(int i=0; i< num;i++) {
////				  System.out.println("Goodbye "+ (searchQuery));
////			 }
//			   return ("Goodbye " +(searchQuery) +"! This many times: " + times);
//			 	} 
//		 else if ((searchQuery!=null)&(times==null)){
//			 		return "Goodbye " + searchQuery + "!";
//			 	} else {
//			 		return "Goodbye Human!";
//			 	}
//	 }
	 
	 @RequestMapping("/m/{track}/{module}/{lesson}")
	    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
	    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
	    }
}


	

