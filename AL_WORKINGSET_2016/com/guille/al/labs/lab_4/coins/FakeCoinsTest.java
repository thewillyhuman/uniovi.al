package com.guille.al.labs.lab_4.coins;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

/**
 * JUnit Test for FakeCoins
 */
public class FakeCoinsTest {
    @Test
    public void test() {
	for (int i = 9; i < 11; i++) { // Coins in the bag (bags between 100 and 1000 coins)
	    for (int j = 0; j < i; j++) { // Position of the fake coin
		Coins bag = new Coins(i, j); // We create a bag of i coins,
					     // placing the fake coin in the
					     // position j
		FakeCoins fakeCoins = new FakeCoins(bag);
		bag.prints(0, i - 1);
		int fakePos = fakeCoins.findFake(); // Our algorithm says that
						    // the fake coin is in the
						    // position fakeCoin
		System.out.println("Bag " + i + " with coins, fake in position: " + fakePos + " EXPECTED " + j);
		// Lets compare the expected result (fakePos) with the actual
		// position we know (j)
		assertEquals("Error because the expected result is not equal to the obtained one:", j, fakePos);
	    }
	}
    }

    @Test
    @Ignore
    public void weightTest() {
	for (int i = 10; i < 100000; i++) { // Coins in the bag (bags between
					    // 100 and 1000 coins)
	    Coins bag = new Coins(i);
	    FakeCoins coins = new FakeCoins(bag);
	    int calculated = coins.calculateWeight();
	    System.out.println("REAL: " + bag.weight + " CALCULATED: " + calculated + " size = " + i);
	    assertEquals(bag.weight, calculated);
	}
    }

}
