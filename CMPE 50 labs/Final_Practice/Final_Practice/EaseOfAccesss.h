//
//  EaseOfAccesss.h
//  C++_Central
//
//  Created by Adish Betawar on 2/20/15
// updated by Adish Betawar on 5/04/15
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#ifndef C___Central_EaseOfAccesss_h
#define C___Central_EaseOfAccesss_h


#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <cstdlib>
#include <unistd.h> // for changing the directory of file locations and stuff like that.
#include <string>
#include <cctype> // what is this portion about again?
#include <time.h>


using namespace std;


template<typename genericType> void Swap(genericType gen1, genericType gen2); // swapping for any data type
template<typename genType> void Display(genType a);
void MakeSpace(int space); // creates as many lines in console to provide clearer view for user
void printLines(int times, char symbol); // prints a line to make dividers should the need arises for the programmer


#endif