package com.tb.zookeeperpart1;

public class Mammal {
	
	// ===========================================
	//attributes
	// ===========================================
	private int energyLevel;
	
	
	//constructors
	public Mammal() {
		this.setEnergyLevel(100);
	}
	
	//methods
	public int displayEnergy() {
		System.out.println("Energy level is: " + this.energyLevel);
		return this.energyLevel;
	}
	
	//getter/setters
	
	//getter
	public int getEnergyLevel() {
		return energyLevel;
	}
	//setter
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

}
