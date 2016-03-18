package com.guille.al.labs.lab_7;

import static org.junit.Assert.*;

import org.junit.Test;

public class CityTest {

    @Test
    public void test() {
	City city = new City(5, 5);
	city.setDestination(1, 4);
	city.setOrigin(5, 1);
	city.print();
	System.out.println(city.calculate(city.getOrigin()));
    }

}
