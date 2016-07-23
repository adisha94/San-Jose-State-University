/*
 * Password.cpp
 *
 *  Created on: Jan 14, 2015
 *      Author: Adish Betawar
 */

#include "Password.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>


typedef struct
{
	char name[200];
	int age;
	int id;
}Student;

void RequestToStore(Student genericStudent);
void PrintStudentInfo(Student genericStudent)
;
int main(void) // main execution function (method) for code execution
{
	Student stud;
	Student studentDatabase[5];
	for (int i = 0; i < 5; i++)
	{
		printf("%i. ", i+1);
		RequestToStore(stud);
		studentDatabase[i] = stud;
		printf("------------\n");
	}
	printf("\n\n----------------------------------------");
	printf("\nHere is the info that you have given:");
	for (int i = 0; i < 5; i++)
	{
		PrintStudentInfo(stud);
	}

}

void RequestToStore(Student genericStudent)
{
	printf("Name: ");
	scanf("%s", &genericStudent[0].name);
	printf("\nAge: ");
	scanf("%i", &genericStudent.age);
	printf("\nId: ");
	scanf("%i", &genericStudent.id);
	printf("\n");
}

void PrintStudentInfo(Student genericStudent)
{
	printf("\n Name: %s", genericStudent.name);
	printf("\tAge: %i", genericStudent.age);
	printf("\tId: %i", genericStudent.id);

}
