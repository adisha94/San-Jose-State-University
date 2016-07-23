//
//  Sort.h
//  C++_Central


/*
 this header file is for simplifying and saving time for sorting numbers in a list from smallest number to largest number
       As there are many kinds of sorting methods and algorithms, this header file is meant to show the declarations for different kinds of sorting methods (or function)
 //  Created by Adish Betawar on 2/21/15.
 // More sorting methods will be added soon for our purposese.
 //  Copyright (c) 2015 Adish Betawar. All rights reserved.
 //

 */

#ifndef C___Central_Sort_h
#define C___Central_Sort_h


void SortSmallestoLargest(int a[], int number_used);
void SortLargestoSmall(int a[], int number_used);
void swap_values(int &a, int &b);
int index_of_smallest(const int a[], int start_index, int number_used);
int index_of_largest(const int a[], int start_index, int number_used);
#endif
