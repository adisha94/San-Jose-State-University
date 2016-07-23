/*
 * Track_star.cpp
 *
 *  Created on: Feb 7, 2015
 *      Author: Adish Betawar
 *      Description: This program is going to store valuable ip addresses for various website. This will be loaded onto rasppberry pi and other mobile devices sometime in the future.
 *      			 This software is strictly restricted to store ip addresses and nothing else.
 */

using namespace std;
#include <iostream>
#include <fstream>
#include <stdio.h>


ofstream out;
ifstream in;
int main(void)
{
	in.open("/Users/Adish/desktop/Pass.psw");
	out.open("/Users/Adish/desktop/Pass.psw");
	in.open("storage.dat");
	int number_of_store;
	cout << "How many addresses to store?" << endl;
	cin >> number_of_store;
	char IP_Address[500];
	char WebsiteName[500];
	cout << "Please input IP address to store along with website name" << endl;
	for (int i = 1; i <= number_of_store; i++)
	{
		cin >> WebsiteName;
		cin >> IP_Address;
		out << WebsiteName << ": " << IP_Address << endl;
	}
	out.close();
}

