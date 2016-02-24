package com.guille.al.labs.lab_3;

/* This program can be used to sort n elements with 
 * the best algorithm. It is the QUICKSORT */
public class QuicksortCentralElement {
    static int[] v;

    public static void main(String arg[]) {
	int n = Integer.parseInt(arg[0]); // size of the problem
	v = new int[n];

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

    /**
     * Performs the selection sorting algorithm for n size and random vector.
     * 
     * @param n the size of the problem.
     */
    public static void runSort(int n) {
	int[] vector = new int[n];
	Vector.sorted(vector);
	quicksort(vector);
    }

    /**
     * Performs the selection sorting algorithm for n size and random vector.
     * 
     * @param n the size of the problem.
     */
    public static void runInvSort(int n) {
	int[] vector = new int[n];
	Vector.inverselySorted(vector);
	quicksort(vector);
    }

    /**
     * Performs the selection sorting algorithm for n size and random vector.
     * 
     * @param n the size of the problem.
     */
    public static void runRandom(int n) {
	int[] vector = new int[n];
	Vector.random(vector, 1000000);
	quicksort(vector);
    }

    private static void quickSort(int elements[], int left, int right) {
	int i = left; // index of left-to-right scan
	int k = right; // index of right-to-left scan

	if (right - left >= 1) // check that there are at least two elements to
			      // sort
	{
	    int pivot = elements[left]; // set the pivot as the first element in
				      // the partition

	    while (k > i) // while the scan indices from left and right have not
			  // met,
	    {
		while (elements[i] <= pivot && i <= right && k > i) // from the left,
							       // look for the
							       // first
		    i++; // element greater than the pivot
		while (elements[k] > pivot && k >= left && k >= i) // from the
								 // right, look
								 // for the
								 // first
		    k--; // element not greater than the pivot
		if (k > i) // if the left seekindex is still smaller than
		    Util.interchange(elements, i, k); // the right index, swap the
				       // corresponding elements
	    }
	    Util.interchange(elements, left, k); // after the indices have crossed, swap the
				   // last element in
				   // the left partition with the pivot
	    quickSort(elements, left, k - 1); // quicksort the left partition
	    quickSort(elements, k + 1, right); // quicksort the right partition
	} else // if there is only one element in the partition, do not do any
	       // sorting
	{
	    return; // the array is sorted, so exit
	}
    }

    public static void quicksort(int[] elements) {
	quickSort(elements, 0, elements.length - 1);
    }
}
