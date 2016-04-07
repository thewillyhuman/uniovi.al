package com.guille.al.labs.lab_7;

public class CitySimple {

    long solution[][];
    private int width;
    private int heigth;
    private int originCoordinate[] = new int[2];
    private int destinationCoordinate[] = new int[2];

    private static final int BARRIER = -3;

    public CitySimple(int width, int heigth) {
	this.width = width - 1;
	this.heigth = heigth - 1;
	solution = new long[width][heigth];
    }

    public void setOrigin(int x, int y) {
	checkCoordinate(x, y);
	originCoordinate[0] = x;
	originCoordinate[1] = y;
    }

    public void setDestination(int x, int y) {
	checkCoordinate(x, y);
	destinationCoordinate[0] = x;
	destinationCoordinate[1] = y;
    }
    
    public void addObstacle(int x, int y) {
	checkCoordinate(x,y);
	solution[x][y] = BARRIER;
    }

    private void checkCoordinate(int x, int y) {
	if (x > this.width || x < 0 || y > this.heigth || y < 0)
	    throw new IllegalArgumentException();
    }
    
    public void printSolution() {
	for(int i = 0; i <= this.width; i++) {
	    for(int j = 0; j <= this.heigth; j++) {
		if(solution[i][j] == BARRIER)
		    System.out.print("\t -1 \t");
		else
		    System.out.print("\t"+solution[i][j]+"\t");
	    }
	    System.out.println();
	}
    }
    
    public long calculate() {
	loadBaseCases();
	
	if(originCoordinate[0] < destinationCoordinate[0])
	    return -1;
	if(originCoordinate[1] > destinationCoordinate[1])
	    return -1;
	if(originCoordinate[0] == destinationCoordinate[0] && originCoordinate[1] == destinationCoordinate[1])
	    return -1;
	
	for(int i = originCoordinate[0]-1;  i >= destinationCoordinate[0]; i--) {
	    for(int j = originCoordinate[1]+1; j <= destinationCoordinate[1]; j++) {
		if(solution[i][j] != BARRIER) {
		    if(solution[i][j-1] != BARRIER && solution[i+1][j] != BARRIER)
			solution[i][j] = solution[i][j-1] + solution[i+1][j];
		    else if(solution[i+1][j] != BARRIER)
			solution[i][j] = solution[i+1][j];
		    else
		    solution[i][j] = solution[i][j-1];
		}
	    }
	}
	
	return solution[destinationCoordinate[0]][destinationCoordinate[1]];
    }
    
    private void loadBaseCases() {
	for(int i = originCoordinate[0]-1; i >= destinationCoordinate[0]; i--) {
	    if(solution[i][originCoordinate[1]]!= BARRIER)
		solution[i][originCoordinate[1]] = 1;
	    else
		solution[i][originCoordinate[1]] = BARRIER;
	}
	
	for(int i = originCoordinate[1]+1; i <= destinationCoordinate[1]; i++) {
	    if(solution[originCoordinate[0]][i]!= BARRIER)
		solution[originCoordinate[0]][i] = 1;
	    else
		solution[originCoordinate[0]][i] = BARRIER;
	}
    }
}
