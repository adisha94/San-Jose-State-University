////
////  Lab5Part1.cpp
////  C++_Central
////
////  Created by Adish Betawar on 3/15/15.
////  Copyright (c) 2015 Adish Betawar. All rights reserved.
////
//
//#include <iostream>
//#include <unistd.h> // for changing the directory of files
//using namespace std;
//
///// creating the student record
//class StudentRecord
//{
//public:
//    // default constructor
//    StudentRecord();
//    // getters
//    double get_score_quiz1();
//    double get_score_quiz2();
//    double get_score_midterm();
//    double get_score_final();
//    // setters
//    void set_score_quiz1(double x);
//    void set_score_quiz2(double y);
//    void set_score_midterm(double t);
//    void set_score_final(double z);
//    
//    // other methods
//    void calculateAverage();
//    double get_Weighted_Average();
//private:
//    double quiz_Score1;
//    double quiz_Score2;
//    double midterm_Score;
//    double finalScore;
//    double student_Average;
//};
//
//
//// globals
//double quiz_weight = 0.25; // quizzes are weighted at 25%
//double midterm_weight = 0.25; // midterms are weighted at 25%
//double final_weight = 0.50; // the final exam is weighted at 50%
//double max_quiz_points = 10; // there are a total of 10 points on the two quizzes
//double max_midterm_points = 100; // there are a total of 100 points on the midterm
//double max_final_points = 100; // there are a total of 100 points on the final
//
//
//// default constructor definition
//StudentRecord::StudentRecord()
//{
//    quiz_Score1 = 0.0f;
//    quiz_Score2 = 0.0f;
//    midterm_Score = 0.0f;
//    finalScore = 0.0f;
//    student_Average = 0.0f;
//}
//
//// method definitions
//double StudentRecord::get_score_quiz1()
//{
//    return quiz_Score1;
//}
//
//void StudentRecord::set_score_quiz1(double x)
//{
//    if(x > max_quiz_points)
//    {
//        quiz_Score1 = max_quiz_points;
//    }
//    else
//    {
//        quiz_Score1 = x;
//    }
//}
//double StudentRecord::get_score_quiz2()
//{
//    return quiz_Score2;
//}
//void StudentRecord::set_score_quiz2(double y)
//{
//    if(y > max_quiz_points)
//    {
//        quiz_Score2 = max_quiz_points;
//    }
//    else
//    {
//        quiz_Score2 = y;
//    }
//}
//double StudentRecord::get_score_midterm()
//{
//    return midterm_Score;
//}
//void StudentRecord::set_score_midterm(double t)
//{
//    if (t > max_midterm_points)
//    {
//        t = max_midterm_points;
//    }
//    else
//    {
//        midterm_Score = t;
//    }
//    midterm_Score = t * midterm_weight;
//}
//double StudentRecord::get_score_final()
//{
//    return finalScore;
//}
//void StudentRecord::set_score_final(double z)
//{
//    if (z > max_final_points)
//    {
//        z = max_final_points;
//    }
//    else
//    {
//        finalScore = z;
//    }
//}
//void StudentRecord::calculateAverage()
//{
//    student_Average = (quiz_Score1+quiz_Score2) * quiz_weight +
//                        midterm_Score * midterm_weight +
//                        finalScore * final_weight;
//}
//
//double StudentRecord::get_Weighted_Average()
//{
//    return student_Average;
//}
//
//
//// main function
//int main2()
//{
//    double score1;
//    double score2;
//    double midterm;
//    double final;
//    StudentRecord info;
//    
//    // asking for user input
//    cout << "Add your scores here for yo class" << endl;
//    cout << "Quiz score #1: ";
//    cin >> score1;
//    info.set_score_quiz1(score1);
//    cout << "Quiz score #2: ";
//    cin >> score2;
//    info.set_score_quiz2(score2);
//    cout << "Midterm score: ";
//    cin >> midterm;
//    info.set_score_midterm(midterm);
//    cout << "Final score: ";
//    cin >> final;
//    info.StudentRecord::set_score_final(final);
//    info.StudentRecord::calculateAverage();
//    // output screen
//    cout << "\t\t\tGrade for class\n";
//    cout << "Quiz 1: " << info.get_score_quiz1() << endl;
//    cout << "Quiz 2: " << info.get_score_quiz2() << endl;
//    cout << "Midterm score: " << info.get_score_midterm() << endl;
//    cout << "Final score: " << info.get_score_final() << endl;
//    cout << "Overall average in the class: " << info.get_Weighted_Average() << endl;
//    return 0;
//}
//
//
///*
//*   CODE OUTPUT:
// 
// Add your scores here for yo class
// Quiz score #1: 9
// Quiz score #2: 5
// Midterm score: 78
// Final score: 12
// Grade for class
// Quiz 1: 9
// Quiz 2: 5
// Midterm score: 19.5
// Final score: 12
// Overall average in the class: 14.375
//*/