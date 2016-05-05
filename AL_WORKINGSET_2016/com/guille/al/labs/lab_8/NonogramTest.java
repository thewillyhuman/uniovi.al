package com.guille.al.labs.lab_8;

import static org.junit.Assert.*;

import java.io.IOException;
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

	/*
	 * if(nonogram.calculate()) nonogram.printSolution();
	 */
	long t1 = System.currentTimeMillis();
	assertEquals(true, nonogram.calculate());
	long t2 = System.currentTimeMillis();
	nonogram.printSolution();
	System.out.println("Case 1 generates: " + nonogram.getCalls() + " calls. And takes " + (t2-t1) + " ms.");
    }

    @Test @Ignore("Too long")
    public void case2Test() throws IOException {
	Nonogram nonogram = Nonogram.loadData("case2.txt");
	nonogram.print();

	long t1 = System.currentTimeMillis();
	assertEquals(true, nonogram.calculate());
	long t2 = System.currentTimeMillis();
	nonogram.printSolution();
	System.out.println("Case 2 generates: " + nonogram.getCalls() + " calls. And takes " + (t2-t1) + " ms.");
    }
    
    @Test @Ignore("Takes to long")
    public void case3Test() throws IOException {
	Nonogram nonogram = Nonogram.loadData("case3.txt");
	nonogram.print();

	long t1 = System.currentTimeMillis();
	assertEquals(true, nonogram.calculate());
	long t2 = System.currentTimeMillis();
	nonogram.printSolution();
	System.out.println("Case 3 generates: " + nonogram.getCalls() + " calls. And takes " + (t2-t1) + " ms.");
    }
    
    @Test @Ignore("Takes to long")
    public void case4est() throws IOException {
	Nonogram nonogram = Nonogram.loadData("case4.txt");
	nonogram.print();

	long t1 = System.currentTimeMillis();
	assertEquals(true, nonogram.calculate());
	long t2 = System.currentTimeMillis();
	nonogram.printSolution();
	System.out.println("Case 4 generates: " + nonogram.getCalls() + " calls. And takes " + (t2-t1) + " ms.");
    }
    
    @Test @Ignore("Takes to long")
    public void case5Test() throws IOException {
	Nonogram nonogram = Nonogram.loadData("case5.txt");
	nonogram.print();

	long t1 = System.currentTimeMillis();
	assertEquals(true, nonogram.calculate());
	long t2 = System.currentTimeMillis();
	nonogram.printSolution();
	System.out.println("Case 5 generates: " + nonogram.getCalls() + " calls. And takes " + (t2-t1) + " ms.");
    }
    
    @Test
    public void case10Test() throws IOException {
	Nonogram nonogram = Nonogram.loadData("case10.txt");
	nonogram.print();

	long t1 = System.currentTimeMillis();
	assertEquals(true, nonogram.calculate());
	long t2 = System.currentTimeMillis();
	nonogram.printSolution();
	System.out.println("Case 10 generates: " + nonogram.getCalls() + " calls. And takes " + (t2-t1) + " ms.");
    }
    
    @Test @Ignore("Takes to long")
    public void case11Test() throws IOException {
	Nonogram nonogram = Nonogram.loadData("case11.txt");
	nonogram.print();

	long t1 = System.currentTimeMillis();
	assertEquals(true, nonogram.calculate());
	long t2 = System.currentTimeMillis();
	nonogram.printSolution();
	System.out.println("Case 11 generates: " + nonogram.getCalls() + " calls. And takes " + (t2-t1) + " ms.");
    }

}
