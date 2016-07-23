//
//  Triangle.cpp
//  C++_Central
//
//  Created by Adish Betawar on 5/4/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include "Triangle.h"

// default constructor
Triangle::Triangle() :  Figure(), base(0), height(0)
{
    cout << "Calling default constructor from class Triangle." << endl;
}

// parametric constructor
Triangle::Triangle (float tri_Base, float tri_height) : Figure(),
    base(tri_Base), height(tri_height)
{
    cout << "Calling parametric constructor from class Triangle." << endl;
}

void Triangle::center() // centers the triangle
{
    cout << "Calling center function from class Triangle." << endl;
    erase(); // erase previous drawing diagrm
    draw(); // draw new centered drawing diagram
}

void Triangle::erase()
{
    cout << "Calling erase function from class Triangle." << endl;
}

void Triangle::draw()
{
    cout << "Calling draw function from class Triangle." << endl;
}
