//
//  Circle.h
//  C++_Central
//
//  Created by Adish Betawar on 5/4/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#ifndef __C___Central__Circle__
#define __C___Central__Circle__

#include <stdio.h>
#include <iostream>
#include "Figure.h"
using namespace std;
class Circle: public Figure
{
private:
    float radius;
public:
    Circle(); // default constructor
    Circle(float cir_radius); // parametric constructor
    Circle(Circle *cir); // copy constructor
    virtual void center();
    virtual void draw();
    virtual void erase();
    
    Circle& operator = (const Circle& b);
};
#endif /* defined(__C___Central__Circle__) */
