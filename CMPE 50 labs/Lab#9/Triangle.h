//
//  Triangle.h
//  C++_Central
//
//  Created by Adish Betawar on 5/4/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//


#ifndef __C___Central__Triangle__
#define __C___Central__Triangle__

#include <stdio.h>
#include <iostream>
#include "Figure.h"
using namespace std;

class Triangle: public Figure
{
private: // properties of triangle
    float base;
    float height;
public:
    Triangle(); // default constructor
    Triangle (float tri_Base, float tri_height);
    virtual void center(); // centers the triangle
    virtual void erase();
    virtual void draw();
};

#endif /* defined(__C___Central__Triangle__) */
