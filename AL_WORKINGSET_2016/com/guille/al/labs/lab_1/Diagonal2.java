package com.guille.al.labs.lab_1;

/**
 * This program serves to measure times automatically increasing 
 * the size of the problem (n) and also using a time scale determined
 * by nTimes, which is taken from the argument arg[1]
 * It also gets as an execution argument (arg[0]) the operation on which 
 * we will focus the measurement (options 0,1,2 respectively)
 * @author viceg
 */
public class Diagonal2 {
	static int [][]a;

	@SuppressWarnings("unused")
	public static void main(String arg []) {
		int nTimes = Integer.parseInt(arg[1]); //nTimes
		int option = Integer.parseInt(arg[0]); //selected option
		long t1,t2;
		
		//n is incremented * 2
		   if (option==0){ //fill in the matrix
		   } //if
		   else if (option==1) { //sum of the diagonal (one way)
		   } //else if
		   else if (option==2) { //sum of the diagonal (another way)
		   } //else if
		   else System.out.println("INCORRECT OPTION"); 
	} //main

} //class
