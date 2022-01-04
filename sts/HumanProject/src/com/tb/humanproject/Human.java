package com.tb.humanproject;

//import java.util.ArrayList;

public class Human {
	
	// ===========================================
	//attributes
	// ===========================================
	private String name;
	private int age;
	
	private int health = 100;
	
	private int wisdom = 3;
	private int strength = 3;
	private int dexterity = 3;
//	private ArrayList<Integer> numbas = new ArrayList<Integer>();
	
//	private static int allHumans = 0;

	
	// ===========================================
	//constructors 
	// ===========================================
	public Human() {}
	
	public Human(String name, int age, int health, int wisdom, int strength, int dexterity) {
		super();
		this.name = name;
		this.age = age;
		this.health = health;
		this.wisdom = wisdom;
		this.strength = strength;
		this.dexterity = dexterity;
	}

	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// ===========================================
	//methods 
	// ===========================================
	public void eat(int foodCalories) {
		System.out.println(this.name + " is eating an apple! nom nom nom!");
		this.health += foodCalories;
	}
	
	public Human getPoisoned() {
		System.out.println(this.name + " is poisoned! Oh no!");
		this.health -=3;
		return this;
	}
	
	public void pastaAndCreamSauce() {
		System.out.println(this.name + " was fully regenerated!!");
		this.health = 100;
	}
	
	public void attack(Human attackee) {
		attackee.health -= this.strength;
	}
	
	// ===========================================
	//getters & setters
	// ===========================================
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

}
