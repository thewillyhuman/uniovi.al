package com.guille.al.labs.lab_7;

import java.util.ArrayList;
import java.util.List;

public class Barriers {
    
    public static List<Coordinate> barriers = new ArrayList<Coordinate>();
    
    public static void addCoordinate(Coordinate c) {
	barriers.add(c);
    }
    
    public static void addCoordinate(int x, int y) {
	if(!contains(x,y))
	    barriers.add(new Coordinate(x,y));
    }
    
    public static Coordinate getCoordinate(int x, int y) {
	for(Coordinate c : barriers) {
	    if(c.getX() == x && c.getY() == y)
		return c;
	}
	return null;
    }
    
    public static boolean contains(int x, int y) {
	for(Coordinate c : barriers) {
	    if(c.getX() == x && c.getY() == y)
		return true;
	}
	return false;
    }
    
    public static void restore() {
	barriers.clear();
    }

}
