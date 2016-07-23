//
//  Figure.cpp
//  C++_Central
//
//  Created by Adish Betawar on 5/4/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include "Figure.h"

Figure::Figure() {}

void Figure::erase()
{
    cout << "Calling Erase function from base class Figure." << endl;
}

void Figure::center()
{
    cout << "Calling Center function from base class Figure." << endl;
    erase(); // erase previous drawing diagrm
    draw(); // draw new centered drawing diagram
}

void Figure::draw()
{
    cout << "Calling Draw function from base class Figure." << endl;
}
