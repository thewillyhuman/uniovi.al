package com.guille.al.labs.lab_5;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import com.guille.al.labs.lab_3.Vector;

/* This program can be used to sort n elements with 
 * the best algorithm. It is the QUICKSORT */
public class QuicksortCentralElementParallel extends RecursiveAction {

	private static final long serialVersionUID = 1L;
	public int[] v;
	public int left;
	public int right;

	public static void main(String[] args) {
		int[] v = new int[100000];
		Vector.random(v, 10000);
		Vector.write(v);
		QuicksortCentralElementParallel problem = new QuicksortCentralElementParallel(
				v, 0, v.length - 1);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(problem);
		Vector.write(v);
		System.out.println("Is correctly sorted: " + Vector.isSorted(v));
	}

	/**
	 * The main constructor of the class. Sets the variables of the class.
	 * 
	 * @param v
	 *            is the vector of elements that will be sorted.
	 * @param left
	 *            index to start sorting.
	 * @param right
	 *            index to end sorting.
	 */
	public QuicksortCentralElementParallel(int[] v, int left, int right) {
		this.v = v;
		this.left = left;
		this.right = right;
	}

	@Override
	public void compute() {
		if (right > left) {
			int pivot = partition(v, left, right);
			QuicksortCentralElementParallel qLeft = new QuicksortCentralElementParallel(
					v, left, pivot - 1);
			QuicksortCentralElementParallel qRight = new QuicksortCentralElementParallel(
					v, pivot + 1, right);
			invokeAll(qLeft, qRight);
		}
	}

	/**
	 * Partition method.
	 * 
	 * @param v
	 *            is the vector to be separated.
	 * @param left
	 *            index
	 * @param right
	 *            index.
	 * @return
	 */
	private static int partition(int[] v, int left, int right) {
		int pivo = v[left];
		int i = left + 1, f = right;
		while (i <= f) {
			if (v[i] <= pivo) {
				i++;
			} else if (pivo < v[f]) {
				f--;
			} else {
				int troca = v[i];
				v[i] = v[f];
				v[f] = troca;
				i++;
				f--;
			}
		}
		v[left] = v[f];
		v[f] = pivo;
		return f;
	}
}
