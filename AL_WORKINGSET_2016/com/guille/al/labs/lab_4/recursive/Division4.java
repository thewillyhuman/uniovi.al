package com.guille.al.labs.lab_4.recursive;

public class Division4 {

    /**
     * a<b^k k=2 a=4 b=2
     * 
     * @param n
     * @return
     */
    public static long rec4(int n) {
	long cont = 0;
	if (n <= 0)
	    cont++;
	else {
	    for (int i = 0; i < n * n; i++) // O(n^2)
		cont++;
	    rec4(n / 2); // a = 1, b = 2, k = 2 ==> 1 < 4(2^2).
	}
	return cont;
    }

    public static void main(String arg[]) {
	long t1, t2, cont = 0;
	for (int n = 1; n <= 10000000; n *= 2) {
	    t1 = System.currentTimeMillis();

	    cont = rec4(n);

	    t2 = System.currentTimeMillis();

	    System.out.println("n=" + n + "**TIME=" + (t2 - t1) + "**cont=" + cont);
	} // for
    } // main

}
