/*
 * Quick_Create.cpp
 *
 *  Created on: Feb 21, 2015
 *      Author: Adish
 */


#include "Quick_Create.h";
ofstream out;
ifstream in;


int main()
{
	char filename[20];
	char essay[9]; // stores the essay in here'

	chdir("//users//adish//desktop");
	cout << "file name (include extension): ";
	cin >> filename;
	in.open(filename);
	if (in.fail())
	{
		cout << "Unable to locate amd open file";
		exit(1);
	}
	for (int i = 0; i < sizeof(essay); i++)
	{
		in >> essay[i];
		cout << essay << " ";
	}
	in.close();

	out.open("EssayWriter.txt", ios::app);
	int num;
	cout << "Press 1 to continue\n";
	cin >> num;
	for (int i = 0; i < sizeof(essay); i++)
	{
		cout << essay[i] << " ";
		out << essay[i] << " ";
	}
}
