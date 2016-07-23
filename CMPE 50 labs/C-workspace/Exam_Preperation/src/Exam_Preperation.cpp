//============================================================================
// Name        : Exam_Preperation.cpp
// Author      : Adish Betawar
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>
#include <IOStream>

char GetGradeLetter(float grade);

int main(void)
{
	char userFirstName[20];
	char userLastName[20];
	printf("Enter your first and last name to enter\n");
	scanf("%s", &userFirstName[0]);
	scanf("%s", &userLastName[0]);

	float examScores[3];
	float score;
	float maxScore;
	float result = 0.0f;
	float sum = 0;


	for (int i = 0; i < 3; i++)
	{
		printf("\nScore for exam#%i: ", (i+1));
		scanf("%f", &score);
		printf("Max score for #%i:  ", (i+1));
		scanf("%f", &maxScore);
		result = (score / maxScore) * 100;
		examScores[i] = result;
		printf("Score for exam#%i entered \n \t Score acquired: %.0f\n", (i+1), result);
	}

	// calculating average
	for (int j = 0; j < 3; j++)
	{
		sum += examScores[j]; // raw sum of scores
	}
	float average = sum / 3;
	printf("average score: %.f", average);


	char letterGrade = GetGradeLetter(average);
	printf("\n \nHello %s %s, these are your exam scores: \n \t %.0f, %.0f, %.0f \n From these scores, your average grade is %.0f and so you have a(n) %c", userFirstName, userLastName, examScores[0], examScores[1], examScores[2], average, letterGrade);

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
