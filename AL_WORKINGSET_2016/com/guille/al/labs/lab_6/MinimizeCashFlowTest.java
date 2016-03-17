package com.guille.al.labs.lab_6;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import org.junit.Test;

/**
 * JUnit Test for MinimizeCashFlow
 */
public class MinimizeCashFlowTest {

    @Test
    public void loadFilesTest() {
	@SuppressWarnings("unused")
	MinimizeCashFlow cashFlow;
	try {
	    cashFlow = MinimizeCashFlow.loadDataFromFile("com/guille/al/files/in/case1.txt");
	    cashFlow = MinimizeCashFlow.loadDataFromFile("com/guille/al/files/in/case2.txt");
	    cashFlow = MinimizeCashFlow.loadDataFromFile("com/guille/al/files/in/case3.txt");
	    cashFlow = MinimizeCashFlow.loadDataFromFile("com/guille/al/files/in/case4_custom.txt");
	} catch (IOException e) {
	    fail("Some file fails while loading");
	    e.printStackTrace();
	}
    }

    @Test
    public void testA() throws IOException {
	MinimizeCashFlow cashFlow = MinimizeCashFlow.loadDataFromFile("com/guille/al/files/in/case1.txt");

	// Calculation
	cashFlow.calculate();

	// Expected results VS Actual results
	assertEquals(0, cashFlow.getFinalDebt("David", "Juan"));
	assertEquals(4000, cashFlow.getFinalDebt("Juan", "Ana"));
	assertEquals(3000, cashFlow.getFinalDebt("David", "Ana"));
    }

    @Test
    public void testB() throws IOException {
	MinimizeCashFlow cashFlow = MinimizeCashFlow.loadDataFromFile("com/guille/al/files/in/case2.txt");

	// Calculation
	cashFlow.calculate();

	// Expected results VS Actual results
	assertEquals(45, cashFlow.getFinalDebt("Victor", "Tamara"));
	assertEquals(15, cashFlow.getFinalDebt("Victor", "Elena"));
	assertEquals(5, cashFlow.getFinalDebt("Alberto", "Celia"));
	assertEquals(5, cashFlow.getFinalDebt("Alberto", "Pablo"));
    }

    @Test
    public void testC() throws IOException {
	MinimizeCashFlow cashFlow = MinimizeCashFlow.loadDataFromFile("com/guille/al/files/in/case3.txt");

	// Calculation
	cashFlow.calculate();

	// Expected results VS Actual results
	assertEquals(45, cashFlow.getFinalDebt("Victor", "Tamara"));
	assertEquals(15, cashFlow.getFinalDebt("Victor", "Celia"));
	assertEquals(16, cashFlow.getFinalDebt("Alberto", "Elena"));
    }
    
    public void customTest() throws IOException {
	MinimizeCashFlow cashFlow = MinimizeCashFlow.loadDataFromFile("com/guille/al/files/in/cas4_custom.txt");
	
	//Calculation
	cashFlow.calculate();
	
	assertEquals(0, cashFlow.getFinalDebt("David", "Juan"));
	assertEquals(0, cashFlow.getFinalDebt("Juan", "Ana"));
	assertEquals(0, cashFlow.getFinalDebt("David", "Ana"));
	
    }
}
