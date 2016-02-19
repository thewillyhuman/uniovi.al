package com.guille.al.labs.lab_3;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the DIRECT INSERTION */
public class Insertion1 {
    static int[] v;

    public static void main(String arg[]) {
	int n = Integer.parseInt(arg[0]); // size of the problem
	v = new int[n];

	Vector.sorted(v);
	System.out.println("VECTOR TO BE SORTED:");
	Vector.write(v);
	insertion(v);
	System.out.println("SORTED VECTOR:");
	Vector.write(v);

	Vector.inverselySorted(v);
	System.out.println("VECTOR TO BE SORTED:");
	Vector.write(v);
	insertion(v);
	System.out.println("SORTED VECTOR:");
	Vector.write(v);

	Vector.random(v, 1000000);
	System.out.println("VECTOR TO BE SORTED:");
	Vector.write(v);
	insertion(v);
	System.out.println("SORTED VECTOR:");
	Vector.write(v);
    }

    /**
     * Performs the selection sorting algorithm for n size and random vector.
     * 
     * @param n the size of the problem.
     */
    public static void runInsertionRandom(int n) {
	int[] vector = new int[n];
	Vector.random(vector, 1000000);
	insertion(vector);
    }

    /**
     * Performs the selection sorting algorithm for n size and sorted vector.
     * 
     * @param n the size of the problem.
     */
    public static void runInsertionSorted(int n) {
	int[] vector = new int[n];
	Vector.sorted(vector);
	insertion(vector);
    }

    /**
     * Performs the selection sorting algorithm for n size and inverse sorted
     * vector.
     * 
     * @param n the size of the problem
     */
    public static void runInsertionInvSorted(int n) {
	int[] vector = new int[n];
	Vector.inverselySorted(vector);
	insertion(vector);
    }

    /**
     * Performs the Insertion sorting algorithm. Algorithm: j <-- 1 until
     * elements size while j > 0 and the elements in the left is greater than
     * the one in the right Swap the value in the right with the one in the
     * left. j <-- j-1;
     * 
     * @param elements to be sorted.
     */
    public static void insertion(int[] elements) {
	for (int j = 1; j < elements.length; j++) {
	    while (j > 0 && elements[j - 1] > elements[j]) {
		Util.interchange(elements, j, j - 1);
		j--;
	    }
	}
    }
}
