package com.guille.al.labs.lab_6;

public class Person {

    private String name;
    private int credit = 0;
    private int debt = 0;
    private int balance = 0;

    public Person(String name) {
	this.name = name;
    }
    
    public void setname(String name) {
	this.name = name;
    }
    
    public String getName() {
	return this.name;
    }
     
    public void sends(int decrease) {
	this.debt = debt - decrease;
	computeBalance();
    }
    
    public void recieves(int increase) {
	this.credit = credit + increase;
	computeBalance();
    }
    
    private void computeBalance() {
	this.balance = debt + credit;
    }
    
    public int getCredit() {
	return this.credit;
    }
    
    public int getDebt() {
	return this.debt;
    }

    public int getBalance() {
	return this.balance;
    }
    
    public String toString() {
	return this.name;
    }
}
