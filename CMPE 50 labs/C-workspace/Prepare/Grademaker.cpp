/*
 * Grademaker.cpp
 *
 *  Created on: Jan 15, 2015
 *      Author: Adish Betawar
 */
#include "Grademaker.h"
#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <iostream>



float Calculate_Percentage(float score, float max_score);
float GetAvg();
void Print_Line(char symbol, int times);

int main(void)
{
	char username[200];
	float score = 0.0f;
	float max_score = 0.0f;

	Print_Line('*', 10);
	while(1)
	{
		int choice = 0;
		Print_Line('*', 10);
		printf("1. Enter Username");
		printf("2. Enter exam Scores");
		printf("3. Display average exam scores");
		printf("4. Display summary");
		printf("5. Exit Program");
		Print_Line('-', 10);
		scanf("%i", &choice);
		if (choice == 1)
		{
			printf("Who wants to view grade?");
			scanf("%s", &username);
		}
		else if (choice == 2)
		{
			for (int i = 0; i < 3; i++)
			{
				printf("Score: ");
				scanf("%f", &score);
				printf("Max score");
				scanf("%f", &max_score);
				Calculate_Percentage(score, max_score);
			}
		}
		else if (choice == 3)
		{
			GetAvg();
		}
	}

	return 0;
}


float Calculate_Percentage(float score, float max_score)
{
	float percentage = (score / max_score) * 100;
	return percentage;
}

float GetAvg()
{
	printf("This is a test");
	float score1;
	float score2 = 0.0f;
	float score3 = 0.0f;
	float average = (score1 + score2 + score3) / 3;
	return average;
}

char GetGradeLetter(float grade)
{
	char letterGrade = 'F';
	if (grade <= 100 && grade >= 90)
	{
		letterGrade = 'A';
	}
	else if (grade >= 80)
	{
		letterGrade = 'B';
	}
	else if (grade >= 70)
	{
		letterGrade = 'C';
	}
	else if (grade >= 60)
	{
		letterGrade = 'D';
	}
	else if (grade < 60)
	{
		letterGrade = 'F';
	}
	return letterGrade;
}

void Print_Line(char symbol, int times)
{
	for (int i = 0; i < times; i++)
	{
		printf("%c", symbol);
	}
	printf("\n");
}
