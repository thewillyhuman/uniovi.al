package com.guille.util;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Class used to test algorithms. It includes a test method that given an output
 * file name, and the method to test as the initial, and final workload computes
 * several times the measure of its execution.
 * 
 * 
 * @author Guillermo Facundo Colunga
 * @version carlos.1
 */
public class TestBench {

    public static final int SAMPLES = 3;
    public static final int START_N = 100;
    public static final int FINAL_N = 300;
    // private static final String[] ALGORITHMS = {"linear", "quadratic",
    // "cubic", "logarithmic", "factorial", "factorialRec","pow", "powRec1",
    // "powRec2", "powRec3", "powRec4"};

    private static long result = 0;
    private static long mean = 0;

    /**
     * @param fileName String, output file name, example: quadratic.txt
     * @param algorithmName String, the name of the algorithm to test.
     * @param startN Integer(int), the iteration where the algorithm will start.
     * @param endN Integer(int), the iteration where the algorithm will end.
     * @param repetitions Integer(int), the number of times the experiment must
     *            be repeated.
     * @throws IOException if there's any problem while writing and or creating
     *             the file.
     */
    public static void test(String path, String classTo, String fileName, String algorithmName, int startN, int endN, int repetitions) throws IOException {
	int i = startN;
	int j = repetitions;
	FileWriter file = new FileWriter("com/guille/al/files/out/" + fileName);
	while (i <= endN) {
	    while (j > 0) {
		long before = System.currentTimeMillis();
		testAlgorithm(path, classTo, algorithmName, i);
		long after = System.currentTimeMillis();
		result = (after - before);
		mean = (mean + result) / 2;
		System.out.println("TIME SPENT... " + result + "ms");
		j = j - 1;
	    }
	    j = repetitions;
	    file.write(mean + ",");
	    mean = 0;
	    result = 0;
	    i = i + 1;
	}
	file.close();
    }

    /**
     * It's used to execute an algorithm from the Algorithms class. It can be
     * used to execute any method from any class.
     * 
     * @param String className, the name of the class the method you want to
     *            execute is placed.
     * @param String methodName, the name of the method you want to test.
     * @param int n.
     */
    private static void testAlgorithm(String path, String className, String methodName, int n) {
	Class<?> myClass = null;
	Object myObject = null;
	try {
	    myClass = Class.forName(path + className);
	    myObject = myClass.newInstance();
	} catch (Exception e) {
	    System.err.println("Error loading the class " + className);
	    System.out.println(e.toString());
	}
	try {
	    Class<?>[] params = new Class[1];
	    params[0] = Integer.TYPE;
	    Method m = myClass.getMethod(methodName, params);
	    m.invoke(myObject, n);
	} catch (Exception e) {
	    System.err.println("Error loading the method " + methodName);
	    System.out.println(e.toString());
	}
    }
}
