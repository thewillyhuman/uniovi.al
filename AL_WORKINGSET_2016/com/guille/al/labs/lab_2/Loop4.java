package com.guille.al.labs.lab_2;

import java.util.Random;

public class Loop4 {
    
    public static void loop4(int n) {
	/*Algorithm O(n^4) */
	Random rn = new Random();
	@SuppressWarnings("unused")
	int cont=0;
	for (int i=1; i<=n; i++)
		for (int j=1; j<=i; j++)
		    for (int k=1; k<=i; k++)
			for (int x=1; x<=i; x++)
			    cont += rn.nextInt();
    }

}
