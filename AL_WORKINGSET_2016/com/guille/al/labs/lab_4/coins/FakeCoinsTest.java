package com.guille.al.labs.lab_4.coins; 

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * JUnit Test for FakeCoins
 */
public class FakeCoinsTest {
	@Test
	public void test() {
		for (int i= 100; i<1000; i++) { //Coins in the bag (bags between 100 and 1000 coins)
			for (int j=0; j<i; j++) { //Position of the fake coin
				Coins bag = new Coins(i, j); //We create a bag of i coins, placing the fake coin in the position j
				FakeCoins fakeCoins = new FakeCoins(bag); 
				int fakePos = fakeCoins.findFake(); //Our algorithm says that the fake coin is in the position fakeCoin
				System.out.println("Bag "+i+" with coins, fake in position: "+ fakePos + " ");
				//Lets compare the expected result (fakePos) with the actual position we know (j)
				assertEquals("Error because the expected result is not equal to the obtained one:" , j, fakePos);
			}
		}
	}
	
}
