package com.guille.al.labs.lab_1;

/**
 * This program serves to measure times of 
 * the addition operation
 * @author viceg
 */
public class Vector2 {
	static int[] v;
	
	public static void main (String arg []){
	  int n = Integer.parseInt(arg[0]); //Size of the problem
	  v = new int[n];
	  Vector1.fillIn(v);
	  
	  //Measurement of times
	  long t1,t2;
	  t1 = System.currentTimeMillis();	
	  int s = Vector1.sum(v);
	  t2 = System.currentTimeMillis();
	  
	  System.out.println ("SIZE = " + n + " ** " + "TIME = " + (t2-t1) + "ms");   
	 
	  System.out.println ("THE SUM OF ELEMENTS IS = "+ s);
	}
} 
