package com.guille.al.labs.lab_6;

public class Person {

    private String name;
    private int balance;

    public Person(String name) {
	this.name = name;
    }
    
    public void setname(String name) {
	this.name = name;
    }
    
    public String getName() {
	return this.name;
    }
    
    public void setValance(int balance) {
	this.balance = balance;
    }

    public int getBalance() {
	return this.balance;
    }
}
