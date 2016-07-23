//
//  TemplateStyle.cpp
//  Final_Practice
//
//  Created by Adish Betawar on 5/13/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include <stdio.h>
#include <iostream>
using namespace std;

template<typename genericType> void Swap(genericType a, genericType b);
template<typename genType> void Display(genType a);

template<typename genericType> void Swap(genericType a, genericType b)
{
    cout << "before operation, value1: " << a << " value2: " << b << endl;
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    cout << "after operation value1: " << a << " value2: " << b << endl;
}

template<typename genType> void Display(genType a)
{
    cout << a << endl;
}