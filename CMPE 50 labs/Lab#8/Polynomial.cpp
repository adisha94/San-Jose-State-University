/*
 * Polynomial.cpp
 *
 *  Created on: Oct 24, 2013
 *      Author: cltarng
 */


#include <iostream>
#include <cmath>
#include "polynomial.h"
using namespace std;


Polynomial::Polynomial()
{
	degree = 10;
	coeff = new double[degree+1];
	for (int i = 0; i <= degree; i++)
	{
		coeff[i] = 0;
	}
}

Polynomial::Polynomial(int degr)
{
	degree = degr;
	coeff = new double[degree+1];
	for (int i = 0; i <= degree; i++)
	{
		coeff[i] = 0;
	}
}

Polynomial::Polynomial(const Polynomial &poly)
{
	degree = poly.get_degree();
	coeff = new double[degree+1];
	for (int i = 0; i <= degree; i++)
	{
		coeff[i] = poly.get_coeff(i);
	}
}

Polynomial::Polynomial(double cf[], int deg)
{
	degree = deg;
	coeff = new double[degree+1];
	for (int i = 0; i <= degree; i++)
	{
		coeff[i] = cf[i];
	}
}

Polynomial::~Polynomial() // default destructor
{
	delete [] coeff;
}

int Polynomial::get_degree() const
{
	return degree;
}

double Polynomial::get_coeff(int deg) const
{
	if (degree < deg)
	{
		return 0;
		// The input degree is larger than the polynomial degree
	}
	return coeff[deg];
}

void Polynomial::set_coeff(int degr, double val)
{
	if (degree < degr)
	{
		cout << "Degree exceeded." << endl;
		return;
	}
	coeff[degr] = val;
}

// Evaluate the polynomial
double Polynomial::evaluate(double val)
{
	double result = 0;
	for (int i = 0; i <= degree; i++)
	{
		result = result + coeff[i] * pow(val, i);
	}
	return result;
}

// Assignment operator
void Polynomial::operator = (const Polynomial &poly)
{
	if (this == &poly)
	{
		// Copy to itself. Nothing to be done.
		return;
	}
	degree = poly.get_degree();
	delete [] coeff;
	coeff = new double[degree+1];

	for (int i = 0; i <= degree; i++)
	{
		coeff[i] = poly.get_coeff(i);
	}
	return;
}

// Overloaded operator + for polynomial and polynomial
Polynomial operator + (const Polynomial &pola, const Polynomial &polb)
{
	int degA = pola.get_degree();
	int degB = polb.get_degree();

	int max_degr;

	if (degA > degB)
	{
		max_degr = degA;   
	}
    else
	{
		max_degr = degB;
	}

	Polynomial result(max_degr);

	int i;
	for (i = 0; i <= degA && i <= degB; i++)
	{
		double nc = pola.get_coeff(i) + polb.get_coeff(i);
		result.set_coeff(i, nc);
	}

	// Finish the rest of the coefficients
	for (; i <= max_degr; i++)
	{
		if (degA != max_degr)
		{
			result.set_coeff(i, polb.get_coeff(i));
		}
        else
		{
			result.set_coeff(i, pola.get_coeff(i));
		}
	}
	return result;
}

// overload operator for + for polynomial and constant
Polynomial operator + (const double &regular_num, const Polynomial &polya)
{
    Polynomial result(polya);
    result.set_coeff(0, polya.get_coeff(0) + regular_num); // setting the value of the final coefficient for added result
    return result;
}

Polynomial operator + (const Polynomial &polya, const double &regular_num)
{
    return regular_num + polya;
}



Polynomial operator - (const Polynomial &polya, const Polynomial &polyb)
{
    return polya + (-1 * polyb);
}

Polynomial operator - (const double &regular_num, const Polynomial &polya) // Added in class as per exercise
{
    return regular_num + (-1 * polya);
}

Polynomial operator - (const Polynomial &polya, const double &regular_num) // Added in class as per exercise
{
    return polya + (-1 * regular_num);
}



Polynomial operator * (const Polynomial &polya, const Polynomial &polyb)
{
    // defining the degree indexes
    int degree_of_A = polya.get_degree();
    int degree_of_B = polyb.get_degree();

// SAMPLE" 2x^3 * 3x^2 = (2*3)x^(3+2) ==> 6x^5
    int max_degr = degree_of_A + degree_of_B; // resulting polynomial degree

    Polynomial resulting_poly(max_degr); // create the polynomial that will generate the resulting statement
    
    // performing operation of multiplication of polynomial
    // iterating through every element of polynomial A
    for (int i = 0; i <= degree_of_A; i++)
     {
         for (int j = 0; j <= degree_of_B; j++) // iterating through every element of polynomial B
         {
             // 1. Multiply the coefficients
             // 2. Add the degrees to get final index in the resulting coefficient array
             // 3. Add the like terms to acquire final answer
             // 4. Store the resulting expression in the resultant coefficient array
             resulting_poly.set_coeff( i + j, resulting_poly.get_coeff(i+j) + polya.get_coeff(i) * polyb.get_coeff(j));
         }
     }
    return resulting_poly;
}

Polynomial operator * (const double &regular_num, const Polynomial &polya) // Added in class as per exercise
{
    // use copy constructor and iterate through the loop to get result
    Polynomial result(polya);
    for (int i = 0; i <= polya.get_degree(); i++)
    {
        double nc = polya.get_coeff(i) * regular_num;
        result.set_coeff(i, nc);
    }
    return result;
}

Polynomial operator * (const Polynomial &polya, const double &regular_num) // Added in class as per exercise
{
    return regular_num * polya;
}

// Overloaded << operator
ostream& operator << (ostream& ost, const Polynomial &pol)
{
	int degr = pol.get_degree();

	for (int i = degr; 0 <= i; i--)
	{
		cout << pol.get_coeff(i) << "*x^" << i << " ";
		if (i > 0)
		{
			cout << "+ ";
		}
	}
	cout << endl;
	return ost;
}

