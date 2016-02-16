package com.guille.al.labs.lab_3;

import java.util.Random ; 
/*
It is the class that generates a vector for its three 
possible orderings (sorted, inversely sorted, random). 
It also writes the contents of the vector
*/

public class Vector {

public static void sorted(int[]a)
/* 	This method fills with values ​​sorted in ascending order
*/
{
    int n= a.length;
    for(int i=0;i<n;i++) 
    	a[i]=i;
}

public static void inverselySorted(int[]a)
/* 	This method fills with values ​​sorted in descending order
*/
{
    int n= a.length;
    for(int i=0;i<n;i++) 
    	a[i]=n-i-1;
}     

public static void random(int[]a, int maxRandom)
/* 	This method gives random values ​​to a vector of integers.
 * It uses the Random class from the java.util package  */
{
    Random r= new Random();
    int n= a.length;
    for(int i=0;i<n;i++)
       a[i]=r.nextInt(maxRandom); //values between 0 and maxRandom
}     

public static void write(int[]a)
/* 	This method writes the vector components
*/
{
	int n= a.length;
	System.out.print("(");
	for (int i=0; i<n; i++ )
		System.out.print(a[i]+", ");
	System.out.println(")");
}    

}


 

