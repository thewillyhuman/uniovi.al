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

    private static void quickSort(int arr[], int left, int right) {
	int i = left, j = right;
	int tmp;
	int pivot = arr[(left + right) / 2];

	while (i <= j) {
	    while (arr[i] < pivot)
		i++;
	    while (arr[j] > pivot)
		j--;
	    if (i <= j) {
		tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		i++;
		j--;
	    }
	}
    }

    public static void quicksort(int[] elements) {
	quickSort(elements, 0, elements.length - 1);
    }
}
