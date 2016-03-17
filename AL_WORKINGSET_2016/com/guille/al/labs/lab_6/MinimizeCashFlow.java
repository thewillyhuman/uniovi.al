package com.guille.al.labs.lab_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MinimizeCashFlow {

    List<Payment> payments; // List of payments.
    int graph[][];
    int result[][];

    public MinimizeCashFlow() {
	payments = new ArrayList<Payment>();
    }

    public void calculate() {
	this.graph = loadDataIntoGraph();
	minCashFlow(this.graph);
    }

    public int[][] loadDataIntoGraph() {
	int size = Persons.getPersons().size();
	int graph[][] = new int[size][size];
	this.result = new int[size][size];
	for (Payment p : payments) {
	    int from = Persons.getIndexOf(p.getFrom());
	    int to = Persons.getIndexOf(p.getTo());
	    graph[from][to] = p.getAmount();
	}
	return graph;
    }

    // A utility function that returns index of maximum value in arr[]
    int getMax(int arr[]) {
	int maxInd = 0;
	for (int i = 1; i < arr.length; i++)
	    if (arr[i] > arr[maxInd])
		maxInd = i;
	return maxInd;
    }

    int getMin(int arr[]) {
	int minInd = 0;
	for (int i = 1; i < arr.length; i++)
	    if (arr[i] < arr[minInd])
		minInd = i;
	return minInd;
    }

    void minCashFlowRec(int amount[]) {
	// Find the indexes of minimum and maximum values in amount[]
	// amount[mxCredit] indicates the maximum amount to be given
	// (or credited) to any person .
	// And amount[mxDebit] indicates the maximum amount to be taken
	// (or debited) from any person.
	// So if there is a positive value in amount[], then there must
	// be a negative value
	int mxCredit = getMax(amount), mxDebit = getMin(amount);

	// If both amounts are 0, then all amounts are settled
	if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
	    return;

	// Find the minimum of two amounts
	int min = Math.min(-amount[mxDebit], amount[mxCredit]);
	amount[mxCredit] -= min;
	amount[mxDebit] += min;

	// If minimum is the maximum amount to be
	result[mxDebit][mxCredit] = min;

	// Recur for the amount array. Note that it is guaranteed that
	// the recursion would terminate as either amount[mxCredit]
	// or amount[mxDebit] becomes 0
	minCashFlowRec(amount);
    }

    // Given a set of persons as graph[] where graph[i][j] indicates
    // the amount that person i needs to pay person j, this function
    // finds and prints the minimum cash flow to settle all debts.
    void minCashFlow(int graph[][]) {
	// Create an array amount[], initialize all value in it as 0.
	int amount[] = new int[graph.length];

	// Calculate the net amount to be paid to person 'p', and
	// stores it in amount[p]. The value of amount[p] can be
	// calculated by subtracting debts of 'p' from credits of 'p'
	for (int p = 0; p < graph.length; p++)
	    for (int i = 0; i < graph[p].length; i++)
		amount[p] += (graph[i][p] - graph[p][i]);

	minCashFlowRec(amount);
    }

    public Person findMaxCreditor() {
	Person aux = Persons.getPersons().get(0);
	for (Person p : Persons.getPersons()) {
	    if (p.getCredit() > aux.getCredit())
		aux = p;
	}
	return aux;
    }

    public Person findMaxDebtor() {
	Person aux = Persons.getPersons().get(0);
	for (Person p : Persons.getPersons()) {
	    if (p.getDebt() < aux.getDebt())
		aux = p;
	}
	return aux;
    }

    public int getFinalDebt(String from, String to) {
	int indexFrom = Persons.getIndexOf(Persons.getPersorn(from));
	int indexTo = Persons.getIndexOf(Persons.getPersorn(to));
	
	return this.result[indexFrom][indexTo];
    }

    public void addPayment(Payment payment) {
	if (payment.isCorrupted())
	    throw new IllegalArgumentException("The payment: " + payment.toString() + "is corrupted.");
	payments.add(payment);
    }

    /**
     * Loads the data contained in the file to the list of payments.
     * 
     * @param file where the payments are.
     * @return a MinimizeCashFlow containing all the payments.
     * @throws IOException
     */
    @SuppressWarnings("resource")
    public static MinimizeCashFlow loadDataFromFile(String file) throws IOException {
	MinimizeCashFlow cashFlow = new MinimizeCashFlow(); // Create an object to work
	// Input
	BufferedReader br;
	br = new BufferedReader(new FileReader(file)); // Read the specified file
	String line;
	line = br.readLine();

	while (line != null) { // Compute all the payments in the text file
	    String[] values = line.split(" ");
	    String source = values[0]; // Person that pays some money
	    String target = values[1]; // Person that receives some money
	    int value = Integer.valueOf(values[2]); // Amount of money

	    Payment payment = new Payment(source, target, value); // Create a payment with the initial information
	    cashFlow.addPayment(payment); // Add the payment to the program

	    line = br.readLine();
	}
	return cashFlow;
    }
}
