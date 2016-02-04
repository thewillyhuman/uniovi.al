package com.guille.al.labs.lab_1;

/**
 * This program serves to measure times automatically 
 * increasing the size of the problem
 * @author viceg
 */
public class Vector3 {
	static int []v;

	public static void main(String arg []) {
		long t1,t2;
		int sum = 0;
		
		for (int n=10; n<=100000000; n*=5) { //n is increased *5   
		  v = new int[n];
		  Vector1.fillIn(v);

		  t1=System.currentTimeMillis();	
		  sum = Vector1.sum(v);
		  t2=System.currentTimeMillis();
		  System.out.println ("SIZE = "+n+" ** "+ "TIME = "+(t2-t1) + "ms" + " ** SUM = " + sum);   
		} //for
	}//main

} 
