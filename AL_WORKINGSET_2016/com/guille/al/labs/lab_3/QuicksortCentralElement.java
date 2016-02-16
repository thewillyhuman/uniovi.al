package com.guille.al.labs.lab_3;

/* This program can be used to sort n elements with 
 * the best algorithm. It is the QUICKSORT */
public class QuicksortCentralElement
	{
	static int []v;
	
	public static void main (String arg [] ){
	  int n= Integer.parseInt (arg[0]);  //size of the problem
	  v = new int [n];
	
	  Vector.sorted(v);
	  System.out.println("VECTOR TO BE SORTED:");
	  Vector.write(v);	
	  quicksort(v);
	  System.out.println("SORTED VECTOR:");
	  Vector.write(v);
	
	  Vector.inverselySorted (v);
	  System.out.println("VECTOR TO BE SORTED:");
	  Vector.write(v);	
	  quicksort(v);
	  System.out.println("SORTED VECTOR:");
	  Vector.write(v);
	  
	  Vector.random(v, 1000000);
	  System.out.println("VECTOR TO BE SORTED:");
	  Vector.write(v);	
	  quicksort(v);
	  System.out.println("SORTED VECTOR:");
	  Vector.write(v);
	} 
	
	private static void quickSort(int elements[], int left, int right){
	}
	
	public static void quicksort(int[] elements) {
		quickSort(elements, 0, elements.length-1);
	}
} 
