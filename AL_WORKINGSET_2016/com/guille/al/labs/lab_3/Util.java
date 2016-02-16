package com.guille.al.labs.lab_3;

public class Util {
	
	/**
	 * Interchange element i and element j
	 * @param elements
	 * @param i
	 * @param j
	 */
	public static void interchange(int[] elements, int i, int j) {
		int temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	
	/**
	 * Find the position of the smallest element
	 * @param elements
	 * @param firstElement
	 * @return position of the element
	 */
	public static int findPosMin(int[] elements, int firstElement) {
		int value = Integer.MAX_VALUE;
		int pos = Integer.MAX_VALUE;
		for (int i = firstElement; i < elements.length; i++){
			if (elements[i] < value){
				value = elements[i];	
				pos = i;
			}
		}
		return pos;
	}
	
}
