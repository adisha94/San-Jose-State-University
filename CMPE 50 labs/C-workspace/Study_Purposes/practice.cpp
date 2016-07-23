/*
 * practice.cpp
 *
 *  Created on: Jan 31, 2015
 *      Author: Adish Betawar
 */

using namespace std;
#include <Iostream>
#include <stdio.h>
#include <fstream>

/*
 * Globals and universals
 */
ifstream in;
ofstream out;

/*
 * Methods
 */
int Product(int num1, int num2, int num3); // calculating product of two numbers and returning the product


int main()
{
	/*
	 * Opening Input and Output channels
	 */
	out.open("outFile.dat"); // file called Pass.psu created
	ofstream create;
	create.open("inFile.dat");
	create << "1 2 3";
	cout << "Creating infile.dat" << endl;
	create.close();
	in.open("inFile.dat"); // input file called File_In.dat created

	cout << "Use Terminal to open the final output." << endl;


	/*
	 * Main Program starts
	 */
	int first, second, third;
	in >> first >> second >> third;

	int product = Product(first, second, third);
 	out << endl << first << endl << second << endl << third;
 	out << "The product is " << product << endl;
	in.close();
	out.close();
}

int Product(int num1, int num2, int num3) // refer to above
{
	int product = num1 * num2 * num3;
	return product;
}
