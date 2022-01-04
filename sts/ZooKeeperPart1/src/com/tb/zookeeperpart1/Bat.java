package com.tb.zookeeperpart1;

public class Bat extends Mammal{

	//attributes
	
	//constructors
	public Bat() {
		this.setEnergyLevel(300);
	}
	
	//methods
	public void fly() {
		System.out.println("Whoosh!");
		this.setEnergyLevel(getEnergyLevel()-50);
		
	}
	
	public void eatHumans() {
		System.out.println("Sorry Bill!");
		this.setEnergyLevel(getEnergyLevel()+25);
	}
	
	public void attackTown() {
		System.out.println("*Crumbing buildings*");
		this.setEnergyLevel(getEnergyLevel()-100);

	}
	
	
	//getter & setters
	
}
