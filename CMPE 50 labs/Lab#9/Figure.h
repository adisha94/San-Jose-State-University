//
//  Figure.h
//  C++_Central
//
//  Created by Adish Betawar on 5/4/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

// Assignment declarations will be done in snake form notation

#ifndef __C___Central__Figure__
#define __C___Central__Figure__

#include <stdio.h>
#include "iostream"
using namespace std;
class Figure
{
public:
    Figure();
    virtual void erase();
    virtual void center();
    virtual void draw();
};

#endif /* defined(__C___Central__Figure__) */
