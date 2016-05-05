package com.guille.al.labs.lab_7;

public class City {
    
    private int width;
    private int heigth;
    private Coordinate origin;
    private Coordinate destination;
    private long paths = 0;
    long solution[][];
    
    private static final int BARRIER = -1;
    
    public City(int width, int heigth) {
	this.width = width-1;
	this.heigth = heigth-1;
	Barriers.restore();
    }
    
    public void setOrigin(int x, int y) {
	checkCoordinate(x,y);
	this.origin = new Coordinate(x,y);
    }
    
    public Coordinate getOrigin() {
	return this.origin;
    }
    
    public void setDestination(int x, int y) {
	checkCoordinate(x,y);
	this.destination = new Coordinate(x,y);
    }
    
    public Coordinate getDestination() {
	return this.destination;
    }
    
    public void addObstacle(int x, int y) {
	checkCoordinate(x,y);
	Barriers.addCoordinate(x,y);
    }
    
    private void checkCoordinate(int x, int y) {
	if(x > this.width || x < 0 || y > this.heigth || y < 0)
	    throw new IllegalArgumentException();
    }
    
    public void print() {
	for(int i = 0; i <= this.width; i++) {
	    for(int j = 0; j <= this.heigth; j++) {
		if(this.origin.compareTo(new Coordinate(i,j)) == 0)
		    System.out.print("\t START \t");
		else if(this.destination.compareTo(new Coordinate(i,j)) == 0)
		    System.out.print("\t END \t");
		else if(Barriers.contains(i, j))
		    System.out.print("\t -1 \t");
		else
		    System.out.print("\t 0 \t");
	    }
	    System.out.println();
	}
    }
    
    public void printSolution() {
	for(int i = 0; i <= this.width; i++) {
	    for(int j = 0; j <= this.heigth; j++) {
		if(this.origin.compareTo(new Coordinate(i,j)) == 0)
		    System.out.print("\t START \t");
		else if(this.destination.compareTo(new Coordinate(i,j)) == 0)
		    System.out.print("\t END \t");
		else if(Barriers.contains(i, j))
		    System.out.print("\t 0 \t");
		else
		    System.out.print("\t"+solution[i][j]+"\t");
	    }
	    System.out.println();
	}
    }
    
    public long calculateRecursive(Coordinate current) {
	Coordinate up = new Coordinate( current.getX(), current.getY() + 1);
	Coordinate right = new Coordinate( current.getX() - 1, current.getY());
	
	if(this.origin.compareTo(this.destination) == 0)
	    return -1;
	
	if(this.origin.x < this.destination.getX())
	    return -1;
	
	if(current.compareTo(this.getDestination()) == 0) {
	    this.paths++;
	    return this.paths;
	}
	
	if(!Barriers.contains(up.getX(), up.getY()) && up.getY() <= this.destination.getY()) {
	    calculateRecursive(up);
	}
	
	if(!Barriers.contains(right.getX(), right.getY()) && right.getX() >= this.destination.getX()) {
	    calculateRecursive(right);
	}
	
	if(this.paths >= 0)
	    return this.paths;
	return  -1;
    }
    
    public long calculateDynamic(Coordinate start) {
	
	solution = new long[heigth+1][width+1];
	
	// -- loading the base cases
	for(int i = this.origin.x-1; i >= this.destination.x; i--) {
	    if(!Barriers.contains(i, this.origin.y))
		solution[i][this.origin.y] = 1;
	    else
		solution[i][this.origin.y] = BARRIER;
	}
	
	for(int j = this.origin.y+1; j <= this.destination.y; j++) {
	    if(!Barriers.contains(this.origin.y, j))
		solution[this.origin.x][j] = 1;
	    else
		solution[this.origin.x][j] = BARRIER;
	}
	
	// -- end of loading the base cases.
	
	// -- compute the other cases.
	for(int i = this.origin.x-1; i >= this.destination.x; i--) {
	    for(int j = this.origin.y+1; j <= this.destination.y; j++) {
		if(solution[i][j]!=BARRIER) {
		    if(solution[i][j-1] == BARRIER)
			solution[i][j] = solution[i+1][j];
		    else if(solution[i+1][j] == BARRIER)
			solution[i][j] = solution[i][j-1];
		    else
		    solution[i][j] = solution[i][j-1] + solution[i+1][j];
		}
	    }
	}
	return solution[this.destination.x][this.destination.y];
	
    }

}
