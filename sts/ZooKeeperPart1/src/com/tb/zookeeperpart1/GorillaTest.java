package com.tb.zookeeperpart1;

public class GorillaTest {

	public static void main(String[] args) {

		Gorilla silver = new Gorilla();
		silver.throwSomething(); //-5
//		silver.throwSomething();

		silver.eatBananas(); //+10
		silver.climb(); //-10
		silver.climb(); //-10

		System.out.println("Gorilla energy is: " + silver.displayEnergy());

	}

}
