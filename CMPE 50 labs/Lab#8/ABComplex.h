//
//  Imaginary.h
//  C++_Central
//
//  Created by Adish Betawar on 4/20/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#ifndef __C___Central__Imaginary__
#define __C___Central__Imaginary__

#include "EaseOfAccesss.h"


// this class is made for Complex numbers, which are essentially 'imaginary numbers' from math and stuff.

// to remmember what an imaginary number is, an imaginary number is a number that is represented as sqrt(-1), with a being a possible number. The resulting conversion of such number will be the following:
//          a*i

// This assignment shall use the camel case notation for declaring variables and functions


// a + b*i is the format for the number writing
class ABComplex
{
private:
    double realNumber; // the real component
    double imaginaryNumber; // the imaginary component
public:
    ABComplex(); // default constructor
    ABComplex(double real_part); // copy constructor
    ABComplex(double real_part, double imaginary_part); // paramaterized constructor
    
    friend ABComplex operator + (const ABComplex& comp1, const ABComplex& comp2); // adding complex
    friend ABComplex operator - (const ABComplex& comp1, const ABComplex& comp2); // substracting complex
    friend ABComplex operator * (const ABComplex& comp1, const ABComplex& comp2); // multiplying complex
    friend bool operator == (const ABComplex& comp1, const ABComplex& comp2); // equality of complex
    friend ostream& operator << (ostream& outs, const ABComplex& ac1); // output operator for complex
    friend istream& operator >> (istream& ins , ABComplex& ac1); // extraction operator for complex
};

const ABComplex i (0,1);
#endif /* defined(__C___Central__Imaginary__) */
