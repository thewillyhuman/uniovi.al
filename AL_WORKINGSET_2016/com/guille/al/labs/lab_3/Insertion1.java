package com.guille.al.labs.lab_3;

/* This program can be used to sort n elements with 
 * a "bad" algorithm (quadratic). 
 * It is the DIRECT INSERTION */
public class Insertion1{
	static int []v;
	
	public static void main (String arg [] ){
	  int n= Integer.parseInt (arg[0]);  //size of the problem 
	  v = new int [n] ;
	  
	  Vector.sorted(v);
	  System.out.println ("VECTOR TO BE SORTED:");
	  Vector.write(v);	
	  insertion(v);
	  System.out.println ("SORTED VECTOR:");
	  Vector.write(v);
	
	  Vector.inverselySorted (v);
	  System.out.println ("VECTOR TO BE SORTED:");
	  Vector.write(v);	
	  insertion(v);
	  System.out.println ("SORTED VECTOR:");
	  Vector.write(v);
	
	  Vector.random(v, 1000000);
	  System.out.println ("VECTOR TO BE SORTED:");
	  Vector.write(v);	
	  insertion(v);
	  System.out.println ("SORTED VECTOR:");
	  Vector.write(v);
	} 
	
	public static void insertion(int[] elements) {
	}
	
} 
