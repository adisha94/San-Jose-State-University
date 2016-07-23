//
//  Circle.cpp
//  C++_Central
//
//  Created by Adish Betawar on 5/4/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include "Circle.h"

Circle::Circle() // default constructor
{
    radius = 0;
    cout << "Calling default constructor from class Circle." << endl;
}

Circle::Circle(float cir_radius) // parametric constructor
{
    radius = cir_radius;
    cout << "Calling parametric constructor from class Circle." << endl;
}

Circle::Circle(Circle *cir)
{
    radius = cir->radius;
}

void Circle::center()
{
    cout << "Calling center function from class Circle." << endl;
    erase(); // erase previous drawing diagrm
    draw(); // draw new centered drawing diagram
}
void Circle::draw()
{
    cout << "Calling draw function from Circle class." << endl;
}

void Circle::erase()
{
    cout << "Erasing drawing of circle from circle class." << endl;
}