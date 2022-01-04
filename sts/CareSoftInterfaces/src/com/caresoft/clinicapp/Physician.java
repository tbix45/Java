package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser{
	
		//attributes
		private ArrayList<String> patientNotes;
		
		//constructors
		//that takes an ID
//		public Physician(){}
		
		public Physician(Integer id) {
			super(id);
//			this.id = id;
		}
	
	
		//methods
		public boolean assignPin(int pin) {
			String str = Integer.toString(pin);
			int size = str.length();
			if(size!=4) {
				return false;
			} else {
				this.pin = pin;
				return true;
			}
		}
		
		public boolean accessAuthorized(Integer confirmedAuthID) {
			id = this.getId();
			if(id == confirmedAuthID) {
				return true;
			} else {return false;}
		}
		
	    public void newPatientNotes(String notes, String patientName, Date date) {
	        String report = String.format(
	            "Datetime Submitted: %s \n", date);
	        report += String.format("Reported By ID: %s\n", this.id);
	        report += String.format("Patient Name: %s\n", patientName);
	        report += String.format("Notes: %s \n", notes);
	        this.patientNotes.add(report);
	    }
	    
	
	    // TO DO: Setters & Getters	
		//getters & setters
	
		public ArrayList<String> getPatientNotes() {
			return patientNotes;
		}

		public void setPatientNotes(ArrayList<String> patientNotes) {
			this.patientNotes = patientNotes;
		}
	  
}
