package com.guille.al.labs.lab_7;

public class CitySimple {

    private static final int BARRIER = -1;
    // This allow us to access it directly.
    private int destinationCoordinate[] = new int[2]; // Coordinates of the
						      // destination. This allow
						      // us to access it
						      // directly.
    private int height; // Height of the problem.
    private int originCoordinate[] = new int[2]; // Coordinates of the origin.
    long solution[][]; // Will represent the problem and finally the solution.

    private int width; // Width of the problem.

    public CitySimple(int width, int heigth) {
	this.width = width - 1;
	this.height = heigth - 1;
	solution = new long[width][heigth];
    }

    /**
     * Adds an obstacle to the solution table.
     * 
     * @param x
     *            coordinate of the barrier.
     * @param y
     *            coordinate of the barrier.
     */
    public void addObstacle(int x, int y) {
	checkCoordinate(x, y);
	solution[x][y] = BARRIER;
    }

    /**
     * Calculates the number of paths using dynamic programming. That is
     * constructing a base cases and then computing the rest of the solutions.
     * 
     * @return -1 if cannot calculate the number of paths. 0 if can compute but
     *         there's no path. The number of possible paths otherwise.
     */
    public long calculate() {

	// Loading the base cases.
	loadBaseCases();

	// If the destination is down the origin which is not possible in our
	// problem.
	if (originCoordinate[0] < destinationCoordinate[0])
	    return -1;

	// If the destination is to the left of the origin which is not possible
	// in our problem.
	if (originCoordinate[1] > destinationCoordinate[1])
	    return -1;

	// If the destination is over the solution. Which is also impossible.
	if (originCoordinate[0] == destinationCoordinate[0] && originCoordinate[1] == destinationCoordinate[1])
	    return -1;

	// Computing the rest of the solutions.
	for (int i = originCoordinate[0] - 1; i >= destinationCoordinate[0]; i--) {
	    for (int j = originCoordinate[1] + 1; j <= destinationCoordinate[1]; j++) {
		if (solution[i][j] != BARRIER) {
		    if (solution[i][j - 1] != BARRIER && solution[i + 1][j] != BARRIER)
			solution[i][j] = solution[i][j - 1] + solution[i + 1][j];
		    else if (solution[i + 1][j] != BARRIER)
			solution[i][j] = solution[i + 1][j];
		    else
			solution[i][j] = solution[i][j - 1];
		}
	    }
	}

	// If the solution after computing everything is negative means that
	// there is no possible paths. Else we return the number of paths.
	if (solution[destinationCoordinate[0]][destinationCoordinate[1]] < 0)
	    return 0;
	else
	    return solution[destinationCoordinate[0]][destinationCoordinate[1]];
    }

    /**
     * Performs a simple test to check if a coordinate is valid.
     * 
     * @param x
     *            component of the coordinate.
     * @param y
     *            component of the coordinate.
     */
    private void checkCoordinate(int x, int y) {
	if (x > this.width || x < 0 || y > this.height || y < 0)
	    throw new IllegalArgumentException();
    }

    /**
     * Load the base cases. Execute always before start the computation of other
     * cases.
     */
    private void loadBaseCases() {
	for (int i = originCoordinate[0] - 1; i >= destinationCoordinate[0]; i--) {
	    if (solution[i][originCoordinate[1]] != BARRIER)
		solution[i][originCoordinate[1]] = 1;
	    else
		solution[i][originCoordinate[1]] = BARRIER;
	}

	for (int i = originCoordinate[1] + 1; i <= destinationCoordinate[1]; i++) {
	    if (solution[originCoordinate[0]][i] != BARRIER)
		solution[originCoordinate[0]][i] = 1;
	    else
		solution[originCoordinate[0]][i] = BARRIER;
	}
    }

    /**
     * Prints the solution.
     */
    public void printSolution() {
	for (int i = 0; i <= this.width; i++) {
	    for (int j = 0; j <= this.height; j++) {
		if (solution[i][j] == BARRIER)
		    System.out.print("\t -1 \t");
		else
		    System.out.print("\t" + solution[i][j] + "\t");
	    }
	    System.out.println();
	}
    }

    /**
     * Sets the destination at the x / y coordinate.
     * 
     * @param x
     *            coordinate of the destination.
     * @param y
     *            coordinate of the destination.
     */
    public void setDestination(int x, int y) {
	checkCoordinate(x, y);
	destinationCoordinate[0] = x;
	destinationCoordinate[1] = y;
    }

    /**
     * Sets the origin at the coordinate x and y.
     * 
     * @param x
     *            coordinate of the origin.
     * @param y
     *            coordinate of the origin.
     */
    public void setOrigin(int x, int y) {
	checkCoordinate(x, y);
	originCoordinate[0] = x;
	originCoordinate[1] = y;
    }
}
