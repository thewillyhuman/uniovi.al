package com.guille.al.labs.lab_6;

/**
 * Payment class.
 * 
 * Warning: Once created the payment cannot be modified.
 * 
 * @author thGFC, the one, the only, the brave.
 *
 */
public class Payment {

    private Person from; // Source of the payment.
    private Person to; // Destination of the payment.
    private int amount; // Amount of the payment.

    /**
     * Creates a payment.
     * 
     * @param from is the source of the payment.
     * @param to is the destination of the payment.
     * @param amount that contains the payment
     */
    public Payment(String from, String to, int amount) {
	if (from == null)
	    throw new IllegalArgumentException("The source of the payment is not valid.");
	if (to == null)
	    throw new IllegalArgumentException("The destination of the payment is not valid.");
	if (amount < 0)
	    throw new IllegalArgumentException("Payments cannot be negative.");

	if(Persons.contains(from)) {
	    this.from = Persons.getPersorn(from);
	} else {
	    this.from = Persons.addPerson(new Person(from));
	}
	
	if(Persons.contains(to)) {
	    this.to = Persons.getPersorn(to);
	} else {
	    this.to = Persons.addPerson(new Person(to));
	}
	
	this.amount = amount;
    }

    public Person getFrom() {
	return this.from;
    }
    
    public Person getTo() {
	return this.to;
    }
    
    public int getAmount() {
	return this.amount;
    }
    
    /**
     * If the payment does not follow some rules won't be accepted.
     * 
     * @return true if there exits a source and a destination. And if the amount is positive. False otherwise.
     */
    public boolean isCorrupted() {
	if (from.getName().length() < 0 && from.getName().length() < 0 && from.getName().compareTo(to.getName()) != 0 && amount < 0)
	    return true;
	return false;
    }

    @Override
    public String toString() {
	return ("Payment: " + from + ", " + to + ", " + amount);
    }

}
