package com.guille.al.labs.lab_1;

import java.util.Random;

/**
 * This program can solve a problem in two ways. 
 * The problem is to calculate the sum of the elements of the 
 * main diagonal of a square matrix of order n.
 * @author viceg
 */
public class Diagonal1{
	static int [][]a;
	
	public static void main(String arg [] ) {
		int n = Integer.parseInt(arg[0]);
		a = new int[n][n];
	
		fillIn(a);	  
		write(a);
		 
		System.out.println ("FIRST SOLUTION =" + sum1Diagonal(a));	
		System.out.println ("SECOND SOLUTION =" + sum2Diagonal(a));	
	} //main

	public static void runFill(int n) {
	    a = new int[n][n];
	    fillIn(a);
	}
	
	/**
	 * This method gives random values ​​to an array of integers,
	 * using the Random class of the java.util package  
	 * It has a quadratic complexity O(n^2)
	 * @param a Matrix to be filled in
	 */
	public static void fillIn(int[][]a) {
	    Random r= new Random();
	    int n=a.length;
	    for(int i=0;i<n;i++)
	    	for(int j=0;j<n;j++)
	    		a[i][j]= r.nextInt(199)-99; //values between -99 y 99  
	} 
	
	/**
	 * This method writes the square matrix.
	 * It has a quadratic complexity O(n^2)
	 * @param a Matrix with values
	 */
	public static void write(int[][]a) {
	    int n = a.length;
	    for (int i=0; i<n; i++) {
	    	for (int j=0; j<n; j++)
	    		System.out.print(a[i][j]+"\t");
	    	System.out.println();
	    }
	}  
	
	/**
	 * This method iteratively computes the sum of the diagonal
	 * It has a quadratic complexity O(n^2) 
	 * @param a Matrix with numbers
	 * @return The addition of all the numbers of the main diagonal
	 */
	public static int sum1Diagonal(int[][]a) {
	    int n= a.length;
	    int s=0;
	    for(int i=0;i<n;i++)
	    	for(int j=0;j<n;j++)
	    		if (i==j) s=s+a[i][j];
	    return s; 
	}   
	
	/**
	 * This method iteratively computes the sum of the diagonal
	 * It has a linear complexity O(n)
	 * @param a Matrix with numbers
	 * @return The addition of all the numbers of the main diagonal
	 */
	public static int sum2Diagonal(int[][]a) {
	    int n= a.length;
	    int s=0;
	    for(int i=0;i<n;i++)
	      s=s+a[i][i];
	    return s; 
	}    

} 
