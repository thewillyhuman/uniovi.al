package com.guille.al.labs.lab_1;

import java.io.PrintWriter;

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

    public static void main(String arg[]) {
	int nTimes = Integer.parseInt(arg[0]);
	long t1, t2, t3, t4, t5, t6;
	long sumTFillIn = 0;
	long sumTSum = 0;
	int sum = 0;

	for (int n = 10; n <= 100000000; n *= 5) { // n is increased *5
	    v = new int[n];
	    Vector1.fillIn(v);
	    // We have to repeat the whole process to be measured
	    for (int repetition = 1; repetition <= nTimes * 1000000; repetition++) {
		// Vector1.fillIn(v);
		t1 = System.currentTimeMillis();
		sum = Vector1.sum(v);
		t2 = System.currentTimeMillis();
		sumTFillIn += (t2 - t1);
	    }

	    t3 = System.currentTimeMillis();
	    // We have to repeat the whole process to be measured
	    for (int repetition = 1; repetition <= nTimes * 100000; repetition++) {
		Vector1.fillIn(v);
	    }
	    t4 = System.currentTimeMillis();

	    int[] max = new int[2];
	    // We have to repeat the whole process to be measured
	    for (int repetition = 1; repetition <= nTimes * 1000000; repetition++) {
		// Vector1.fillIn(v);
		t5 = System.currentTimeMillis();
		max = Vector1.maximum(v, max);
		t6 = System.currentTimeMillis();
		sumTSum += (t6 - t5);
	    }
	    sum = sum + 1;
	    String res = ("SIZE = " + n + " ** " + "TIME SUM= " + (sumTFillIn) + "ms ** " + "TIME FILL IN= " + (t4 - t3) + "ms ** " + "TIME MAX= " + (sumTSum) + "ms " + " ** nTimes = " + nTimes);
	    Files.writeFileAndAppend("com/guille/al/files/out/", "vector1_times", res);
	    System.out.println(res);
	}// for

    }// main

}
