package com.guille.al.labs.lab_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Nonogram {
    
    private int size;
    private List<ArrayList<Integer>> verticalRestrictions;
    private List<ArrayList<Integer>> horizontalRestrictions;
    private int[][] board;
    
    public static final String PATH_IN = "com/guille/al/files/in/lab_8/";
    
    public Nonogram(int size) {
	if(size > 0) {
	    this.size = size;
	    board = new int[size][size];
	    verticalRestrictions = new ArrayList<ArrayList<Integer>>();
	    horizontalRestrictions = new ArrayList<ArrayList<Integer>>();
	    loadArrays();
	}
    }
    
    private void loadArrays() {
	ArrayList<Integer> aux;
	for(int i = 0; i < size; i++) {
	    aux = new ArrayList<Integer>();
	    verticalRestrictions.add(aux);
	    horizontalRestrictions.add(aux);
	}
    }
    
    public int getSize() {
	return this.size;
    }
    
    public List<ArrayList<Integer>> getVerticalRestictions() {
	List<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>>();
	for(ArrayList<Integer> arr : verticalRestrictions) {
	    ArrayList<Integer> rest = new ArrayList<Integer>();
	    for(Integer num : arr) {
		rest.add(num);
	    }
	    aux.add(arr);
	}
	return aux;
    } 
    
    public List<ArrayList<Integer>> getHorizontalRestictions() {
	List<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>>();
	for(ArrayList<Integer> arr : horizontalRestrictions) {
	    ArrayList<Integer> rest = new ArrayList<Integer>();
	    for(Integer num : arr) {
		rest.add(num);
	    }
	    aux.add(arr);
	}
	return aux;
    } 
    
    public int[][] getBoard() {
	return this.board;
    }
    
    public void addVerticalRestriction(int pos, int rest) {
	ArrayList<Integer> aux = verticalRestrictions.get(pos);
	if(aux == null) {
	    aux = new ArrayList<Integer>();
	    aux.add(rest);
	    verticalRestrictions.add(pos, aux);
	} else {
	    aux.add(rest);
	}
    }
    
    public void addHorizontalRestriction(int pos, int rest) {
	ArrayList<Integer> aux = horizontalRestrictions.get(pos);
	if(aux == null) {
	    aux = new ArrayList<Integer>();
	    aux.add(rest);
	    horizontalRestrictions.add(pos, aux);
	} else {
	    aux.add(rest);
	}
    }
    
    public void print() {
	for(int i = 0; i < this.size; i++) {
	    for(int j = 0; j < this.size; j++) {
		
	    }
	}
	System.out.println("FAIL. NOT IMPLEMENTED YET");
    }
    
    @SuppressWarnings("resource")
    public static Nonogram loadData(String fileName) throws IOException {
	Nonogram nonogram = null;
	BufferedReader br;
	int counter = 0;
	br = new BufferedReader(new FileReader(PATH_IN+fileName)); // Read the specified file
	String line = br.readLine();
	counter++;
	if(line != null) {
	    nonogram = new Nonogram(Integer.parseInt(line));
	}
	line = br.readLine();
	while(line != null) {
	    counter++;
	    String[] parts;
	    if(counter <= nonogram.size+1) {
		parts = line.split(" ");
		for(int i = 0; i < parts.length; i++) {
		    nonogram.addHorizontalRestriction(counter-2, Integer.parseInt(parts[i]));
		}
		
	    } else {
		parts = line.split(" ");
		for(int i = 0; i < parts.length; i++) {
		    nonogram.addVerticalRestriction(counter-nonogram.size-2, Integer.parseInt(parts[i]));
		}
	    }
	    line = br.readLine();
	}
	return nonogram;
    }

}
