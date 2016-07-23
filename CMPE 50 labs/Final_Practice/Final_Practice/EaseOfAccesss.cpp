//
//  EaseOfAccesss.cpp
//  Final_Practice
//
//  Created by Adish Betawar on 5/12/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include "EaseOfAccesss.h"



// printing extra lines to create space in the console
void MakeSpace(int space)
{
    for (int i = 1; i <= space; i++)
    {
        cout << "\n";
    }
}

// prints a line with your favorite character for making lines
void printLines(int times, char symbol)
{
    cout << "\n";
    for (int i = 1; i < times; i++)
    {
        cout << symbol;
        if (i == times)
        {
            cout << symbol << endl;
        }
    }
}

// swap function using a temp variable
void Swapv1(int num1, int num2)
{
    int temp;
    temp = num1;
    num1 = num2;
}

// swap function without using a temp variable
void Swapv2(int& a, int& b)
{
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
}