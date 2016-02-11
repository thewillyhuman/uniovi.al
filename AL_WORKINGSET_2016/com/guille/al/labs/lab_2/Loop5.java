package com.guille.al.labs.lab_2;

import java.util.Random;

public class Loop5 {
    
    public static void loop5(int n) {
	/*Quadratic algorithm O(n^2) */
	@SuppressWarnings("unused")
	Random rn = new Random();
	@SuppressWarnings("unused")
	int cont=0;
	for (int i=1; i<=n; i++)
		for (int j=1; j<=n; j++) 
			nLogN(n);
    }
    
    public static void nLogN(int n) {
	Random rn = new Random();
	@SuppressWarnings("unused")
	int cont=0;
	for (int i=1; i<=n; i++)
		for (int j=1; j<=n; j*=2)
			cont += rn.nextInt();
    }
}
