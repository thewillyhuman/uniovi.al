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
    private boolean wasFound = false;
    public int calls = 0;

    List<List<Boolean>> CompleteResult = new ArrayList<List<Boolean>>();
    List<Boolean> partialResult = new ArrayList<Boolean>();

    public static final String PATH_IN = "com/guille/al/files/in/lab_8/";

    /**
     * Creates a nonogram of the given size.
     * 
     * @param size
     *            for the nonogram, will be n height and weight.
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
	ArrayList<Integer> aux1;
	ArrayList<Integer> aux2;
	for (int i = 0; i < size; i++) {
	    aux1 = new ArrayList<Integer>();
	    aux2 = new ArrayList<Integer>();
	    verticalRestrictions.add(aux1);
	    horizontalRestrictions.add(aux2);
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
     * @param possition
     *            where the vertical restriction is.
     * @param resttriction
     *            itself.
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
     * @param possition
     *            where the horizontal restriction is.
     * @param resttriction
     *            itself.
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
     * Prints the solution.
     */
    public void printSolution() {
	System.out.println("--- SOLUTION ---");
	for (int i = 0; i < this.size; i++) {
	    for (int j = 0; j < this.size; j++) {
		if (solution[i][j] == true)
		    System.out.print("X ");
		else
		    System.out.print("  ");

		if (j == this.size - 1)
		    System.out.println();
	    }
	}
    }

    /**
     * Prints the board.
     */
    public void print() {
	System.out.println("--- BOARD ---");
	for (int i = 0; i < this.size; i++) {
	    for (int j = 0; j < this.size; j++) {
		if (board[i][j] == true)
		    System.out.print("X\t");
		else
		    System.out.print("\t");

		if (j == this.size - 1)
		    System.out.println();
	    }
	}
    }

    /**
     * Implemented, very slow.
     * 
     * @param x
     * @param y
     */
    public void backtracking(int x) {
	calls++;
	if (x == size) {
	    boolean check = true;
	    for (int i = 0; i < size; i++) {
		if (!checkColumn(i) || !checkRow(i))
		    check = false;
	    }

	    if (check) {
		this.wasFound = true;
		saveStatus();
	    }
	} else {

	    CompleteResult = new ArrayList<List<Boolean>>();
	    generateSolutions(new String(), size, x);
	    List<List<Boolean>> rowSolutions = CompleteResult;

	    for (List<Boolean> solution : rowSolutions) {
		for (int i = 0; i < solution.size(); i++) {
		    board[x][i] = solution.get(i);

		    if (!wasFound && checkPartialColumn(i) && checkRow(x)) {
			backtracking(x + 1);
		    }
		}
	    }
	}
    }

    /**
     * Computes the nonogram.
     * 
     * @return true if was solved, false otherwise.
     */
    public boolean calculate() {
	backtracking(0);
	return wasFound;
    }

    /**
     * Generates a solution set for a given row.
     * 
     * @param soFar just new String();
     * @param size of the row.
     * @param row index.
     */
    public void generateSolutions(String soFar, int size, int row) {
	if (size == 0) {
	    // System.out.println(soFar);
	    char[] parts = soFar.toCharArray();
	    for (int i = 0; i < parts.length; i++) {
		if (parts[i] == '1')
		    partialResult.add(true);
		else
		    partialResult.add(false);
	    }

	    if (this.checkRow(partialResult, row))
		CompleteResult.add(partialResult);

	    partialResult = new ArrayList<Boolean>();
	    // System.out.println();
	} else {
	    generateSolutions(soFar + "0", size - 1, row);
	    generateSolutions(soFar + "1", size - 1, row);
	}
    }

    /**
     * Gets an array containing the slots in the row
     * 
     * @param x
     *            coordinate indicates the row.
     * @return an array of integers containing the slots in the row. Example
     *         [1,2] means 2 slots, one of 1 element and another of 2 elements.
     */
    public List<Integer> lookForTruesRow(int x) {
	List<Integer> aux = new ArrayList<Integer>();
	int counter = 0;
	for (int i = 0; i < board[x].length; i++) {
	    if (board[x][i] == true) {
		counter++;
	    } else if (board[x][i] == false) {
		if (counter != 0)
		    aux.add(counter);
		counter = 0;
	    }

	    if (i == (board[x].length - 1) && board[x][i] == true) {
		aux.add(counter);
	    }
	}
	return aux;
    }

    /**
     * Gets an array containing the slots in the row
     * 
     * @param x
     *            coordinate indicates the row.
     * @return an array of integers containing the slots in the row. Example
     *         [1,2] means 2 slots, one of 1 element and another of 2 elements.
     */
    public List<Integer> lookForTruesRow(List<Boolean> row, int x) {
	List<Integer> aux = new ArrayList<Integer>();
	int counter = 0;
	for (int i = 0; i < row.size(); i++) {
	    if (row.get(i) == true) {
		counter++;
	    } else if (row.get(i) == false) {
		if (counter != 0)
		    aux.add(counter);
		counter = 0;
	    }

	    if (i == (row.size() - 1) && row.get(i) == true) {
		aux.add(counter);
	    }
	}
	return aux;
    }

    /**
     * Gets an array containing the slots in the column
     * 
     * @param y
     *            coordinate indicates the row.
     * @return an array of integers containing the slots in the column. Example
     *         [1,2] means 2 slots, one of 1 element and another of 2 elements.
     */
    public List<Integer> lookForTruesColumn(int y) {
	List<Integer> aux = new ArrayList<Integer>();
	int counter = 0;
	for (int i = 0; i < board.length; i++) {
	    if (board[i][y] == true) {
		counter++;
	    } else if (board[i][y] == false) {
		if (counter != 0)
		    aux.add(counter);
		counter = 0;
	    }

	    if (i == (board.length - 1) && board[i][y] == true) {
		aux.add(counter);
	    }
	}
	return aux;
    }

    /**
     * Check a complete row.
     * 
     * @param x
     *            is the row coordinate to complete.
     * @return true if correct. False otherwise.
     */
    public boolean checkRow(int x) {
	List<Integer> aux = lookForTruesRow(x);
	if (horizontalRestrictions.get(x).size() != aux.size()) {
	    return false;
	}
	for (int i = 0; i < aux.size(); i++) {
	    if (horizontalRestrictions.get(x).get(i) != aux.get(i)) {
		return false;
	    }
	}
	return true;
    }

    /**
     * Check a complete row.
     * 
     * @param x
     *            is the row coordinate to complete.
     * @return true if correct. False otherwise.
     */
    public boolean checkRow(List<Boolean> row, int x) {
	List<Integer> aux = lookForTruesRow(row, x);
	if (horizontalRestrictions.get(x).size() != aux.size()) {
	    return false;
	}
	for (int i = 0; i < aux.size(); i++) {
	    if (horizontalRestrictions.get(x).get(i) != aux.get(i)) {
		return false;
	    }
	}
	return true;
    }

    /**
     * Check a complete column.
     * 
     * @param y
     *            is the row coordinate to complete.
     * @return true if correct. False otherwise.
     */
    public boolean checkColumn(int y) {
	List<Integer> aux = lookForTruesColumn(y);
	if (verticalRestrictions.get(y).size() != aux.size()) {
	    return false;
	}
	for (int i = 0; i < aux.size(); i++) {
	    if (verticalRestrictions.get(y).get(i) != aux.get(i)) {
		return false;
	    }
	}
	return true;
    }

    /**
     * Check a partial row.
     * 
     * @param x
     *            is the row coordinate to complete.
     * @return true if correct. False otherwise.
     */
    public boolean checkPartialRow(int x) {
	List<Integer> aux = lookForTruesRow(x);
	if (horizontalRestrictions.get(x).size() < aux.size()) {
	    return false;
	}
	for (int i = 0; i < aux.size(); i++) {
	    if (horizontalRestrictions.get(x).get(i) < aux.get(i)) {
		return false;
	    }
	}
	return true;
    }

    /**
     * Check a partial column.
     * 
     * @param y
     *            is the row coordinate to complete.
     * @return true if correct. False otherwise.
     */
    public boolean checkPartialColumn(int y) {
	List<Integer> aux = lookForTruesColumn(y);
	if (verticalRestrictions.get(y).size() < aux.size()) {
	    return false;
	}
	for (int i = 0; i < aux.size(); i++) {
	    if (verticalRestrictions.get(y).get(i) < aux.get(i)) {
		return false;
	    }
	}
	return true;
    }

    /**
     * Saves the status.
     */
    private void saveStatus() {
	this.solution = Arrays.copy(board);
    }

    /**
     * Loads the data onto the system.
     * 
     * @format first row is the size and then will have size rows with the
     *         horizontal restrictions and size rows with the vertical
     *         restrictions.
     * @param fileName,
     *            name of the file where data is stored.
     * @return a nonogram containing all the previous loaded data.
     * @throws IOException
     *             if any problem while creating the file or reading it occurs.
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
		    // System.out.println("HR--> Added to index " + (counter-2)
		    // + " the value " + parts[i]);
		    nonogram.addHorizontalRestriction(counter - 2, Integer.parseInt(parts[i]));
		}

	    } else {
		parts = line.split(" ");
		for (int i = 0; i < parts.length; i++) {
		    // System.out.println("VR--> Added to index " +
		    // (counter-nonogram.size-2) + " the value " + parts[i]);
		    nonogram.addVerticalRestriction(counter - nonogram.size - 2, Integer.parseInt(parts[i]));
		}
	    }
	    line = br.readLine();
	}
	return nonogram;
    }
}
