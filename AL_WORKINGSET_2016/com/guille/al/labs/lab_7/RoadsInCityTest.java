package com.guille.al.labs.lab_7;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

/**
 * JUnit Test for RoadsInCity
 */
public class RoadsInCityTest {

    public static final String relativePath = "com/guille/al/files/in/lab_7/";

    @Test
    public void testA() {
	long result = executeFromFile(relativePath + "case1.txt");
	assertEquals(2, result);
    }

    @Test
    public void testB() {
	long result = executeFromFile(relativePath + "case2.txt");
	assertEquals(252, result);
    }

    @Test
    public void testC() {
	long result = executeFromFile(relativePath + "case3.txt");
	assertEquals(0, result);
    }

    @Test
    public void testD() {
	long result = executeFromFile(relativePath + "case4.txt");
	assertEquals(6406484391866534976l, result);
    }

    @Test
    public void testE() {
	long result = executeFromFile(relativePath + "case5.txt");
	assertEquals(4, result);
    }

    @Test
    public void testF() {
	long result = executeFromFile(relativePath + "case6.txt");
	assertEquals(2, result);
    }

    @Test
    public void testG() {
	try {
	    long result = executeFromFile(relativePath + "case7.txt");
	    assertEquals(-1, result);
	    fail("Exception expected.");
	} catch (IllegalArgumentException e) {

	}
    }

    @Test
    public void testH() {
	long result = executeFromFile(relativePath + "case8.txt");
	assertEquals(-1, result);
    }

    @Test
    public void testI() {
	long result = executeFromFile(relativePath + "case9.txt");
	assertEquals(-1, result);
    }

    @SuppressWarnings("resource")
    private long executeFromFile(String file) {
	long result = 0;
	// Input
	BufferedReader br;
	try {
	    br = new BufferedReader(new FileReader(file));

	    // First line (SIZE OF THE CITY)
	    String[] size = br.readLine().split(","); // width and height of the
						      // city
	    CitySimple roads = new CitySimple(Integer.parseInt(size[0]), Integer.parseInt(size[1]));

	    // Second line (BARRIERS)
	    try {
		String[] barriers = br.readLine().split(";");
		if (barriers.length > 0)
		    for (int i = 0; i < barriers.length; i++) {
			String[] barrierPosition = barriers[i].split(","); // barrierX
									   // and
									   // barrierY
			roads.addObstacle(Integer.parseInt(barrierPosition[0]), Integer.parseInt(barrierPosition[1]));
		    }
	    } catch (Exception ex) { // There are not barriers...
	    }

	    // Third line (STARTING AND END POINTS)
	    String[] positions = br.readLine().split(";");
	    String[] start = positions[0].split(","); // startX and startY
	    String[] end = positions[1].split(","); // endX and endY
	    roads.setOrigin(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
	    roads.setDestination(Integer.parseInt(end[0]), Integer.parseInt(end[1]));
	    //result = roads.calculateDynamic(roads.getOrigin());
	    result = roads.calculate();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return result;
    }

}
