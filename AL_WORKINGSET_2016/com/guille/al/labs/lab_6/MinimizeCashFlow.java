package com.guille.al.labs.lab_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MinimizeCashFlow {

    List<Payment> payments; // List of payments.

    public MinimizeCashFlow() {
	payments = new ArrayList<Payment>();
    }

    public void calculate() {
    }

    public int getFinalDebt(String from, String to) {

	return -1;
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
