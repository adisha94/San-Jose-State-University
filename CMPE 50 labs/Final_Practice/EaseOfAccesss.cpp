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