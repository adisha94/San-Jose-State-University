//
//  Lab3p3.cpp
//  C++_Central
//
//  Created by Adish Betawar on 2/21/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//


#include "EaseOfAccesss.h"
#include "Sort.h"
#include <iomanip>

int main()
{
    /*
       1. Read information from first file and store that information in  array.
       2. Read information from second file and append that information in same array.
       3. Sort the array from smallest to largest
       4. Print report in the required format
     */

    int array1[50];
    ofstream exe3Out;
    ifstream exe3In;
    chdir("//users//adish//desktop");
    //
    //  1. Read information from first file and store that information in  array.
    exe3In.open("//users//adish//desktop//array1.txt");
    if (exe3In.fail())
    {
        cout << "Failed to open output file: //users//adish//desktop//array1.txt.\n";
        cout << "Program terminated";
        exit(1);
    }

    int count = 0;
    while (!exe3In.eof())
    {
        exe3In >> array1[count++]; // reading and storing in charArray variable
    }

    exe3In.close();

    //
    //        2. Read information from second file and append that information in  same array.
    exe3In.open("//users//adish//desktop//array2.txt");
    if (exe3In.fail())
    {
        cout << "Failed to open output file: //users//adish//desktop//array2.txt\n";
        cout << "Program terminated";
        exit(1);
    }

    while (!exe3In.eof())
    {
        exe3In >> array1[count++]; // reading and appending in the same array

    }
    exe3In.close();

    //
    //      3. Sort the array from smallest to largest
    SortSmallestoLargest(array1, count);
    //
    // 4. Print report in the required format
    cout << "Printing required merged file report\n";
    exe3Out.open("//users//adish//desktop//MergedArray.txt");
    if (exe3Out.fail())
    {
        cout << "Failed to open output file: //users//adish//desktop//MergedArray.txt.\n";
        cout << "Program terminated";
        exit(1);
    }
    for (int i = 0; i < count; i++)
    {
        if (i == 0)
        {
            cout << array1[i];
            exe3Out << array1[i];
        }
        else
        {
            cout << setw(i) << array1[i];
            exe3Out << setw(i) << array1[i];
        }
    }
    cout << "\n";
    exe3Out << "\n";
    return 0;
}
