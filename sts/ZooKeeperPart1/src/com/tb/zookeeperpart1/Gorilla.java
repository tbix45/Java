package com.tb.zookeeperpart1;

public class Gorilla extends Mammal {
	
	//attributes
	
	
	//constructors
	public Gorilla() {
		super();
	}
	
	//methods
	public void throwSomething() {
		System.out.println("Gorilla threw a thing!");
		this.setEnergyLevel(this.getEnergyLevel()-5);
	}
	
	public void eatBananas() {
		System.out.println("Gorilla liked the bananas!");
		this.setEnergyLevel(this.getEnergyLevel()+10);
	}
	
	public void climb() {
		System.out.println("Gorilla climbed the tree!");
		this.setEnergyLevel(this.getEnergyLevel()-10);
	
	}
	
	

}
