//============================================================================
// Name        : Other_Training.cpp
// Author      : Adish Betawar
// Version     :
// Copyright   : Your copyright notice
// Description : Different stuff for other stuff
//============================================================================

#include <Stdio.h>
#include <Stdlib.h>
#include <String.h>
#include <iostream>
#include <Math.h>

typedef struct
{
	int sid;
	char name[128];
	int age;
} Student_t;

Student_t me;

Student_t get_Student_Info(int num)
{
	Student_t st;
	printf("%i: Enter Id: ", num); scanf("%i", &st.sid);
	printf("%i: Enter name: ", num); scanf("%s", &st.name[0]);
	printf("%i: Enter age: ", num); scanf("%i", &st.age);
	return st;
}


void print_Student_Info(int num, Student_t *st_ptr)
{
	printf("\n%i: SID: %i \n", num, st_ptr->sid); // when we use a pointer to refer the reference location of the structure members, we need to use the '->' in order the access the members of the array. In this way we can determine the original location of the original array.
	printf("%i: Name: %s \n", num, st_ptr->name);
	printf("%i: Age: %i \n", num, st_ptr->age);
}



int main(void)
{

	int size;
	printf("Determine size: "); scanf("%i", &size);
	Student_t arr_st[size];
	for (int i = 0; i < size; i++ )
	{
		arr_st[i] = get_Student_Info(i+1);
	}

	for (int j = 0; j < size; j++)
	{
		// Student_t st = arr_st[j] using the copy of this function's local variable of Student_t
		print_Student_Info(j+1, &arr_st[j]);
	}
}


