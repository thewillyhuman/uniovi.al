package com.guille.al.labs.lab_9;

import static org.junit.Assert.fail;

import org.junit.Test;

public class TimeMeasure {
    
    private long t1, t2, t3, t4;
    
    @Test
    public void timeTest() {
	SelectionImproved si = new SelectionImproved(30, 15, 120);
	t1 = System.currentTimeMillis();
	si.branchAndBound(si.getRootNode());
	t2 = System.currentTimeMillis();
	/*si.printSolutionTrace();
	System.out.println("Finished in: " + (t2-t1) + " milliseconds.");*/
	
	String[] aux = new String[3];
	aux[0] = "30";
	aux[1] = "15";
	aux[2] = "120";
	
	t3 = System.currentTimeMillis();
	YouHaveToImpreveThis2.main(aux);
	t4 = System.currentTimeMillis();
	
	if((t4-t3) <= (t2-t1)) {
	    fail("The B&B algorithm is not good enoght.");
	}
    }
}
