package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin{

    
    // Inside class:
	//attributes
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents= new ArrayList<String>();
    
    // TO DO: Implement a constructor that takes an ID and a role
   
    //constructor
    public AdminUser() {}
    
    public AdminUser(Integer employeeID, String role) {
    	this.employeeID = employeeID;
    	this.role = role;
    }
    
    //methods
	public boolean assignPin(int pin) {
		String str = Integer.toString(pin);
		int size = str.length();
		if(size>=6) {
			this.pin = pin;
			return true;
		} else {
			return false;
		}
	}
	
	public boolean accessAuthorized(Integer confirmedAuthID) {
//		id = this.getEmployeeID();
		if(this.getEmployeeID() == confirmedAuthID) {
			return true;
		} else {
			authIncident();
			return false;}
	}
	
    public ArrayList<String> reportSecurityIncidents(){
    	return securityIncidents;
    };

	
    // DEFAULT IMPLEMENTED METHODS
    // Used to print security incidents. 
    public void printSecurityIncidents() {
        System.out.println(reportSecurityIncidents());
    }
    
    // QA Test, PASS/FAIL of reports against QA expected results
    public boolean adminQATest(ArrayList<String> expectedIncidents) {
        if (reportSecurityIncidents().equals(expectedIncidents)) {
            System.out.println("PASS");
        }
        else {
            System.out.println("FAIL");
        }
        return reportSecurityIncidents().equals(expectedIncidents);
    }
    
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }

    
    // TO DO: Setters & Getters
    
   //setters & getters
	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}

	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

	
}
