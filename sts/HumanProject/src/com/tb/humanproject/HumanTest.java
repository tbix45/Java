package com.tb.humanproject;

public class HumanTest {

	public static void main(String[] args) {
		
		Human sbeve = new Human("Sbeve Tyler", 37);
		Human alex = new Human("Alex", 55);
		Human tom = new Human("Tom", 23);
		
		System.out.println(sbeve.getName() + " " + sbeve.getHealth());

	}

}
