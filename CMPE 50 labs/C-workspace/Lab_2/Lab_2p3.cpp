/*
 * Lab_2p3.cpp
 *
 *  Created on: Feb 2, 2015
 *      Author: Adish Betawar
 */

using namespace std;
#include <iostream>
#include <stdio.h>
#include <fstream>

ofstream out;

int main(void)
{
	out.open("/users/adish/desktop/Grader.dat");
	cout.setf(ios::fixed);
	out.setf(ios::fixed);
	out.precision(2);
	cout.precision(2);
	double val[2][5];

	cout << "Enter enter five HW scores [0-100]: "; // enter homework scores
	for (int i = 0; i < 5; i++)
	{
		cin >> val[0][i];
		cout << "\t" << val[0][i];
		if (i == 4)
		{
			out << "\t" << val[0][i] << endl;
			cout << val[0][i] << endl;
		}
	}
	cout << "Enter enter five Exam scores [0-100]: "; // enter exam scores
	for (int i = 0; i < 5; i++)
	{
		cin >> val[1][i];
		out << val[1][i] << " ";
		if (i == 4)
		{
			out << val[1][i] << endl;
			cout << val[1][i] << endl;
		}
	}

	double best_hw = 0;
	double worst_hw = 0;
	double is_passed = false;
	double best_exam = 0;
	double worst_exam = 0;

	for (int i = 0; i < 5; i++) // calculating for best and worst homework score
	{
		if(val[0][i] > best_hw) // finding best homework score
		{
			best_hw = val[0][i];
		}
		if(val[0][i] < worst_hw) // finding worst homework score
		{
			worst_hw = val[0][i];
		}

	}

	cout << "Best HW: " << best_hw << endl;
	out << "Best HW: " << best_hw << endl;

	cout << "Worst HW: " << worst_hw << endl;
	out << "Worst HW: " << worst_hw << endl;

	cout << "Best Exam: " << best_exam << endl;
	out << "Best Exam: " << best_exam << endl;

	cout << "Worst Exam: " << worst_exam << endl;
	out << "Worst Exam: " << worst_exam << endl;

	for (int i = 0; i < 5; i++) // calculating for best and worst exam score
	{
		if (val[1][i] > best_exam) // finding best exam score
		{
			best_exam = val[1][i];
		}
		if (val[1][i] < worst_exam) // finding worst exam score
		{
			worst_exam = val[1][i];
		}
	}

/*
 * calculating average of every test and homework score
 * upper loop using homework scores from val[0][i]
 * lower loop using exam scores from val[1][j]
 */
	double average_hw = 0;
	double average_exam = 0;
	double sum_hw = 0;
	double sum_exams = 0;
	double overall_grade = 0;
	for (int i = 0; i< 5; i++) // calculating averages
	{
		for (int j = 0; j < 5; j++)  // combining homework and exam scores
		{
			sum_hw += val[0][i];
			sum_exams += val[1][j];
		}
		average_hw = sum_hw / 5;
		average_exam = sum_exams / 5;
		overall_grade = (average_exam + average_hw) / 2; // calculating for overall grade
	}
	out << "\tAverage HW: " << average_hw << " " << endl;
	out << "\tAverage Exam: "<< average_exam << " " << endl;
	cout << "\tAverage HW: "<< average_hw << " " << endl;
	cout << "\tAverage HW: " << average_exam << " " << endl;
	cout << "\tOverall grade: " << overall_grade << " " << endl;
	/*
	 * checking for passed scores
	 * returning pass or fail message
	 */
	if (average_exam > 50 && average_hw > 50)
		is_passed = true;
	if (is_passed == true)
	{
		out << "Congraduations, you have passed the class!";
		cout << "Congraduations, you have passed the class!";
	}
	else if(is_passed == false)
	{
		out << "We are sorry to inform you that you have failed the class. Please try again next semester :(." << endl;
		cout << "We are sorry to inform you that you have failed the class. Please try again next semester :(" << endl;
	}
	out.close();
}
