package com.guille.al.labs.lab_1;

/**
 * This program serves to measure times automatically increasing 
 * the size of the problem. In addition, we use a repetition value 
 * determined by nTimes, an argument of the program 
 * @author viceg
 */
public class Vector4 {
	static int[]v;
	
	public static void main(String arg []) {
		int nTimes = Integer.parseInt(arg[0]);
		long t1,t2;
		int sum = 0;
		
		for (int n=10; n<=100000000; n*=5){ //n is increased *5   
			  v = new int[n];
			  Vector1.write(v);
			  
			  t1 = System.currentTimeMillis();
			  //We have to repeat the whole process to be measured
			  for (int repetition=1; repetition<=nTimes; repetition++){    	
			     sum = Vector1.sum(v);
			  }
			  t2 = System.currentTimeMillis();
			  System.out.println ("SIZE = "+n+" ** "+"TIME = "+(t2-t1)+"ms ** "+ " SUM = " + sum + " ** nTimes = " + nTimes);   
		}//for 
		
	}//main

}
