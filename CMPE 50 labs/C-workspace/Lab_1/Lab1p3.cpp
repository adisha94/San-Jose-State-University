/*
 * Lab1p3.cpp
 *
 *  Created on: Jan 26, 2015
 *      Author: Adish Betawar
 */
using namespace std;
#include <Iostream>
#include <stdio.h>

int main()
{
	int k, i = 3, count, c;
	printf("Prime numbers up till what number: ");
	cin >> k;
	/**
	 * we need to print out the prime numbers from 3 to k
	 * 	We will use a double nested 'for-loop' to get around the outer portion of the code
	 */
	for (count = 2; count < k; count++) // the first portion, printing out the prime numbers from 3 to 'k';
	{
		for (c = 2; c <= i-1 ;c++) // inner loop for finding out what numbers are prime
		{
			if (i % c == 0) // checking for prime
			{
				break;
			}
		}
		if (c == i) // final output printing
		{
			cout << c;
			cout << "\n";
			c++;
		}
		i++;
	}

	return 0;
}



//---------------- CODE OUTPUT------------------
//Prime numbers up till what number: 33
//3
//5
//7
//11
//13
//17
//19
//23
//29
//31
