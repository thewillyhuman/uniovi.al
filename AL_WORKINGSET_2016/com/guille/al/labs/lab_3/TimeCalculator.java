package com.guille.al.labs.lab_3;

import java.io.IOException;

import com.guille.al.labs.lab_2.Loop1;

public class TimeCalculator {
    
    final static int BUBBLE_FACTOR = 1000;
    final static int SELECTION_FACTOR = 1000;
    final static int INSERTION_FACTOR = 1000;
    final static int LOOP_4_FACTOR = 100;
    final static int LOOP_5_FACTOR = 100;
    final static int LOOP_UNKNOWN =  1000;
    static final String PATH = "com/guille/al/files/out/";
    static final String[] FILE_NAMES = {"Bubble_times", "Selection_times", "Insertion_times"};
    static final String COLUM_SEPARATOR = ",";

    public static void main(String[] args) throws IOException {
	
	long t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, totalBubbleSorted = 0, totalSelection = 0, totalInsertion = 0, totalLoop4 = 0, totalLoop5 = 0, totalLoopUnk = 0;
	StringBuilder bubbleFile = new StringBuilder();
	StringBuilder selectionFile = new StringBuilder();
	StringBuilder insertionFile = new StringBuilder();
	
	String columNames = "N SIZE" + COLUM_SEPARATOR + "SORTED TIME" + COLUM_SEPARATOR + "INV. SRT. TIME" + COLUM_SEPARATOR + "RANDOM" + COLUM_SEPARATOR;
	bubbleFile.append(columNames);
	selectionFile.append(columNames);
	insertionFile.append(columNames);
	
	for (int n = 10; n <= 100; n += 1) {
	    for (int repeticion = 0; repeticion <= BUBBLE_FACTOR; repeticion++) {
		t1 = System.currentTimeMillis();
		Bubble1.runBubbleInvSorted(n);
		t2 = System.currentTimeMillis();

		totalBubbleSorted += (t2 - t1);
	    }
	    
	    
	}
    }
}
