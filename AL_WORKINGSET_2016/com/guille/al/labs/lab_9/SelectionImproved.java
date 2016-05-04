package com.guille.al.labs.lab_9;

import java.util.ArrayList;

import com.guille.al.labs.lab_9.util.BranchAndBound;
import com.guille.al.labs.lab_9.util.Node;
//import com.guille.util.ArraysImproved;

/**
 * ..IMPROVE THAT.. PROBLEM : From n positive integer elements (>0), take k
 * elements that sum a given amount c Develop the tree of states with
 * backtracking with 3 prunings (taken<k) => we should stop if we took k
 * elements (sum<c) => we should stop if we reach or exceed c. Note that all the
 * elements are positive >0 (n-level>=k-taken) => we should stop if the number
 * of elements to be processed is < than the remaining elements to complete K,
 * since we are not going to reach k elements
 * 
 * @author Guillermo Facundo Colunga
 *
 */
public class SelectionImproved extends BranchAndBound {

    class State extends Node {

	int keys; // The number of keys we will choose.
	int numberOfElements; // The number of elements in the vector.
	int partialSum; // The partial sum at this level of the tree.
	int sum; // The final sum we have to achieve.
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
		vector[i] = 0;
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
	    depth = parent.depth + 1;
	    parentID = parent.getID();
	    this.numberOfElements = parent.numberOfElements;
	    this.keys = parent.keys;
	    this.sum = parent.sum;
	    this.vector = parent.vector.clone();
	    this.partialSum = parent.partialSum;
	    vector[depth] = vector[depth - 1] + 1; // +j if not an iterative
						   // sum.
	    this.partialSum += vector[depth];
	    // ArraysImproved.printVector(vector);

	    // Update the heuristic value.
	    calculateHeuristicValue();
	}

	@Override
	public void calculateHeuristicValue() {
	    heuristicValue = Math.abs(this.sum - this.partialSum);
	}

	@Override
	public ArrayList<Node> expand() {
	    ArrayList<Node> result = new ArrayList<Node>();
	    if (this.partialSum < this.sum && this.depth < this.keys && depth < this.numberOfElements) {
		int counter = 0;
		for (int i = vector[depth] + 1; i <= this.numberOfElements; i++) {
		    Node child = new State(this, counter);
		    result.add(child);
		    counter++;
		}
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

	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Vector /");
	    for (int i = 0; i < this.numberOfElements; i++) {
		if (vector[i] != 0) {
		    sb.append(vector[i]);
		    sb.append("/");
		}
	    }
	    sb.append("/");
	    return sb.toString();
	}

    }

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
}
