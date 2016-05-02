package com.guille.al.labs.lab_9;

import org.junit.Test;

public class TimeMeasure {
    
    private long t1,t2;
    
    @Test
    public void timeTest() {
	SelectionImproved si = new SelectionImproved(50, 25, 325);
	t1 = System.currentTimeMillis();
	si.branchAndBound(si.getRootNode());
	t2 = System.currentTimeMillis();
	si.printSolutionTrace();
	System.out.println("Finished in: " + (t2-t1) + " milliseconds.");
    }
}
