package com.guille.al.labs.lab_5;

import static org.junit.Assert.*;

import org.junit.Test;

import com.guille.al.labs.lab_3.Vector;

public class QuickSortCentralElementParallelTest {

	@Test
	public void sortingAlgorithmText() {
		int[] v;
		for(int i = 0; i < 10000; i++) {
			v = new int[i];
			Vector.random(v, 10000);
			QuicksortCentralElementParallel.quicksortParallel(v);
			assertEquals(true, Vector.isSorted(v));
		}
	}

}
