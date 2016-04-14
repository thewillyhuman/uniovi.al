package com.guille.util;

public class Arrays {
    
    public static <T> T[][] copy(T[][] matrix) {
	T[][] aux = matrix;
	for(int i = 0; i < matrix.length; i++) {
	    for(int j = 0; j < matrix[i].length; j++) {
		aux[i][j] = matrix[i][j];
	    }
	} 
	return aux;
    }
    
    public static boolean[][] copy(boolean[][] matrix) {
	boolean[][] aux = new boolean[matrix.length][matrix[0].length];
	
	for(int i = 0; i < matrix.length; i++) {
	    for(int j = 0; j < matrix[i].length; j++) {
		aux[i][j] = matrix[i][j];
	    }
	} 
	return aux;
    }

}
