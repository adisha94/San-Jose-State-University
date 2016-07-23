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
#include <stdlib.h>

ofstream out;
/**
 *  Excercise 3
 *
 **/
int main(void)
{
    out.open("/users/adish/desktop/Grader.dat");
    cout.setf(ios::fixed);
    out.setf(ios::fixed);
    out.precision(2);
    cout.precision(2);
    double val[2][5]; //  stores both homework and test scores
    out.clear();
    cout << "\t\t\t\t\t\t\tWelcome to Grade Destiny" << endl;
    cout << "Enter five HW scores [0-100]: "; // enter homework scores
    for (int i = 0; i < 5; i++)
    {
        cin >> val[0][i]; // getting input for homework scores
        if (val[0][i] > 100)
        {
            printf("\nWill reset score to 100.");
            val[0][i] = 100;
            continue;
        }
        cout << "\t" << val[0][i];
        out << "\t" << val[0][i];
        
    }
    
    double best_hw = 0;
    double worst_hw = 0;
    
    
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
    
    cout << " Best HW: " << best_hw << " Worst HW: " << worst_hw << endl; //printing out the best homework and worst homework portion
    out << " Best HW: " << best_hw << " Worst HW: " << worst_hw << endl;
    
    
    cout << "Enter five Exam scores [0-100]: "; // enter exam scores
    for (int i = 0; i < 5; i++)
    {
        cin >> val[1][i];
        if (val[0][i] > 100)
        {
            printf("\nWill reset score to 100.");
            val[0][i] = 100;
            continue;
        }
        cout << val[1][i] << " ";
        out << val[1][i] << " ";
    }
    
    double is_passed = false;
    double best_exam = 0;
    double worst_exam = 0;
    
    
    
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
        sum_hw += val[0][i];
        for (int j = 0; j < 5; j++)  // combining homework and exam scores
        {
            sum_exams += val[1][j];
        }
    }
    average_hw = sum_hw / 5;
    average_exam = sum_exams / 5;
    overall_grade = (average_exam + average_hw) / 2; // calculating for overall grade
    
    out << "\tAverage HW: " << average_hw << " ";
    out << "\tAverage Exam: "<< average_exam << " ";
    cout << "\tAverage HW: "<< average_hw << " ";
    cout << "\tAverage Exam: " << average_exam << " " << endl;
    out << "\tOverall grade: " << overall_grade << " ";
    cout << "\tOverall grade: " << overall_grade << " " << endl;
    /*
     * checking for passed scores
     * returning pass or fail message
     */
    if (average_exam > 50 && average_hw > 50)
        is_passed = true;
    if (is_passed == true)
    {
        out << "Congradulations, you have passed the class!";
        cout << "Congradluations, you have passed the class!";
    }
    else if(is_passed == false)
    {
        out << "We are sorry to inform you that you have failed the class. Please try again next semester :(." << endl;
        cout << "We are sorry to inform you that you have failed the class. Please try again next semester :(" << endl;
        
    }
    out.close();
}


/* Output Window
 *
 *							Welcome to Grade Destiny
 Enter five HW scores [0-100]: 20 34 45 56 67 76.34
	0.00	0.00	0.00	0.00	0.00 Best HW: 0.00 Worst HW: 0.00
 Enter five Exam scores [0-100]: 0.00 0.00 0.00 0.00 0.00 Best Exam: 0.00
 Worst Exam: 0.00
	Average HW: 0.00 	Average Exam: 0.00
	Overall grade: 0.00
 We are sorry to inform you that you have failed the class. Please try again next semester :(
 **/
