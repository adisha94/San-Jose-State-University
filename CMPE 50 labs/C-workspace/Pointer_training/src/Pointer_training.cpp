//============================================================================
// Name        : Pointer_training.cpp
// Author      : Adish Betawar
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <stdio.h>
#include <String.h>
#include <Math.h>
#include <stdlib.h>



/**
 * three rules of pointers
 * 	- Declare a variable pointer with a '*'
 * 	- Without a '*', you are talking about the arrow
 * 	- With * (dereference), you are talking about the value pointed by the arrow
 */

int average(int *pointer_to_array, int size) // we need to know how far out do we need to go to determine size of the array
 {
	int sum = 0;
	for (int i = 0; i < size; i++)
	{
		sum += pointer_to_array[i]; // (*pointert_to_array + i)
	}
	return sum / size;
}

int main(void)
{
	int array_a[] = {1,2,3};
	int array_b[] = {1,2,3,4,5,6,7,8,9,10};

	// find the average of the array
	int avg_a = average(array_a, 3);
	int avg_b = average(array_b, 10);

	printf("Average of array_a: %i\nAverage of array_b: %i", array_a, array_b);
}
