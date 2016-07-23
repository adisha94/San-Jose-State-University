//
//  main.cpp
//  Final_Practice
//
//  Created by Adish Betawar on 5/11/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include "EaseOfAccesss.h"
#include "TemplateStyle.cpp"


template<typename genericType> void Swap(genericType a, genericType b);
template<typename genType> void Display(genType a);
int something (int a, int b) throw(char);

int main()
{
    int value1;
    int value2;
    
    cout << "Input values for swap" <<endl;
    cin >> value1;
    cin >> value2;
    
    Swap(value1, value2);
    Display('A');
    Display(.22);
    Display(022);
    Display(33);
    Display("this is a test\n");
    return 0;
}

int something (int a, int b) throw(char)
{
    // insert something
    if(true)
        throw 'c';
    
    return 2;
}