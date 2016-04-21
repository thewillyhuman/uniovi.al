package com.guille.al.labs.lab_8;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class NonogramTest {

    @Test
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
    public void case1Test() throws IOException {
	Nonogram nonogram = Nonogram.loadData("case1.txt");
	nonogram.print();

	if(nonogram.calculate())
	    nonogram.printSolution();
	assertEquals(true, nonogram.calculate());
    }
    
    @Test @Ignore
    public void printBinTest() throws IOException {
	Nonogram nonogram = Nonogram.loadData("case5.txt");
	List<Boolean> aux = new ArrayList<Boolean>();
	//nonogram.printBin(new ArrayList<Boolean>(), 4);
	
	nonogram.generateSolutions(new String(), nonogram.getSize(), 0);
	for(List<Boolean> list : nonogram.CompleteResult) {
	    for(Boolean bol : list) {
		System.out.print(bol + " ");
	    } System.out.println();
	}
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
