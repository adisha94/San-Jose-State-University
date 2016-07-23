////
////  Print_2D.cpp
////  C++_Central
////
////  Created by Adish Betawar on 3/5/15.
////  Copyright (c) 2015 Adish Betawar. All rights reserved.
////
//
//#include "EaseOfAccesss.h"
//
void print2dArray();

void print2dArray()
{
    char characterArray[4][5];
    // read input and output it somewhere
    
    
    for (int row = 0; row < 4; row++)
    {
        for (int column = 0; column < 5; column++)
        {
            cin >> characterArray[row][column];
        }
    }
    cout << "\n\n\n\n";
    for (int row = 0; row < 4; row++)
    {
        for (int column = 0; column < 5; column++)
        {
            cout << characterArray[row][column] << " ";
            
        }
        cout << "\n";w
    }
}
