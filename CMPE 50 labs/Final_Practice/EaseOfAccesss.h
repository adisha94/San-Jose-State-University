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
#include <vector>

using namespace std;

void MakeSpace(int space); // creates as many lines in console to provide clearer view for user
void printLines(int times, char symbol); // prints a line to make dividers should the need arises for the programmer


template<typename genericType> void Swap(genericType a, genericType b)
{
    cout << "before operation, value1: " << a << " value2: " << b << endl;
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    cout << "after operation value1: " << a << " value2: " << b << endl;
}

template<typename genType> void Display(genType a)
{
    cout << a << endl;
}

template<class BaseType> int Index_of_smallest(const BaseType a[], int start_index, int number_used)
{
    BaseType min = a[start_index];
    int index_of_min = start_index;
    for (int index = start_index + 1; index < number_used; index++)
        if (a[index] < min)
        {
            min = a[index];
            index_of_min = index; //min is the smallest of a[start_index] through a[index]
        }
    return index_of_min;
}

template<class BaseType> void Sort(BaseType a[], int number_used) //Place the correct value in a[index]: index_of_next_smallest =
{
    int index_of_next_smallest;
    for (int index = 0; index < number_used - 1; index++)
    {
        index_of_smallest(a, index, number_used);
        swap_values(a[index], a[index_of_next_smallest]);
        //a[0] <= a[1] <=...<= a[index] // are the smallest of the original array
                                        //elements. The rest of the elements are in the remaining positions.
    }
}

template<typename T> int CheckArrayandReturnIndex(T a[], int indexUsed, T value) // 'value' is the value used for checking
{
    for (int index = 0; index < indexUsed; index++)
    {
        if (a[index] == value)
        {
            return index;
        }
    }
    return -1;
}


#endif