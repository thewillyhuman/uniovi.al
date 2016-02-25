package com.guille.al.labs.lab_4.coins;

public class FakeCoins {
    
    private Coins coins;
    private int weight = 0;
    
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
     * Computes the standard weight for the coins.
     */
    private void calculateWeight() {
	int aux = (coins.coins[0] + coins.coins[1] + coins.coins[2]) / 3;
	this.weight = aux;
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
    
    private int findFake(int left, int right) {
	int middle;
	if(coins.getNumberOfCoins()%2==0)
	    middle = (right - left)/2;
	else
	    middle = ((right - left)/2)-1;
	
	if(coins.weigh(left, middle, middle, right) == ScalePosition.LEFT)
	    return findFake(left, middle);
	else if(coins.weigh(left, middle, middle, right) == ScalePosition.RIGHT)
	    return findFake(middle, right);
	else
	    return middle;
    }
    
}
