//
//  Rectangle.h
//  C++_Central
//
//  Created by Adish Betawar on 5/4/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#ifndef __C___Central__Rectangle__
#define __C___Central__Rectangle__

#include <stdio.h>
#include "Figure.h"

class Rectangle : public Figure
{
protected:
    float length;
    float width;
public:
    // own set of virtual functions
    Rectangle();
    Rectangle(float len, float wid);
    virtual void erase();
    virtual void center();
    virtual void draw();
};
#endif /* defined(__C___Central__Rectangle__) */
