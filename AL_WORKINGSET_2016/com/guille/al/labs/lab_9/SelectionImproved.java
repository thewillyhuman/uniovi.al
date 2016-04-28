package com.guille.al.labs.lab_9;

import java.util.ArrayList;

import com.guille.al.labs.lab_9.util.BranchAndBound;
import com.guille.al.labs.lab_9.util.Node;

/**
 * ..IMPROVE THAT..
 * PROBLEM : From n positive integer elements (>0), take
 * k elements that sum a given amount c
 * Develop the tree of states with backtracking with 3 prunings
 * (taken<k) => we should stop if we took k elements
 * (sum<c) => we should stop if we reach or exceed c. Note that all the elements are positive >0
 * (n-level>=k-taken) => we should stop if the number of elements to be processed is < 
 * than the remaining elements to complete K, since we are not going to reach k elements
 * 
 * @author Guillermo Facundo Colunga
 *
 */
public class SelectionImproved extends BranchAndBound {

    /**
     * First problem constructor.
     * 
     * @param n
     *            is size of the vector of keys.
     * @param k
     *            is number of keys we will take.
     * @param s
     *            is the total sum the k keys from the vector of n elements will
     *            sum.
     */
    public SelectionImproved(int n, int k, int s) {
	rootNode = new State(n, k, s);
    }

    class State extends Node {

	int numberOfElements; // The number of elements in the vector.
	int keys; // The number of keys we will choose.
	int sum; // The final sum we have to achieve.
	int partialSum; // The partial sum at this level of the tree.
	int[] vector; // the whole vector containing all the keys.

	/**
	 * Constructor for the first state / node.
	 * 
	 * @param n
	 *            is the size of the problem.
	 * @param k
	 *            the number of keys we will take.
	 * @param s
	 *            the exact sum the k keys will sum.
	 */
	public State(int n, int k, int s) {
	    this.numberOfElements = n;
	    this.keys = k;
	    this.sum = s;
	    vector = new int[n];
	    partialSum = 0;

	    // Setting the both vector to its start state.
	    for (int i = 0; i < n; i++) {
		vector[i] = i + 1;
	    }
	}

	/**
	 * Constructor to generate more states.
	 * 
	 * @param parent
	 *            parent state.
	 * @param j
	 *            is the depth of the state.
	 */
	public State(State parent, int j) {
	    super();
	    depth = parent.depth;
	    parentID = parent.getID();
	    this.numberOfElements = parent.numberOfElements;
	    this.keys = parent.keys;
	    this.sum = parent.sum;
	    this.vector = parent.vector.clone();
	    this.partialSum = parent.partialSum;
	    depth++;

	    vector[depth] = vector[depth - 1] + 1;
	    this.partialSum += vector[depth];

	    // Update the heuristic value.
	    calculateHeuristicValue();
	}

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("============");
	    for (int i = 0; i < this.numberOfElements; i++) {
		if (vector[i] != 0) {
		    sb.append("THE STATE: n = " + i + " THAT IS key = "
			    + this.vector[i] + " IS PARTIAL SOLUTION");
		}
	    }
	    sb.append("============");
	    return sb.toString();
	}

	@Override
	public void calculateHeuristicValue() {
	    heuristicValue = Integer.MAX_VALUE;
	    for (int i = 0; i < this.numberOfElements; i++) {
		if (this.vector[i] != 0)
		    heuristicValue -= this.vector[i];
	    }
	}

	@Override
	public ArrayList<Node> expand() {
	    ArrayList<Node> result = new ArrayList<Node>();
	    if (this.partialSum <= this.sum && this.depth <= this.keys
		    && depth < this.numberOfElements) {
		Node child = new State(this, depth);
		result.add(child);
	    }
	    return result;
	}

	@Override
	public boolean isSolution() {
	    if (this.depth == this.keys && this.sum == this.partialSum)
		return true;
	    else
		return false;
	}

    }
}
