package com.guille.al.labs.lab_7;

public class City {
    
    private int width;
    private int heigth;
    private Coordinate origin;
    private Coordinate destination;
    private long paths = 0;
    
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
    
    public long calculate(Coordinate current) {
	Coordinate up = new Coordinate( current.getX(), current.getY() + 1);
	Coordinate right = new Coordinate( current.getX() - 1, current.getY());
	
	if(this.origin.compareTo(this.destination) == 0)
	    return -1;
	
	if(current.compareTo(this.getDestination()) == 0)
	    this.paths++;
	
	if(!Barriers.contains(up.getX(), up.getY()) && up.getY() <= this.destination.getY()) {
	    calculate(up);
	}
	
	if(!Barriers.contains(right.getX(), right.getY()) && right.getX() >= this.destination.getX()) {
	    calculate(right);
	}
	
	
	if(this.paths > 0)
	    return this.paths;
	return  -1;
    }

}
