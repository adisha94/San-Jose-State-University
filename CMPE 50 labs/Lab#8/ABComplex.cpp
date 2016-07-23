//
//  ABComplex.cpp
//  C++_Central
//
//  Created by Adish Betawar on 4/20/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include "ABComplex.h"
#include "Persona.h"

ABComplex::ABComplex()
{
    realNumber = 0.0;
    imaginaryNumber = 0.0;
}

ABComplex::ABComplex(double real_part)
{
    // should return real_part + imaginary_part*i
    realNumber = real_part;
    imaginaryNumber = 0.0;
}


ABComplex::ABComplex(double real_part, double imaginary_part)
{
    realNumber = real_part;
    imaginaryNumber = imaginary_part;
}

/*
 overloading addition '+' operator
 */
ABComplex operator + (const ABComplex& comp1, const ABComplex& comp2) // add the complex numbers
{
    ABComplex sum;
    sum.realNumber = comp1.realNumber + comp2.realNumber;
    sum.imaginaryNumber = comp1.imaginaryNumber + comp2.imaginaryNumber;
    return sum;
}

/*
 overloading the '-' operator
 */
ABComplex operator - (const ABComplex& comp1, const ABComplex& comp2) // subtract the complex numbers
{
    ABComplex difference;
    difference.realNumber = comp1.realNumber - comp2.realNumber;
    difference.imaginaryNumber = comp1.imaginaryNumber - comp2.imaginaryNumber;
    return difference;
}

/*
 overloading the '*' operator
 */

ABComplex operator * (const ABComplex& comp1, const ABComplex& comp2) // multiply the ABComplex numbers  -----> need to use rules of ABComplex number multiplying
{
    ABComplex product;
    // (a + b * i) * (c + d * i) == (a * c – b * d) + (a * d + b * c) * i
    product.realNumber = comp1.realNumber * comp2.realNumber - comp1.imaginaryNumber * comp2.imaginaryNumber;
    product.imaginaryNumber = comp1.realNumber * comp2.imaginaryNumber + comp1.imaginaryNumber * comp2.realNumber;
    
    return product;
}

bool operator == (const ABComplex& comp1, const ABComplex& comp2)
{
    if (comp1.realNumber == comp2.realNumber)
    {
        if (comp1.imaginaryNumber == comp2.imaginaryNumber)
        {
            return true;
        }
    }
    return false;
}

// overloading input operator
istream& operator >> (istream& ins , ABComplex& ac1)
{
    cout << "Enter real part: ";
    ins >> ac1.realNumber;
    cout << "Enter imaginary part: ";
    ins >> ac1.imaginaryNumber;
    return ins;
}

// overloading output operator
ostream& operator << (ostream& outs, const ABComplex& ac1)
{
    // a + b*i ----------------> format for ABComplex numbers
    outs << ac1.realNumber << " + " << ac1.imaginaryNumber << "i";
    return outs;
}
