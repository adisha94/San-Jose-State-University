//============================================================================
// Name        : Further_Study.cpp
// Author      : Adish Betawar
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>
#include <iostream>

typedef struct
{
	char name[50];
	int age;
	int id;
}Student;


Student RequestInfo(Student stud)
{
	printf("Enter Student name: ");
	scanf("%s", &stud.name);
	printf("Student age: ");
	scanf("%i", &stud.age);
	printf("Enter Student ID number: ");
	scanf("%i", &stud.id);
	return stud;
}
int main(void)
{
	Student *genericStudent;
	int size = 3;
	Student studDatabase[size];

	for (int i = 0; i < size; i++)
	{
		Student boy = studDatabase[i];
		RequestInfo(boy);

	}

	printf("\n\n\n");
	printf("\t\t\tSTUDENT DATABASE");
	printf("\nName: ");
	printf("\t\tAge: ");
	printf("\t\tStudent ID: ");

	for (int j = 0; j < size; j++)
	{
		Student boy = studDatabase[j];
		printf("\n%s \t%i \t%i", boy.name, boy.age, boy.id);
	}

}



