//
//  Main.cpp
//  C++_Central
//
//  Created by Adish Betawar on 5/4/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include "Figure.h"
#include "Circle.h"
#include "Triangle.h"
#include <iostream>
#include "Rectangle.h"
#include "Square.h"

using namespace std;

void myDraw(Figure *fig);

int main()
{
    cout << "Excercise 2:\n";
    Figure *fig;
    Triangle *tri = new Triangle;
    
    fig = tri;
    fig->draw();
    cout << "\n Derived class Triangle object calling center(). \n";
    fig->center();
    
    myDraw(tri);
    
    Circle *cir = new Circle;
    fig = cir;
    cir->draw();
    cout << "\n Derived class Circle object calling center(). \n";
    cir->center();
    myDraw(cir);
    return 0;
    
}

void myDraw(Figure *fig)
{
    fig->draw();
    cout << "\n myDraw: Derived class object calling center(). \n";
    fig->center();
}


// Part 1
/* CODE OUTPUT WIHOUT VIRTUAL FUNCTIONS
 *
 *
 Calling default constructor from class Triangle.
 Calling Draw function from base class Figure.
 
 Derived class Triangle object calling center().
 Calling Center function from base class Figure.
 Calling Erase function from base class Figure.
 Calling Draw function from base class Figure.
 Calling Draw function from base class Figure.
 
 myDraw: Derived class object calling center().
 Calling Center function from base class Figure.
 Calling Erase function from base class Figure.
 Calling Draw function from base class Figure.
 Calling default constructor from class Circle.
 Calling draw function from Circle class.
 
 Derived class Circle object calling center().
 Calling center function from class Circle.
 Erasing drawing of circle from circle class.
 Calling draw function from Circle class.
 Calling Draw function from base class Figure.
 
 myDraw: Derived class object calling center().
 Calling Center function from base class Figure.
 Calling Erase function from base class Figure.
 Calling Draw function from base class Figure.
*/

// Part 2
/* CODE OUTPUT USING VIRTUAL
 *
 *
 Derived class Triangle object calling center().
 Calling center function from class Triangle.
 Calling erase function from class Triangle.
 Calling draw function from class Triangle.
 Calling draw function from class Triangle.
 
 myDraw: Derived class object calling center().
 Calling center function from class Triangle.
 Calling erase function from class Triangle.
 Calling draw function from class Triangle.
 Calling default constructor from class Circle.
 Calling draw function from Circle class.
 
 Derived class Circle object calling center().
 Calling center function from class Circle.
 Erasing drawing of circle from circle class.
 Calling draw function from Circle class.
 Calling draw function from Circle class.
 
 myDraw: Derived class object calling center().
 Calling center function from class Circle.
 Erasing drawing of circle from circle class.
 Calling draw function from Circle class.
 */

/*
*
 Following observations from about output,
 Part 1: For not using virtual functions:
 1. After creating Triangle class, calling erase, center(), and draw() will execute base implementation.
 2. Same observation made by circle.
 
 Part 2: For using virtual functions:
 1. After creating Triangle class, calling erase, center(), and draw() will execute triangle implementation (functions implemented in the triangle class).
 2. After creating Circle class, calling erase, center(), and draw() will execute triangle implementation (functions implemented in the circle class).
 
*/