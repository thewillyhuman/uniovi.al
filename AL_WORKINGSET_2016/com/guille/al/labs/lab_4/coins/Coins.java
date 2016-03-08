package com.guille.al.labs.lab_4.coins;

import java.util.Arrays;
import java.util.Random;

/**
 * Enumerate to give the position of the scale
 */
enum ScalePosition {
    LEFT, EQUAL, RIGHT
};

/**
 * Class that takes the group of coins Gives a method to weigh and other
 * auxiliary methods
 */
public class Coins {
    // Array with the weight of each coin
    public int[] coins;
    protected int weight;

    /**
     * Creates an instance with a group of coins that has numberOfCoins with
     * random weights and a fake coin in a random position
     * 
     * @param numberOfCoins Number of coins of the group
     */
    public Coins(int numberOfCoins) {
	Random r = new Random();
	int standardWeight = r.nextInt(50);
	coins = new int[numberOfCoins];
	Arrays.fill(coins, standardWeight);
	weight = standardWeight;

	int fakePosition = r.nextInt(coins.length);

	if (r.nextBoolean())
	    coins[fakePosition] = standardWeight + 1;
	else
	    coins[fakePosition] = standardWeight - 1;
    }

    /**
     * Creates an instance with a group of coins that has numberOfCoins with
     * random weights and a fake coin in fakePosition
     * 
     * @param numberOfCoins Number of coins of the group
     * @param fakePosition Position of the fake coin
     */
    public Coins(int numberOfCoins, int fakePosition) {
	Random r = new Random();
	int standardWeight = r.nextInt(50);
	coins = new int[numberOfCoins];
	Arrays.fill(coins, standardWeight);
	weight = standardWeight;

	if (r.nextBoolean())
	    coins[fakePosition] = standardWeight + 1;
	else
	    coins[fakePosition] = standardWeight - 1;
    }

    /**
     * Creates an instance with a group of coins that is given
     * 
     * @param coins Array to create the group con coins
     */
    public Coins(int[] coins) {
	this.coins = coins.clone();
    }

    /**
     * Gives the number of coins of the group
     * 
     * @return Number of coins
     */
    public int getNumberOfCoins() {
	return coins.length;
    }

    /**
     * Function that weighs both sides of all currencies specified in the
     * parameters and returns to where the balance inclines
     * 
     * @param leftSideStarts Index of the first element to the left plate
     * @param leftSideEnds Index of the last element to the left plate
     * @param rightSideStarts Index of the first element to the right plate
     * @param rightSideEnds Index of the last element to the right plate
     * @return - ScalePosition.EQUAL The currencies of the two plates have the
     *         same weight ScalePosition.LEFT The coins of the left have more
     *         weight ScalePosition.RIGHT The coins of the right have more
     *         weight
     */
    ScalePosition weigh(int leftSideStarts, int leftSideEnds, int rightSideStarts, int rightSideEnds) {

	// Loop through all the elements of the subrange adding their weights
	int leftWeight = 0;
	for (int i = leftSideStarts; i <= leftSideEnds; i++)
	    leftWeight += coins[i];

	/// Loop through all the elements of the subrange adding their weights
	int rightWeight = 0;
	for (int j = rightSideStarts; j <= rightSideEnds; j++)
	    rightWeight += coins[j];

	// Returns the enumerate corresponding to the result
	if (leftWeight == rightWeight)
	    return ScalePosition.EQUAL;
	else if (leftWeight > rightWeight)
	    return ScalePosition.LEFT;
	else
	    return ScalePosition.RIGHT;
    }
    
    /**
     * Function that weighs both sides of all currencies specified in the
     * parameters and returns to where the balance inclines
     * 
     * @param leftSideStarts Index of the first element to the left plate
     * @param leftSideEnds Index of the last element to the left plate
     * @param rightSideStarts Index of the first element to the right plate
     * @param rightSideEnds Index of the last element to the right plate
     * @return - ScalePosition.EQUAL The currencies of the two plates have the
     *         same weight ScalePosition.LEFT The coins of the left have more
     *         weight ScalePosition.RIGHT The coins of the right have more
     *         weight
     */
    ScalePosition weighFromArray(int[] left, int[] right) {

	// Loop through all the elements of the subrange adding their weights
	int leftWeight = 0;
	for (int i : left)
	    leftWeight += coins[i];

	/// Loop through all the elements of the subrange adding their weights
	int rightWeight = 0;
	for (int i : right)
	    rightWeight += coins[i];

	// Returns the enumerate corresponding to the result
	if (leftWeight == rightWeight)
	    return ScalePosition.EQUAL;
	else if (leftWeight > rightWeight)
	    return ScalePosition.LEFT;
	else
	    return ScalePosition.RIGHT;
    }

    /**
     * Auxiliary support method for printing the values of the currencies of a
     * range
     * 
     * @param starts Index of the initial element to be printed
     * @param ends Index of the last element to be printed
     */
    public void prints(int starts, int ends) {
	// Prints the number of coins of the range and its indexes
	System.out.println("NumOfCoins = " + (ends - starts + 1) + " (" + starts + "," + ends + ")");

	// Prints the values of the range
	System.out.print("[");

	for (int i = starts; i <= ends; i++)
	    System.out.print(coins[i] + ", ");
	System.out.println("]");
    }
}
