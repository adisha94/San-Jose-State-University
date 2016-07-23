/*
 * Lab_2.cpp
 *
 *  Created on: Feb 2, 2015
 *      Author: Adish Betawar
 */

#include <iostream>
#include <stdio.h>
using namespace std;


/*
 * Excercise one
 * 	function Overriding
 */
void Add(int type1, int type2);
void Add(double type1, double type2);
void Add(char type1[], char type2[]);

int main(void)
{
	int option;
	while (1)
	{
		cout << "What would you like to print out?" << endl << "\t1. Integer\n\t2. Double\n\t3. Strings (character arrays)" << endl;
		cin >> option;
		if (option == 1)
		{
			int first;
			int second;
			cout << "Enter your two integers: ";
			cin >> first >> second;
			Add(first,second);
			printf("\n\n");
			continue;
		}
		else if (option == 2)
		{
			double first;
			double second;
			cout << "Enter your two doubles: ";
			cin >> first >> second;
			Add(first, second);
			printf("\n\n");
			continue;
		}
		else if (option == 3)
		{
			char first[10];
			char second[10];
			cout << "Enter your two boss strings: ";
			cin >> first >> second;
			Add(first, second);
			printf("\n\n");
			continue;
		}
		else if(option == 4)
		{
			break;
		}
	}
	return 0;
}


void  Add(int type1, int type2)
{
	cout << "You have entered: " << type1 << " and " << type2 << " the result will be: " << (type1 + type2) << endl;
}

void Add(double type1, double type2)
{
	cout << "You have entered: " << type1 << " and " << type2 << " the result will be: " << (type1 + type2) << endl;
}

void Add(char type1[], char type2[])
{
	cout << "You have entered: " << type1 << " and " << type2 << " the result will be: ";
	cout << type1 << type2;
}


/*
 * CONSOLE OUTPUT
 * What would you like to print out?
	1. Integer
	2. Double
	3. Strings (character arrays)
1
Enter your two integers: 2 3
You have entered: 2 and 3 the result will be: 5


What would you like to print out?
	1. Integer
	2. Double
	3. Strings (character arrays)
2
Enter your two doubles: 2.2 3.33
You have entered: 2.2 and 3.33 the result will be: 5.53


What would you like to print out?
	1. Integer
	2. Double
	3. Strings (character arrays)
3
Enter your two boss strings: adish betawar
You have entered: adish and betawar the result will be: adishbetawar

What would you like to print out?
	1. Integer
	2. Double
	3. Strings (character arrays)
4
 *
 */
