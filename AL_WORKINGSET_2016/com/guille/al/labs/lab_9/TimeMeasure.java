package com.guille.al.labs.lab_9;

import org.junit.Test;

public class TimeMeasure {
    
    private long t1,t2;
    
    @Test
    public void timeTest() {
	SelectionImproved si = new SelectionImproved(5, 2, 3);
	si.branchAndBound(si.getRootNode());
	System.out.println(si.getRootNode());
    }
}
