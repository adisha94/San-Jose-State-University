//
//  Sort.cpp
//  C++_Central
//
//  Created by Adish Betawar on 2/21/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include "Sort.h"

// sorts from smallest to largest
void SortSmallestoLargest(int a[], int number_used)
{
    int index_of_next_smallest;
    for (int i = 0; i < number_used - 1; i++)
    {
        index_of_next_smallest = index_of_smallest(a, i, number_used);
        swap_values(a[i], a[index_of_next_smallest]);
    }
}

//sorts from smallest to largestddd
void SortLargestoSmall(int a[], int number_used)
{
    int index_of_next_largest;
    for (int i = 0; i < number_used - 1; i++)
    {
        index_of_next_largest = index_of_largest(a, i, number_used);
        swap_values(a[i], a[index_of_next_largest]);
    }
}


void swap_values(int &a, int &b)
{
    int temp;
    temp = a;
    a = b;
    b = temp;
}

int index_of_smallest(const int a[], int start_index, int number_used)
{
    int min = a[start_index], index_of_min = start_index;
    for (int i = start_index + 1; i < number_used; i++)
    {
        if (a[i] < min)
        {
            min = a[i];
            index_of_min = i;
        }
    }
        return index_of_min;
}

int index_of_largest(const int a[], int start_index, int number_used)
{
    int max = a[start_index], index_of_max = start_index;
    for (int i = start_index + 1; i < number_used; i++)
    {
        if (a[i] > max)
        {
            max = a[i];
            index_of_max = i;
            
        }
    }
    return index_of_max;
}