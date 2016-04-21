// PROBLEM : From n positive integer elements (>0), take
// k elements that sum a given amount c
// Develop the tree of states with backtracking without pruning

package com.guille.al.labs.lab_9;

public class YouHaveToImproveThis1 {

    static int n;
    static int[] v;
    static int k;
    static int c;
    static boolean[] mark; // whether you get or not an element
    static int sum; // cumulative sum in a state
    static int taken; // how many elements we chose
    static boolean solutionFound;

    public static void main(String arg[]) {
	n = Integer.parseInt(arg[0]);
	k = Integer.parseInt(arg[1]);
	c = Integer.parseInt(arg[2]);
	v = new int[n];

	mark = new boolean[n];
	for (int i = 0; i < n; i++)
	    v[i] = i + 1; // assigning a value for every element
	for (int i = 0; i < n; i++)
	    mark[i] = false;
	taken = 0;
	sum = 0;
	solutionFound = false;

	long t1 = System.currentTimeMillis();
	backtracking(0);
	long t2 = System.currentTimeMillis();
	System.out.println("TIME IN MILISECONDS = " + (t2 - t1));
    }

    static void backtracking(int level) {
	if (level == n) { // we have a complete group to check if it is a
			  // solution
	    if (taken == k && sum == c) {
		solutionFound = true;
		System.out.println();
		System.out.println(k + " SELECTED ELEMENTS THAT ADD UP = " + c);
		for (int i = 0; i < n; i++)
		    if (mark[i])
			System.out.print(v[i] + "/");
		System.out.println();
	    }
	}

	else
	    for (int j = 0; j <= 1; j++)
		if (!solutionFound) {
		    if (j == 1) {
			taken++;
			sum = sum + v[level];
			mark[level] = true;
		    }
		    backtracking(level + 1);
		    if (j == 1) {
			taken--;
			sum = sum - v[level];
			mark[level] = false;
		    }
		}
    }
}
