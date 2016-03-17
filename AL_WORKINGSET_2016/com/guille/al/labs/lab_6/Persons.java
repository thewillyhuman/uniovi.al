package com.guille.al.labs.lab_6;

import java.util.ArrayList;
import java.util.List;

public class Persons {

    private static List<Person> people = new ArrayList<Person>();
    
    public static Person addPerson(Person p) {
	if(!people.contains(p))
	    people.add(p);
	else
	    throw new IllegalArgumentException("The person has already been added");
	return p;
    }
    
    public static Person getPersorn(String name) {
	for(Person p : people)
	    if(p.getName().equals(name))
		return p;
	return null;
    }
    
    public static boolean contains(String name) {
	for(Person p : people)
	    if(p.getName().equals(name))
		return true;
	return false;
    }
    
    public static List<Person> getPersons() {
	List<Person> aux = new ArrayList<Person>();
	for(Person p : people)
	    aux.add(p);
	return aux;
    }
    
    public static int getIndexOf(Person p) {
	for(int i = 0; i < people.size(); i++) {
	    if(people.get(i).getName().equals(p.getName()))
		return i;
	}
	return -1;
    }
}
