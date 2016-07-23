//
//  Rectangle.cpp
//  C++_Central
//
//  Created by Adish Betawar on 5/7/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include "Rectangle.h"

Rectangle::Rectangle()
{
    length = 0;
    width = 0;
}
Rectangle::Rectangle(float len, float wid)
{
    length = len;
    width = wid;
}

void Rectangle::center()
{
    cout << "Calling center function from class Circle." << endl;
    erase(); // erase previous drawing diagrm
    draw(); // draw new centered drawing diagram
}
void Rectangle::draw()
{
    cout << "Calling draw function from Circle class." << endl;
}

void Rectangle::erase()
{
    cout << "Erasing drawing of circle from circle class." << endl;
}