package com.guille.al.labs.lab_4.coins;

import java.util.Random;

public class FakeCoins {
    
    private Coins coins;
    protected int weight = 0;
    
    public FakeCoins(Coins coins) {
	setCoins(coins);
    }
    
    /**
     * Setter for the coins. If the coins passed object is null exception.
     * 
     * @param coins that will be set.
     */
    private void setCoins(Coins c) {
	if(c != null)
	    this.coins = c;
	else
	    throw new IllegalArgumentException("The object -coins- is null, cannot be set");
    }
    
    /**
     * Computes the standard weight for the coins. With O(1).
     */
    protected int calculateWeight() {
	if(coins.coins.length < 3)
	    return coins.coins[0];
	Random r = new Random();
	int aux1 = 0;
	int aux2 = 0;
	
	while((aux1 == aux2) || (coins.coins[aux1]!=coins.coins[aux2])) {
	    aux1 = r.nextInt(coins.getNumberOfCoins()-1);
	    aux2 = r.nextInt(coins.getNumberOfCoins()-1);
	}
	
	this.weight = coins.coins[aux1];
	return weight;
    }
    
    protected int calculateWeightFast() {
	if(coins.coins.length < 3)
	    return coins.coins[0];
	int p1 = coins.coins[0];
	int p2 = coins.coins[1];
	int p3 = coins.coins[2];
	
	if(p1==p2)
	    return p1;
	else if(p2==p3)
	    return p2;
	else
	    return p3;
    }
    
    /**
     * Find coins method.
     * 
     * IF THE BAG HAS LESS THAN 3 COINS WE CAN'T DETERMINE WHICH ONE IS THE FAKE.
     * 
     * 0. Find the standard weight of the bag. O(n). Can be done faster??
     * 
     * 1. split the coins array in two parts, left and right.
     * 2. if both parts are equals the one in the center, in common is the fake.
     * 3. if LEFT the same only for left.
     * 4. if RIGHT the same for right.
     * 
     */
    public int  findFake() {
	if(coins.getNumberOfCoins() < 3)
	    throw new IllegalStateException("We cannot determine wich is the fake coins for " + coins.getNumberOfCoins() + " coins.");
	calculateWeight();
	return findFake(0, coins.getNumberOfCoins()-1);
	
    }
    
    /**
     * 
     * @param left
     * @param right
     * @return
     */
    private int findFake(int left, int right) {
	//coins.prints(left, right);
	int size = right - left + 1;
	int middle = (int) Math.round((right + left)/2.0);
	if(size==1) {
	   return left;
	}
	
	if(size%2 == 0) {
	    if(weight(left, middle-1)==weight) {
		return findFake(middle, right);
	    } else {
		return findFake(left, middle-1);
	    }
	    
	} else {
	    if(weight(left, middle-1)==weight && weight(middle+1, right)==weight) {
		return middle;
	    } else if(weight(left, middle-1)==weight) {
		return findFake(middle+1, right);
	    } else {
		return findFake(left, middle-1);
	    }
	}
    }
    
    public float weight(int left, int right) {
	int weight = 0;
	int size = right-left+1;
	for(int i = left; i<=right; i++)
	    weight += coins.coins[i];
	return ((float)weight/size);
    }
}
