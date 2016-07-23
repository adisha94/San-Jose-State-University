/*
 * Filla.cpp
 *
 *  Created on: Feb 20, 2015
 *      Author: Adish
 */

#include "Maker.h"

ofstream out;
ifstream in;
int main()
{
	char filename[] = " ";
	char essay[500000];
	cout << "Enter file name\n";
	cout << filename << endl;



	chdir("//users//adish//desktop");
	out.open(filename, ios::app);
	out << "Write essay idea here";

	for (int i = 0; i < sizeof(essay); i++)
	{
		in >> essay;
	}
	in.close();
	out << essay;
	out.close();
	return 0;
}
