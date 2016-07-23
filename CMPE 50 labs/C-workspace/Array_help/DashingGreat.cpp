/*
 * DashingGreat.cpp
 *
 *  Created on: Jan 15, 2015
 *      Author: Adish
 */
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

typedef struct
{
	char name[50];
	int age;
	int id;
}Student;

Student RequestInfo(Student stud);

int main(void)
{
	Student genericStudent;
	int size = 100;
	Student studDatabase[size];

	for (int i = 0; i < size; i++)
	{
		genericStudent = RequestInfo(genericStudent);
		studDatabase[i] = genericStudent;
	}

	printf("\n\n\n");
	printf("\t\t\tSTUDENT DATABASE");
	printf("\nName: ");
	printf("\tAge: ");
	printf("\tStudent ID: ");

	for (int j = 0; j < size; j++)
	{
		printf("\n%s \t%i \t%i", genericStudent.name, genericStudent.age, genericStudent.id);
	}

}


Student RequestInfo(Student stud)
{
	printf("Enter Student ID number: ");
	scanf("%s", stud.name);
	printf("\nEnter Student age: ");
	scanf("%i", stud.age);
	printf("\nEnter id: ");
	scanf("%i", stud.id);
	return stud;
}
