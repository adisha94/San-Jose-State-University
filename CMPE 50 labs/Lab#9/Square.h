//
//  Square.h
//  C++_Central
//
//  Created by Adish Betawar on 5/7/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#ifndef __C___Central__Square__
#define __C___Central__Square__

#include <stdio.h>
#include "Rectangle.h"
class Square : public Rectangle
{
public:
    // own set of virtual functions
    Square();
    Square(float len);
};
#endif /* defined(__C___Central__Square__) */