package com.guille.al.labs.lab_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.guille.util.ArraysImproved;

/**
 * Represents a nonogram game and solves it by means of backtracking. To input a
 * new file / case place it in the package com.guille.al.files.in.lab_8
 *
 * @version 2.0
 * @author Guillermo Facundo Colunga
 */
public class Nonogram {

    public static final String PATH_IN = "com/guille/al/files/in/lab_8/";

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

    /*
     * BEGIN OF THE NON-STATIC CLASS / FIELDS.
     */

    private boolean[][] board;
    private int calls = 0;
    private List<List<Boolean>> completeResult = new ArrayList<List<Boolean>>();
    private List<ArrayList<Integer>> horizontalRestrictions;
    private List<Boolean> partialResult = new ArrayList<Boolean>();
    private int size;
    private boolean[][] solution;
    private List<ArrayList<Integer>> verticalRestrictions;
    private boolean wasFound = false;

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
     * Implemented, very slow.
     * 
     * @param x
     */
    private void backtracking(int x) {
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
	    List<List<Boolean>> rowSolutions = filterRow(completeResult, x);
	    for (List<Boolean> solution : rowSolutions) {
		for (int i = 0; i < solution.size(); i++) {
		    board[x][i] = solution.get(i);
		    if (!wasFound && checkPartialColumn(i) && checkRow(x))
			backtracking(x + 1);
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
	generateSolutions(new String(), this.size);
	backtracking(0);
	return wasFound;
    }

    /**
     * Check a complete column.
     * 
     * @param y
     *            is the row coordinate to complete.
     * @return true if correct. False otherwise.
     */
    private boolean checkColumn(int y) {
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
     * Check a partial column.
     * 
     * @param y
     *            is the row coordinate to complete.
     * @return true if correct. False otherwise.
     */
    private boolean checkPartialColumn(int y) {
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
     * Check a partial row.
     * 
     * @param x
     *            is the row coordinate to complete.
     * @return true if correct. False otherwise.
     */
    @SuppressWarnings("unused")
    private boolean checkPartialRow(int x) {
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
     * Check a complete row.
     * 
     * @param x
     *            is the row coordinate to complete.
     * @return true if correct. False otherwise.
     */
    private boolean checkRow(int x) {
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
    private boolean checkRow(List<Boolean> row, int x) {
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
     * Gets into one array all the horizontal restrictions.
     * 
     * @return an array containing all the horizontal restrictions.
     */
    public List<ArrayList<Integer>> cloneHorizontalRestictions() {
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
     * Gets into one array all the vertical restrictions.
     * 
     * @return an array containing all the vertical restrictions.
     */
    public List<ArrayList<Integer>> cloneVerticalRestictions() {
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
     * Filters a given row.
     * 
     * @param toFilter
     * @param row
     * @return the list filtered.
     */
    private List<List<Boolean>> filterRow(List<List<Boolean>> toFilter, int row) {
	List<List<Boolean>> aux = new ArrayList<List<Boolean>>();
	for (List<Boolean> r : toFilter) {
	    if (this.checkRow(r, row))
		aux.add(r);
	}
	return aux;
    }

    /**
     * Generates a solution set for a given row.
     * 
     * @param soFar
     *            just new String();
     * @param size
     *            of the row.
     * @param row
     *            index.
     */
    private void generateSolutions(String soFar, int size) {
	if (size == 0) {
	    // System.out.println(soFar);
	    char[] parts = soFar.toCharArray();
	    for (int i = 0; i < parts.length; i++) {
		if (parts[i] == '1')
		    partialResult.add(true);
		else
		    partialResult.add(false);
	    }

	    completeResult.add(partialResult);

	    partialResult = new ArrayList<Boolean>();
	    // System.out.println();
	} else {
	    generateSolutions(soFar + "0", size - 1);
	    generateSolutions(soFar + "1", size - 1);
	}
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
     * Returns the number of calls done to solve the problem.
     * 
     * @return the number of calls done to solve the problem.
     */
    public int getCalls() {
	return this.calls;
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
     * Gets an array containing the slots in the column
     * 
     * @param y
     *            coordinate indicates the row.
     * @return an array of integers containing the slots in the column. Example
     *         [1,2] means 2 slots, one of 1 element and another of 2 elements.
     */
    private List<Integer> lookForTruesColumn(int y) {
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
     * Gets an array containing the slots in the row
     * 
     * @param x
     *            coordinate indicates the row.
     * @return an array of integers containing the slots in the row. Example
     *         [1,2] means 2 slots, one of 1 element and another of 2 elements.
     */
    private List<Integer> lookForTruesRow(int x) {
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
    private List<Integer> lookForTruesRow(List<Boolean> row, int x) {
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
     * Prints the board.
     */
    public void print() {
	System.out.println("--- BOARD ---");
	for (int i = 0; i < this.size; i++) {
	    for (int j = 0; j < this.size; j++) {
		if (board[i][j] == true)
		    System.out.print("X ");
		else
		    System.out.print("  ");

		if (j == this.size - 1)
		    System.out.println();
	    }
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
     * Saves the status.
     */
    private void saveStatus() {
	this.solution = ArraysImproved.copy(board);
    }
}
