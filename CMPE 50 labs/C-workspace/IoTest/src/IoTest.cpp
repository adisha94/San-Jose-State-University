//============================================================================
// Name        : IoTest.cpp
// Author      : Adish Betawar
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <fstream>
#include <stdio.h>
using namespace std;

ifstream in; // input
ofstream out; // output

int main()
{
	out.open("//Users//Adish//Desktop//Testing.dat");
	char test[500];
	cin >> test;
	out << test;
	out << " This is a test.";
	out.close();
}
