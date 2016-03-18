package com.guille.al.labs.lab_7;

public class Coordinate implements Comparable<Coordinate>{

    int x;
    int y;
    
    public Coordinate(int x, int y) {
	this.x = x;
	this.y = y;
    }
    
    public int getX() {
	return this.x;
    }
    
    public int getY() {
	return this.y;
    }

    @Override
    public int compareTo(Coordinate o) {
	if(o.getX() == this.x && o.getY() == this.y)
	    return 0;
	else if (o.getX() < this.x || o.getY() < this.y)
	    return -1;
	else return 1;
    }
}
