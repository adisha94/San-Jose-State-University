//
//  Lab#8_main1.cpp
//  C++_Central
//
//  Created by Adish Betawar on 4/21/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include <stdio.h>
#include "EaseOfAccesss.h"
#include "Polynomial.h"

int main()
{
    double arr_A[5] = {1.0, 1.0, 1.0, 1.0 , 2.0};
    double arr_B[6] = {2.0, 3.0, 5.0, 2.0, 6.0, 7.0};
    cout << "Exercise 1" << endl;
    
    // making dynamic polynomials
    Polynomial *polyA = new Polynomial(arr_A, sizeof(arr_A) / sizeof(double)-1);
    Polynomial *polyB = new Polynomial(arr_B, sizeof(arr_B) / sizeof(double)-1);

    cout << "Polynomial A: " << *polyA;
    cout << "Polynomial B: " << *polyB;
    cout << "Addition of the two polynomials: " << *polyA + *polyB << endl;
    cout << "Substraction of the two polynomials: " << *polyA - *polyB << endl;
    cout << "Multiplication of the two polynomials: " << *polyA + *polyB << endl;
    cout << "Evaluating Polynomial A at x = 4: " << polyA->evaluate(4) << endl;
    cout << "Evaluating Polynomial B at x = 5: " << polyB->evaluate(5) << endl;
    delete polyA;
    delete polyB;
    return 1;
}


/*
 CODE OUTPUT
 Exercise 1
 Polynomial A: 2*x^4 + 1*x^3 + 1*x^2 + 1*x^1 + 1*x^0
 Polynomial B: 7*x^5 + 6*x^4 + 2*x^3 + 5*x^2 + 3*x^1 + 2*x^0
 Addition of the two polynomials: 7*x^5 + 8*x^4 + 3*x^3 + 6*x^2 + 4*x^1 + 3*x^0
 
 Substraction of the two polynomials: -7*x^5 + -4*x^4 + -1*x^3 + -4*x^2 + -2*x^1 + -1*x^0
 
 Multiplication of the two polynomials: 7*x^5 + 8*x^4 + 3*x^3 + 6*x^2 + 4*x^1 + 3*x^0
 
 Evaluating Polynomial A at x = 4: 597
 Evaluating Polynomial B at x = 5: 26017
*/