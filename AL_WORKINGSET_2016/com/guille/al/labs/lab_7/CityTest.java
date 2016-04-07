package com.guille.al.labs.lab_7;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unused")
public class CityTest {

    @Test
    public void test() {
	CitySimple city = new CitySimple(5, 5);
	city.setOrigin(2, 1);
	city.setDestination(1, 4);
	city.addObstacle(1, 2);
	//city.print();
	System.out.println(city.calculate());
	city.printSolution();
    }

}
