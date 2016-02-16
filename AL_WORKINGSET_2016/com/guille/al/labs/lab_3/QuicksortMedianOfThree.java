package com.guille.al.labs.lab_3;

/* This program can be used to sort n elements with 
 * the best algorithm. It is the QUICKSORT */
public class QuicksortMedianOfThree
	{
	static int []v;
	
	public static void main (String arg [] ){
	  int n= Integer.parseInt(arg[0]);  //size of the problem
	  v = new int [n];
	
	  Vector.sorted(v);
	  System.out.println("VECTOR TO BE SORTED:");
	  Vector.write(v);	
	  quicksort(v);
	  System.out.println("SORTED VECTOR:");
	  Vector.write(v);
	
	  Vector.inverselySorted(v);
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
	
	/*get the position of the median of the three (left, right and 
	 the element which position is in the center between them, and
	 move the elements to order them */
	private static int median_of_three(int elements[], int left, int right){ 
		int center = (left + right) / 2;
		if (elements[left] > elements[center])
			Util.interchange(elements, left, center);
		if (elements[left] > elements[right])
			Util.interchange(elements, left, right);
		if (elements[center] > elements[right])
			Util.interchange(elements, center, right);
		return center;
	}
	
	private static void quickSort(int elements[], int left, int right){
		int i = left;
		int j = right - 1;
		int pivot;
		
		if (left < right){ //if there is one element it is not necessary
			int center = median_of_three(elements, left, right);
			//if there are less than or equal to 3 elements, there are just ordered
			if ((right - left) >= 3){ 
				pivot = elements[center]; //choose the pivot
				Util.interchange(elements, center, right); //hide the pivot

				do {         
			    	while (elements[i] <= pivot && i < right) i++; //first element > pivot
			    	while (elements[j] >= pivot && j > left) j--; //first element < pivot
			        if (i < j) Util.interchange(elements, i, j);
			    } while (i < j);   //end while
				
				//we set the position of the pivot
				Util.interchange(elements, i, right);
				quickSort(elements, left, i-1);
				quickSort(elements, i+1, right);		
			} //if
		} //if
	}
	
	public static void quicksort(int[] elements) {
		quickSort(elements, 0, elements.length-1);
	}
} 
