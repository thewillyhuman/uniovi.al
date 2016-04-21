package com.guille.al.labs.lab_8;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

public class NonogramTest {

    @Test @Ignore("Not implemented yet")
    public void testLoadCases() throws IOException {
	Nonogram nonogram = Nonogram.loadData("case1.txt");
	assertNotEquals(null, nonogram);
	assertEquals(5, nonogram.getSize());

	nonogram = Nonogram.loadData("case2.txt");
	assertNotEquals(null, nonogram);
	assertEquals(10, nonogram.getSize());

	nonogram = Nonogram.loadData("case3.txt");
	assertNotEquals(null, nonogram);
	assertEquals(15, nonogram.getSize());

	nonogram = Nonogram.loadData("case4.txt");
	assertNotEquals(null, nonogram);
	assertEquals(20, nonogram.getSize());

	nonogram = Nonogram.loadData("case5.txt");
	assertNotEquals(null, nonogram);
	assertEquals(25, nonogram.getSize());
    }
    
    @Test
    public void checkRowTest() throws IOException {
	Nonogram nonogram = Nonogram.loadData("case1.txt");
	assertNotEquals(null, nonogram);
	assertEquals(5, nonogram.getSize());
	
	for(int i = 0; i < 3; i++) {
	    nonogram.placeSlot(0, i, 1);
	    assertEquals(true, nonogram.checkPartialRow(0));
	}
	
    }

}
