package com.guille.al.labs.lab_3;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the BUBBLE or DIRECT EXCHANGE */
public class Bubble1{
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
	} // fin de main
	
	public static void bubble(int[] elements) {
	}
} 

