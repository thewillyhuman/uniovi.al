package com.guille.al.labs.lab_2;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import com.guille.util.Files;

public class TimeCalculator {

    final static int LOOP_1_FACTOR = 1000;
    final static int LOOP_2_FACTOR = 1000;
    final static int LOOP_3_FACTOR = 1000;
    final static int LOOP_4_FACTOR = 100;
    final static int LOOP_5_FACTOR = 100;
    final static int LOOP_UNKNOWN =  1000;
    static final String PATH = "com/guille/al/files/out/";
    static final String FILE_NAME = "ALL_times";
    static final String COLUM_SEPARATOR = ",";

    /**
     * 
     * @param args nothing expected.
     */
    public static void main(String[] args) {
	int nTimes = 1;
	StringBuilder toFile = new StringBuilder();
	long t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, totalLoop1 = 0, totalLoop2 = 0, totalLoop3 = 0, totalLoop4 = 0, totalLoop5 = 0, totalLoopUnk = 0;

	toFile.append("N SIZE" + COLUM_SEPARATOR + " LOOP 1" + COLUM_SEPARATOR +  "LOOP 2" + COLUM_SEPARATOR +  "LOOP 3" + COLUM_SEPARATOR + "LOOP 4" + COLUM_SEPARATOR + "LOOP 5" + COLUM_SEPARATOR + "UNKNOWN\n");
	// Sample repetition
	for (int n = 10; n <= 100; n += 1) {
	    for (int repeticion = 0; repeticion <= nTimes * LOOP_1_FACTOR; repeticion++) {
		t1 = System.currentTimeMillis();
		Loop1.loop1(n);
		t2 = System.currentTimeMillis();

		totalLoop1 += (t2 - t1);
	    }
	    
	    for (int repeticion = 0; repeticion <= nTimes * LOOP_2_FACTOR; repeticion++) {
		t3 = System.currentTimeMillis();
		Loop2.loop2(n);
		t4 = System.currentTimeMillis();

		totalLoop2 += (t4 - t3);
	    }
	    
	    for (int repeticion = 0; repeticion <= nTimes * LOOP_3_FACTOR; repeticion++) {
		t5 = System.currentTimeMillis();
		Loop3.loop3(n);
		t6 = System.currentTimeMillis();

		totalLoop3 += (t6 - t5);
	    }
	    
	    for (int repeticion = 0; repeticion <= nTimes * LOOP_4_FACTOR; repeticion++) {
		t7 = System.currentTimeMillis();
		Loop4.loop4(n);
		t8 = System.currentTimeMillis();

		totalLoop4 += (t8 - t7);
	    }

	    for (int repeticion = 0; repeticion <= nTimes * LOOP_5_FACTOR; repeticion++) {
		t9 = System.currentTimeMillis();
		Loop5.loop5(n);
		t10 = System.currentTimeMillis();

		totalLoop5 += (t10 - t9);
	    }
	    
	    for (int repeticion = 0; repeticion <= nTimes * LOOP_UNKNOWN; repeticion++) {
		t11 = System.currentTimeMillis();
		Unknown.unknown(n);
		t12 = System.currentTimeMillis();

		totalLoopUnk += (t12 - t11);
	    }
	    
	    System.out.println((((float)n/100.0) * 100)+ "% COMPLETED...");
	    
	    toFile.append(n + ";" + ((float)totalLoop1/LOOP_1_FACTOR) + COLUM_SEPARATOR + ((float)totalLoop2/LOOP_2_FACTOR) + COLUM_SEPARATOR + ((float)totalLoop3/LOOP_3_FACTOR) + COLUM_SEPARATOR + ((float)totalLoop4/LOOP_4_FACTOR) + COLUM_SEPARATOR + ((float)totalLoop5/LOOP_5_FACTOR) + COLUM_SEPARATOR + ((float)totalLoopUnk/LOOP_UNKNOWN) + "\n");
	}
	try {
	    Files.writeFileFromString(PATH, FILE_NAME, toFile.toString(), ".csv", Files.UTF_8);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
	}

    }

}
