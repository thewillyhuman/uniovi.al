package com.guille.al.labs.lab_1;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import com.guille.util.FilesImproved;

/**
 * This program serves to measure times automatically increasing the size of the
 * problem (n) and also using a time scale determined by nTimes.
 * 
 * @author theGFC
 */
public class Diagonal2 {
    
    static int[][] a;
    static final int FILL_FACTOR =  10000;
    static final int SUM_1_FACTOR = 100000;
    static final int SUM_2_FACTOR = 1000000;
    static final String PATH = "com/guille/al/files/out/";
    static final String FILE_NAME = "diagonal1_times";
    static final String COLUM_SEPARATOR = ",";
    static final int MIN_LOAD_FACTOR = 10;
    static final int MAX_LOAD_FACTOR = 100;
    
    @SuppressWarnings("unused")
    public static void main(String arg[]) {
	long t1, t2, t3, t4, t5, t6, totalFill = 0, totalSum1 = 0, totalSum2 = 0;

	StringBuilder toFile = new StringBuilder();
	
	toFile.append("N SIZE" + COLUM_SEPARATOR + "FILL IN" + COLUM_SEPARATOR + "SUM_1" + COLUM_SEPARATOR + "SUM_2" + "\n");
	
	for (int n = MIN_LOAD_FACTOR; n <= MAX_LOAD_FACTOR; n += 1) {
	    for (int repeticion = 0; repeticion <= FILL_FACTOR; repeticion++) {
		a = new int[n][n];
		t1 = System.currentTimeMillis();
		Diagonal1.fillIn(a);
		t2 = System.currentTimeMillis();

		totalFill += (t2 - t1);
	    }

	    for (int repeticion = 0; repeticion <= SUM_1_FACTOR; repeticion++) {
		a = new int[n][n];
		t3 = System.currentTimeMillis();
		Diagonal1.sum1Diagonal(a);
		t4 = System.currentTimeMillis();

		totalSum1 += (t4 - t3);
	    }

	    for (int repeticion = 0; repeticion <= SUM_2_FACTOR; repeticion++) {
		a = new int[n][n];
		t4 = System.currentTimeMillis();
		Diagonal1.sum2Diagonal(a);
		t5 = System.currentTimeMillis();

		totalSum2 += (t5 - t4);
	    }
	
	    String res = ("SIZE = " + n + " ** " + "TIME FILL= " + (totalFill) + "ms ** " + "TIME SUM_1= " + (totalSum1) + "ms ** " + "TIME SUM_2= " + (totalSum2) + "ms ");
	    toFile.append(n + COLUM_SEPARATOR + ((float)totalFill/FILL_FACTOR) + COLUM_SEPARATOR + ((float)totalSum1/SUM_1_FACTOR) + COLUM_SEPARATOR + ((float)totalSum2/SUM_2_FACTOR) + "\n");
	    System.out.println(res);
	}
	try {
	    FilesImproved.writeFileFromString(PATH, FILE_NAME, toFile.toString(), ".csv", FilesImproved.UTF_8);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}

    } // main

} // class
