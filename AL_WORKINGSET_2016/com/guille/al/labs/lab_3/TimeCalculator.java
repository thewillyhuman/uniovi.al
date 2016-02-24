package com.guille.al.labs.lab_3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.guille.util.Files;


public class TimeCalculator {
    
    final static int BUBBLE_FACTOR = 10000;
    final static int SELECTION_FACTOR = 10000;
    final static int INSERTION_FACTOR = 10000;
    final static int QUICK_FACTOR = 10000;
    static final String PATH = "com/guille/al/files/out/";
    static final String[] FILE_NAMES = {"Bubble_times", "Selection_times", "Insertion_times", "Quicksort_times"}; // 4
    static final int[] FACTORS = {BUBBLE_FACTOR, SELECTION_FACTOR, INSERTION_FACTOR, QUICK_FACTOR}; // 4
    static List<StringBuilder> files = new ArrayList<StringBuilder>();
    static final String COLUM_SEPARATOR = ",";
    static final int TOTALN = 200;

    public static void main(String[] args) throws IOException {
	int[] auxV = null;
	/**
	 * SECURITY CHECK
	 */
	if(FILE_NAMES.length != FACTORS.length) {
	    System.err.println("ERROR: The file names and the factors programed must have the same lenght.");
	    System.exit(-1);
	}
	
	long t1, t2, totalSorted = 0, totalInvSorted = 0, totalRand = 0;
	String columNames = "N SIZE" + COLUM_SEPARATOR + "SORTED TIME" + COLUM_SEPARATOR + "INV. SRT. TIME" + COLUM_SEPARATOR + "RANDOM" + "\n";
	
	/**
	 * BUILDING THE FILES
	 */
	for(int i = 0; i < FILE_NAMES.length; i++) {
	    StringBuilder aux = new StringBuilder();
	    aux.append(columNames);
	    files.add(aux);
	}
	
	for (int n = 10; n <= TOTALN; n += 1) {
	    auxV = new int[n];
	    /* HERE STARTS THE BUBBLE TIMES MEASURING*/
	    for (int repeticion = 0; repeticion <= BUBBLE_FACTOR; repeticion++) {
		int[] v = Vector.sorted(auxV);
		t1 = System.currentTimeMillis();
		Bubble1.bubble(v);
		t2 = System.currentTimeMillis();

		totalSorted += (t2 - t1);
	    }
	    for (int repeticion = 0; repeticion <= BUBBLE_FACTOR; repeticion++) {
		int[] v = Vector.inverselySorted(auxV);
		t1 = System.currentTimeMillis();
		Bubble1.bubble(v);
		t2 = System.currentTimeMillis();

		totalInvSorted += (t2 - t1);
	    }
	    for (int repeticion = 0; repeticion <= BUBBLE_FACTOR; repeticion++) {
		int[] v = Vector.random(auxV, Vector.MAX_RAND);
		t1 = System.currentTimeMillis();
		Bubble1.bubble(v);
		t2 = System.currentTimeMillis();

		totalRand += (t2 - t1);
	    }
	    files.get(0).append(n+ COLUM_SEPARATOR + ((float)totalSorted/BUBBLE_FACTOR) + COLUM_SEPARATOR + ((float)totalInvSorted/BUBBLE_FACTOR) + COLUM_SEPARATOR + ((float)totalRand/BUBBLE_FACTOR) + "\n");
	    
	    /* HERE STARTS THE SELECTION TIMES MEASURING*/
	    for (int repeticion = 0; repeticion <= SELECTION_FACTOR; repeticion++) {
		int[] v = Vector.sorted(auxV);
		t1 = System.currentTimeMillis();
		Selection1.selection(v);
		t2 = System.currentTimeMillis();

		totalSorted += (t2 - t1);
	    }
	    for (int repeticion = 0; repeticion <= SELECTION_FACTOR; repeticion++) {
		int[] v = Vector.inverselySorted(auxV);
		t1 = System.currentTimeMillis();
		Selection1.selection(v);
		t2 = System.currentTimeMillis();

		totalInvSorted += (t2 - t1);
	    }
	    for (int repeticion = 0; repeticion <= SELECTION_FACTOR; repeticion++) {
		int[] v = Vector.random(auxV, Vector.MAX_RAND);
		t1 = System.currentTimeMillis();
		Selection1.selection(v);
		t2 = System.currentTimeMillis();

		totalRand += (t2 - t1);
	    }
	    files.get(1).append(n+ COLUM_SEPARATOR + ((float)totalSorted/SELECTION_FACTOR) + COLUM_SEPARATOR + ((float)totalInvSorted/SELECTION_FACTOR) + COLUM_SEPARATOR + ((float)totalRand/SELECTION_FACTOR) + "\n");
	    
	    /* HERE STARTS THE INSERTION TIMES MEASURING*/
	    for (int repeticion = 0; repeticion <= INSERTION_FACTOR; repeticion++) {
		int[] v = Vector.sorted(auxV);
		t1 = System.currentTimeMillis();
		Insertion1.insertion(v);
		t2 = System.currentTimeMillis();

		totalSorted += (t2 - t1);
	    }
	    for (int repeticion = 0; repeticion <= INSERTION_FACTOR; repeticion++) {
		int[] v = Vector.inverselySorted(auxV);
		t1 = System.currentTimeMillis();
		Insertion1.insertion(v);
		t2 = System.currentTimeMillis();

		totalInvSorted += (t2 - t1);
	    }
	    for (int repeticion = 0; repeticion <= INSERTION_FACTOR; repeticion++) {
		int[] v = Vector.random(auxV, Vector.MAX_RAND);
		t1 = System.currentTimeMillis();
		Insertion1.insertion(v);
		t2 = System.currentTimeMillis();

		totalRand += (t2 - t1);
	    }
	    files.get(2).append(n+ COLUM_SEPARATOR + ((float)totalSorted/INSERTION_FACTOR) + COLUM_SEPARATOR + ((float)totalInvSorted/INSERTION_FACTOR) + COLUM_SEPARATOR + ((float)totalRand/INSERTION_FACTOR) + "\n");
	    
	    /* HERE STARTS THE QUICKSORT TIMES MEASURING*/
	    for (int repeticion = 0; repeticion <= QUICK_FACTOR; repeticion++) {
		int[] v = Vector.sorted(auxV);
		t1 = System.currentTimeMillis();
		QuicksortCentralElement.quicksort(v);
		t2 = System.currentTimeMillis();

		totalSorted += (t2 - t1);
	    }
	    for (int repeticion = 0; repeticion <= QUICK_FACTOR; repeticion++) {
		int[] v = Vector.inverselySorted(auxV);
		t1 = System.currentTimeMillis();
		QuicksortCentralElement.quicksort(v);
		t2 = System.currentTimeMillis();

		totalInvSorted += (t2 - t1);
	    }
	    for (int repeticion = 0; repeticion <= QUICK_FACTOR; repeticion++) {
		int[] v = Vector.random(auxV, Vector.MAX_RAND);
		t1 = System.currentTimeMillis();
		QuicksortCentralElement.quicksort(v);
		t2 = System.currentTimeMillis();

		totalRand += (t2 - t1);
	    }
	    files.get(3).append(n+ COLUM_SEPARATOR + ((float)totalSorted/QUICK_FACTOR) + COLUM_SEPARATOR + ((float)totalInvSorted/QUICK_FACTOR) + COLUM_SEPARATOR + ((float)totalRand/QUICK_FACTOR) + "\n");
	    
	    System.out.println((((float)n/TOTALN) * 100)+ "% COMPLETED...");
	}
	
	for(int i = 0; i < files.size(); i++) {
	    Files.writeFileFromString(PATH, FILE_NAMES[i], files.get(i).toString(), ".csv", Files.UTF_8);
	}
	
	System.out.println("*** ALL FINISHED ***");
    }
}
