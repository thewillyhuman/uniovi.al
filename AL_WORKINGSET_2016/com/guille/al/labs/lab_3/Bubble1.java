package com.guille.al.labs.lab_3;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the BUBBLE or DIRECT EXCHANGE */
public class Bubble1 {
	static int []v;

	public static void main (String arg [] ){
	  int n=Integer.parseInt(arg[0]);  //size of the problem
	  v = new int[n] ;
	
	  Vector.sorted(v);
	  System.out.println("VECTOR TO BE SORTED:");
	  Vector.write(v);	
	  bubble(v);
	  System.out.println("SORTED VECTOR:");
	  Vector.write (v);
	
	  Vector.inverselySorted(v);
	  System.out.println("VECTOR TO BE SORTED:");
	  Vector.write(v);	
	  bubble(v);
	  System.out.println("SORTED VECTOR:");
	  Vector.write(v);
	
	  Vector.random(v, 1000000);
	  System.out.println("VECTOR TO BE SORTED:");
	  Vector.write(v);	
	  bubble(v);
	  System.out.println("SORTED VECTOR:");
	  Vector.write(v); 
	} // end of the main
	
	/**
	 * This method runs the bubble method for a given length.
	 * 
	 * @param n size of the problem.
	 */
	public static void runBubbleRandom(int n) {
	    int[] vector = new int[n] ;
	    Vector.random(vector, 1000000);
	    bubble(vector);
	}
	
	/**
	 * This method runs the bubble method for a given length.
	 * 
	 * @param n size of the problem.
	 */
	public static void runBubbleSorted(int n) {
	    int[] vector = new int[n] ;
	    Vector.sorted(vector);
	    bubble(vector);
	}
	
	/**
	 * This method runs the bubble method for a given length.
	 * 
	 * @param n size of the problem.
	 */
	public static void runBubbleInvSorted(int n) {
	    int[] vector = new int[n] ;
	    Vector.inverselySorted(vector);
	    bubble(vector);
	}
	
	/**
	 * For a given array of integers will perform the bubble short algorithm.
	 * Pseudocode.
	 * For i = 1 --> i < length elements.
	 * 	For j = 0 --> j < length of elements - i.
	 * 		if ( element[i] > elements[i+1]
	 * 			aux <-- elements[j]
	 * 			elements[j] <-- elements[j+1]
	 * 			elements[j+1] <-- aux
	 * 
	 * @param elements to be sorted.
	 */
	public static void bubble(int[] elements) {
	    // For all elements.
	    for(int i = 1; i < elements.length; i++) {
		// For the rest of elements.
		for(int j = 0; j < elements.length-i; j++) {
		    // If the element to the right is smaller.
		    if(elements[j] > elements[j+1]) {
			// Save the previous value of the element.
			int aux = elements[j];
			// Substitute the current element by the one in the right.
			elements[j] = elements[j+1];
			// Change the element in the right to the previous left one.
			elements[j+1] = aux;
		    }
		}
	    }
	}
} 

