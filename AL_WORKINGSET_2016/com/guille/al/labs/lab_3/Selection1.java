package com.guille.al.labs.lab_3;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the SELECTION */
public class Selection1{
	static int []v;
	
	public static void main (String arg [] ){
	  int n= Integer.parseInt (arg[0]);  //size of the problem  
	  v = new int [n] ;
	 
	  Vector.sorted (v);
	  System.out.println ("VECTOR TO BE SORTED:");
	  Vector.write (v);	
	  selection(v);
	  System.out.println ("SORTED VECTOR:");
	  Vector.write (v);
	
	  Vector.inverselySorted (v);
	  System.out.println ("VECTOR TO BE SORTED:");
	  Vector.write (v);	
	  selection(v);
	  System.out.println ("SORTED VECTOR:");
	  Vector.write (v);
	
	  Vector.random(v, 1000000);
	  System.out.println ("VECTOR TO BE SORTED:");
	  Vector.write (v);	
	  selection (v);
	  System.out.println ("SORTED VECTOR:");
	  Vector.write (v);
	} 
	
	/**
	 * Performs the selection sorting algorithm for n size and random vector.
	 * 
	 * @param n the size of the problem.
	 */
	public static void runSelectionRandom(int n) {
	    int[] vector = new int[n];
	    Vector.random(vector, 1000000);
	    selection(vector);
	}
	
	/**
	 * Performs the selection sorting algorithm for n size and sorted vector.
	 * 
	 * @param n the size of the problem.
	 */
	public static void runSelectionSorted(int n) {
	    int[] vector = new int[n];
	    Vector.sorted(vector);
	    selection(vector);
	}
	
	/**
	 * Performs the selection sorting algorithm for n size and inverse sorted vector.
	 * 
	 * @param n the size of the problem
	 */
	public static void runSelectionInvSorted(int n) {
	    int[] vector = new int[n];
	    Vector.inverselySorted(vector);
	    selection(vector);
	}
	
	/**
	 * Performs the selection sorting algorithm.
	 * Algorithm:
	 * For i <-- 0 until i < elements size -1
	 * 	find the minimum element from i --> elements size - 1
	 * 	swap it with the current i position.
	 * 
	 * @param elements to be sorted.
	 */
	public static void selection(int[] elements) {
	    for(int i = 0; i < elements.length-1; i++) {
		Util.interchange(elements, i, Util.findPosMin(elements, i));
	    }
	}
} 
