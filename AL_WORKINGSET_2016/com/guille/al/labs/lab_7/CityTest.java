package com.guille.al.labs.lab_7;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("unused")
public class CityTest {

    @Test
    public void test() {
	City city = new City(7, 7);
	city.setOrigin(6, 0);
	city.setDestination(0, 6);
	city.print();
	System.out.println(city.calculateRecursive(city.getOrigin()));
    }

}
