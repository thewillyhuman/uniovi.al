package com.guille.al.labs.lab_4.coins;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * JUnit Test for FakeCoins
 */
public class FakeCoinsTest {

    private static final int FINAL_RUNS = 1000;
    private static final int INICIAL_RUNS = 100;

    @Test
    public void test() {
	for (int i = INICIAL_RUNS; i <= FINAL_RUNS; i++) { // Coins in the bag (bags between 100 and 1000 coins)
	    for (int j = 0; j < i; j++) { // Position of the fake coin
		Coins bag = new Coins(i, j); // We create a bag of i coins, placing the fake coin in the position j
		FakeCoins fakeCoins = new FakeCoins(bag);
		int fakePos = fakeCoins.findFake3V(); // Our algorithm says that the fake coin is in the position fakeCoin.
		// Lets compare the expected result (fakePos) with the actual position we know (j)
		assertEquals("Error because the expected result is not equal to the obtained one:", j, fakePos);
	    }
	    System.out.println("PROCESSED: " + ((float) i - INICIAL_RUNS) / (FINAL_RUNS - INICIAL_RUNS) * 100 + " %");
	}
    }

    @Test
    public void weightTest() {
	for (int i = INICIAL_RUNS; i <= FINAL_RUNS; i++) { // Coins in the bag (bags between
	    // 100 and 1000 coins)
	    Coins bag = new Coins(i);
	    FakeCoins coins = new FakeCoins(bag);
	    int calculated = coins.calculateWeight();
	    System.out.println("REAL: " + bag.weight + " CALCULATED: " + calculated + " size = " + i);
	    assertEquals(bag.weight, calculated);
	}
    }

    @Test
    public void weightFastTest() {
	for (int i = INICIAL_RUNS; i <= FINAL_RUNS; i++) { // Coins in the bag (bags between
	    // 100 and 1000 coins)
	    Coins bag = new Coins(i);
	    FakeCoins coins = new FakeCoins(bag);
	    int calculated = coins.calculateWeightFast();
	    System.out.println("REAL: " + bag.weight + " CALCULATED: " + calculated + " size = " + i);
	    assertEquals(bag.weight, calculated);
	}
    }
}
