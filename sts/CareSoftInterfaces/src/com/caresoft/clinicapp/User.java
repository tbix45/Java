package com.caresoft.clinicapp;

public class User {
	
		//attributes
	    protected Integer id;
	    protected int pin;
	    
	    //constructor
		// Implement a constructor that takes an ID

	    public User() {}
	    
	    public User(Integer id) {
	    	this.id = id;
	    }
	    
	    
	    //methods
	    
	    //setter&getter
	    // TO DO: Getters and setters

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public int getPin() {
			return pin;
		}

		public void setPin(int pin) {
			this.pin = pin;
		}
	    

}
