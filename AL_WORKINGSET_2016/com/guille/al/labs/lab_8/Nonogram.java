package com.guille.al.labs.lab_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.guille.util.Arrays;

public class Nonogram {

    private int size;
    private List<ArrayList<Integer>> verticalRestrictions;
    private List<ArrayList<Integer>> horizontalRestrictions;
    private boolean[][] board;
    private boolean[][] solution;
    private boolean wasFound;

    public static final String PATH_IN = "com/guille/al/files/in/lab_8/";

    /**
     * Creates a nonogram of the given size.
     * 
     * @param size for the nonogram, will be n height and weight.
     */
    public Nonogram(int size) {
	if (size > 0) {
	    this.size = size;
	    board = new boolean[size][size];
	    verticalRestrictions = new ArrayList<ArrayList<Integer>>();
	    horizontalRestrictions = new ArrayList<ArrayList<Integer>>();
	    loadArrays();
	}
    }

    /**
     * Private method to initialize the sub-arrays for the restrictions.
     */
    private void loadArrays() {
	ArrayList<Integer> aux;
	for (int i = 0; i < size; i++) {
	    aux = new ArrayList<Integer>();
	    verticalRestrictions.add(aux);
	    horizontalRestrictions.add(aux);
	}
    }

    /**
     * Gets the size of the nonogram.
     * 
     * @return the size of the nonogram as an integer.
     */
    public int getSize() {
	return this.size;
    }

    /**
     * Gets into one array all the vertical restrictions.
     * 
     * @return an array containing all the vertical restrictions.
     */
    public List<ArrayList<Integer>> getVerticalRestictions() {
	List<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>>();
	for (ArrayList<Integer> arr : verticalRestrictions) {
	    ArrayList<Integer> rest = new ArrayList<Integer>();
	    for (Integer num : arr) {
		rest.add(num);
	    }
	    aux.add(arr);
	}
	return aux;
    }

    /**
     * Gets into one array all the horizontal restrictions.
     * 
     * @return an array containing all the horizontal restrictions.
     */
    public List<ArrayList<Integer>> getHorizontalRestictions() {
	List<ArrayList<Integer>> aux = new ArrayList<ArrayList<Integer>>();
	for (ArrayList<Integer> arr : horizontalRestrictions) {
	    ArrayList<Integer> rest = new ArrayList<Integer>();
	    for (Integer num : arr) {
		rest.add(num);
	    }
	    aux.add(arr);
	}
	return aux;
    }

    /**
     * Gets the nonogram board.
     * 
     * @return the nonogram board reference.
     */
    public boolean[][] getBoard() {
	return this.board;
    }

    /**
     * Adds a vertical restriction to the board.
     * 
     * @param possition where the vertical restriction is.
     * @param resttriction itself.
     */
    public void addVerticalRestriction(int pos, int rest) {
	ArrayList<Integer> aux = verticalRestrictions.get(pos);
	if (aux == null) {
	    aux = new ArrayList<Integer>();
	    aux.add(rest);
	    verticalRestrictions.add(pos, aux);
	} else {
	    aux.add(rest);
	}
    }

    /**
     * Adds an horizontal restriction to the board.
     * 
     * @param possition where the horizontal restriction is.
     * @param resttriction itself.
     */
    public void addHorizontalRestriction(int pos, int rest) {
	ArrayList<Integer> aux = horizontalRestrictions.get(pos);
	if (aux == null) {
	    aux = new ArrayList<Integer>();
	    aux.add(rest);
	    horizontalRestrictions.add(pos, aux);
	} else {
	    aux.add(rest);
	}
    }

    /**
     * NOT IMPLEMENTED YET.
     */
    public void print() {
	for (int i = 0; i < this.size; i++) {
	    for (int j = 0; j < this.size; j++) {

	    }
	}
	System.out.println("FAIL. NOT IMPLEMENTED YET");
    }

    public void backtracking(int x, int y) {
	if (x == size) {
	    this.wasFound = true;
	    saveState();
	} else {
	    for(int k = 1; k <= size; k++) {
		if(!this.wasFound && checkColum(x, ) && checkRow(y, )) {
		    placeSlot(x, y, blockSize);
		    backtracking( , );
		    unplaceSlot(x, y, blockSize);
		}
	    }
	}
    }

    protected void placeSlot(int x, int y, int blockSize) {
	for (int i = 0; i < blockSize; i++) {
	    board[x][y + i] = true;
	}
    }

    protected void unplaceSlot(int x, int y, int blockSize) {
	for (int i = 0; i < blockSize; i++) {
	    board[x][y + i] = false;
	}
    }

    protected boolean isMovementPossible(int x, int y, int blockSize) {
	boolean aux = false;

	return aux;
    }

    protected boolean checkColum(int x) {
	for (int j = 0; j < verticalRestrictions.get(x).size(); j++) {
	    
	}
	return true;
    }

    protected boolean checkConstraint(int x, int y, int blockSize) {
	int counter = 0;
	for (int index = y; index < board.length; index++) {
	    if (board[x][index])
		counter++;
	    else
		counter = 0;
	}
	return true;
    }

    private void saveState() {
	this.solution = Arrays.copy(board);
    }

    /**
     * Loads the data onto the system.
     * 
     * @format first row is the size and then will have size rows with the
     *         horizontal restrictions and size rows with the vertical
     *         restrictions.
     * @param fileName, name of the file where data is stored.
     * @return a nonogram containing all the previous loaded data.
     * @throws IOException if any problem while creating the file or reading it
     *             occurs.
     */
    @SuppressWarnings("resource")
    public static Nonogram loadData(String fileName) throws IOException {
	Nonogram nonogram = null;
	BufferedReader br;
	int counter = 0;
	br = new BufferedReader(new FileReader(PATH_IN + fileName)); // Read the
								     // specified
								     // file
	String line = br.readLine();
	counter++;
	if (line != null) {
	    nonogram = new Nonogram(Integer.parseInt(line));
	}
	line = br.readLine();
	while (line != null) {
	    counter++;
	    String[] parts;
	    if (counter <= nonogram.size + 1) {
		parts = line.split(" ");
		for (int i = 0; i < parts.length; i++) {
		    nonogram.addHorizontalRestriction(counter - 2, Integer.parseInt(parts[i]));
		}

	    } else {
		parts = line.split(" ");
		for (int i = 0; i < parts.length; i++) {
		    nonogram.addVerticalRestriction(counter - nonogram.size - 2, Integer.parseInt(parts[i]));
		}
	    }
	    line = br.readLine();
	}
	return nonogram;
    }

}
