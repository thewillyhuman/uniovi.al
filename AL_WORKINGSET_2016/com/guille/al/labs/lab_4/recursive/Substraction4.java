package com.guille.al.labs.lab_4.recursive;

public class Substraction4 {
    public static long rec4(int n) {
	long cont = 0;
	if (n <= 0)
	    cont++;
	else {
	    cont++; // O(1)
	    rec4(n - 2);
	    rec4(n - 2);
	    rec4(n - 2);
	}
	return cont;
    }

    public static void main(String arg[]) {
	long t1, t2, cont = 0;
	for (int n = 1; n <= 100; n++) {
	    t1 = System.currentTimeMillis();

	    cont = rec4(n);

	    t2 = System.currentTimeMillis();

	    System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
	} // for
    } // main

}
