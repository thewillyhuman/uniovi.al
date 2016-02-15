package com.guille.al.labs.lab_1;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import com.guille.util.Files;

/**
 * This program serves to measure times automatically increasing the size of the
 * problem. In addition, we use a repetition value determined by nTimes, an
 * argument of the program
 * 
 * @author viceg
 */
public class Vector4 {
    static int[] v;
    static final String PATH = "com/guille/al/files/out/";
    static final String FILE_NAME = "vector1_times";
    static final String COLUM_SEPARATOR = ",";
    static final int SUM_FACTOR =  100000; // 5
    static final int FILL_FACTOR = 100000; // 5
    static final int MAX_FACTOR =  1000000; // 6

    public static void main(String arg[]) {
	int nTimes = Integer.parseInt(arg[0]);
	long t1, t2, t3, t4, t5, t6;
	long sumTFillIn = 0;
	long sumTSum = 0;
	int sum = 0;
	StringBuilder toFile = new StringBuilder();
	
	toFile.append("N SIZE" + COLUM_SEPARATOR + "SUM" + COLUM_SEPARATOR + "FILL IN" + COLUM_SEPARATOR + "MAX"+ "\n");
	
	for (int n = 10; n <= 2000; n += 5) { // n is increased *5
	    v = new int[n];
	    Vector1.fillIn(v);
	    // We have to repeat the whole process to be measured
	    for (int repetition = 1; repetition <= nTimes * SUM_FACTOR; repetition++) {
		t1 = System.currentTimeMillis();
		sum = Vector1.sum(v);
		t2 = System.currentTimeMillis();
		sumTFillIn += (t2 - t1);
	    }

	    t3 = System.currentTimeMillis();
	    // We have to repeat the whole process to be measured
	    for (int repetition = 1; repetition <= nTimes * FILL_FACTOR; repetition++) {
		Vector1.fillIn(v);
	    }
	    t4 = System.currentTimeMillis();

	    int[] max = new int[2];
	    // We have to repeat the whole process to be measured
	    for (int repetition = 1; repetition <= nTimes * MAX_FACTOR; repetition++) {
		t5 = System.currentTimeMillis();
		max = Vector1.maximum(v, max);
		t6 = System.currentTimeMillis();
		sumTSum += (t6 - t5);
	    }
	    sum = sum + 1;
	    String res = ("SIZE = " + n + " ** " + "TIME SUM= " + (sumTFillIn) + "ms ** " + "TIME FILL IN= " + ((t4 - t3)) + "ms ** " + "TIME MAX= " + (sumTSum) + "ms " + " ** nTimes = " + nTimes);
	    toFile.append(n + COLUM_SEPARATOR + sumTFillIn + COLUM_SEPARATOR + (t4 - t3) + COLUM_SEPARATOR + sumTSum + "\n");
	    System.out.println(res);
	}// for
	try {
	    Files.writeFileFromString(PATH, FILE_NAME, toFile.toString(), ".csv", Files.UTF_8);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}

    }// main

}
