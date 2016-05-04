package com.guille.al.labs.lab_4.coins;

import java.util.Arrays;
import java.util.Random;

public class FakeCoins {

    private Coins coins;
    protected int weight = 0;

    /**
     * Main constructor the the fake coins finder.
     * 
     * @param coins
     *            to be checked.
     */
    public FakeCoins(Coins coins) {
	setCoins(coins);
    }

    /**
     * Setter for the coins. If the coins passed object is null exception.
     * 
     * @param coins
     *            that will be set.
     */
    private void setCoins(Coins c) {
	if (c != null)
	    this.coins = c;
	else
	    throw new IllegalArgumentException("The object -coins- is null, cannot be set");
    }

    /**
     * Computes the standard weight for the coins. With O(1).
     * 
     * @return the standard weight of the coin.
     */
    protected int calculateWeight() {
	if (coins.coins.length < 3)
	    return coins.coins[0];
	Random r = new Random();
	int aux1 = 0;
	int aux2 = 0;

	while ((aux1 == aux2) || (coins.coins[aux1] != coins.coins[aux2])) {
	    aux1 = r.nextInt(coins.getNumberOfCoins() - 1);
	    aux2 = r.nextInt(coins.getNumberOfCoins() - 1);
	}

	this.weight = coins.coins[aux1];
	return weight;
    }

    /**
     * Computes the standard weight for the coins. With O(1).
     * 
     * @return the standard weight of the coin.
     */
    protected int calculateWeightFast() {
	if (coins.coins.length < 3)
	    return coins.coins[0];
	int p1 = coins.coins[0];
	int p2 = coins.coins[1];
	int p3 = coins.coins[2];

	if (p1 == p2)
	    return p1;
	else if (p2 == p3)
	    return p2;
	else
	    return p3;
    }

    /**
     * Find coins method.
     * 
     * IF THE BAG HAS LESS THAN 3 COINS WE CAN'T DETERMINE WHICH ONE IS THE
     * FAKE.
     * 
     * 0. Find the standard weight of the bag. O(n). Can be done faster??
     * 
     * 1. split the coins array in two parts, left and right. 2. if both parts
     * are equals the one in the center, in common is the fake. 3. if LEFT the
     * same only for left. 4. if RIGHT the same for right.
     * 
     */
    public int findFake() {
	if (coins.getNumberOfCoins() < 3)
	    throw new IllegalStateException(
		    "We cannot determine wich is the fake coins for " + coins.getNumberOfCoins() + " coins.");
	calculateWeight();
	return findFake(0, coins.getNumberOfCoins() - 1);

    }

    public int findFake2V() {
	if (coins.getNumberOfCoins() < 3)
	    throw new IllegalStateException(
		    "We cannot determine wich is the fake coins for " + coins.getNumberOfCoins() + " coins.");
	return findFake2V(0, coins.getNumberOfCoins() - 1);
    }

    public int findFake3V() {
	return this.findFake3V(coins.coins);
    }

    /**
     * Finds the fake coin contained in the bag of coins.
     * 
     * @param left
     *            index to start the search.
     * @param right
     *            index to end the search.
     * @return the index where the fake coin is founded.
     */
    private int findFake(int left, int right) {
	int size = right - left + 1;
	int middle = (int) Math.round((right + left) / 2.0);

	if (size == 1) {
	    return left;
	}

	if (size % 2 == 0) {
	    if (weight(left, middle - 1) == weight) {
		return findFake(middle, right);
	    } else {
		return findFake(left, middle - 1);
	    }

	} else {
	    if (weight(left, middle - 1) == weight && weight(middle + 1, right) == weight) {
		return middle;
	    } else if (weight(left, middle - 1) == weight) {
		return findFake(middle + 1, right);
	    } else {
		return findFake(left, middle - 1);
	    }
	}
    }

    /**
     * Not working at this time. Need to find a function that splits an array in
     * 3 equal parts.
     * 
     * @param left
     *            index.
     * @param right
     *            index.
     * @return index of the fake coin.
     */
    @Deprecated
    private int findFake2V(int left, int right) {
	int size = right - left + 1;

	if (size == 1) {
	    return left;
	} else if (size == 2 || size == 4) {
	    if (right < coins.coins.length - 1) {
		right++;
	    } else {
		left--;
	    }
	}
	int div = (size / 3);
	int leftPointer = left + div;
	int rightPointer = right - div;

	if (coins.weigh(left, leftPointer - 1, rightPointer + 1, right) == ScalePosition.EQUAL) {
	    return findFake2V(leftPointer, rightPointer);
	} else if (coins.weigh(left, leftPointer - 1, leftPointer, rightPointer) == ScalePosition.EQUAL) {
	    return findFake2V(rightPointer + 1, right);
	} else {
	    return findFake2V(left, leftPointer - 1);
	}
    }

    @Deprecated
    private int findFake3V(int[] coinArray) {
	if (coinArray.length == 0)
	    return -1; // fake coin not found
	else if (coinArray.length == 1)
	    return 0;
	else {
	    boolean oddNumCoins = coinArray.length % 2 == 1;
	    int third = coinArray.length / 3;
	    int[] leftCoins = Arrays.copyOfRange(coinArray, 0, third);
	    int[] middleCoins = Arrays.copyOfRange(coinArray, third, 2 * third);
	    int[] rightCoins = Arrays.copyOfRange(coinArray, 2 * third, coinArray.length);

	    ScalePosition result = coins.weighFromArray(leftCoins, middleCoins);

	    if (result == ScalePosition.EQUAL) {
		searchMessage(rightCoins);
		return findFake3V(rightCoins);
	    } else if (result == ScalePosition.RIGHT) {
		searchMessage(leftCoins);
		return findFake3V(leftCoins);
	    } else if (result == ScalePosition.LEFT) {
		searchMessage(middleCoins);
		return findFake3V(middleCoins);
	    } else if (oddNumCoins)
		return coinArray.length - 1;
	    else
		return -1; // no fake coin found
	}
    }

    private void searchMessage(int[] coins) {
	if (coins.length >= 1) {
	} else
	    System.out.println("searching empty array");
    }

    /**
     * Computes the weight from a starting index to an end index.
     * 
     * @param left
     *            index to start weighting.
     * @param right
     *            index to end weighting.
     * @return the weight of the vector provided.
     */
    public float weight(int left, int right) {
	int weight = 0;
	int size = right - left + 1;
	for (int i = left; i <= right; i++)
	    weight += coins.coins[i];
	return ((float) weight / size);
    }
}
