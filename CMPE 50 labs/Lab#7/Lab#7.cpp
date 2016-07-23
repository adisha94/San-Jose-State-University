////
////  Lab#7.cpp
////  C++_Central
////
////  Created by Adish Betawar on 4/6/15.
////  Copyright (c) 2015 Adish Betawar. All rights reserved.
////
//
//#include <iostream>
//#include <fstream>
//#include <stdlib.h>
//#include <cstdlib>
//#include <unistd.h>
//#include <cstring>
//#include <string>
//#include <cctype>
//#include "Persona.h"
//using namespace std;
//
//
//typedef char* Char_ptr;
//
//// function declarations
//int SeatsAvailable(Char_ptr *seats, int rowSize, int numberOfSeatsPerRow);
//void PrintSeatingArrangement(Char_ptr *seats, int rowSize, int numberOfSeatsPerRow);
//
//int main()
//{
//    cout << "Excercise 1\n";
//    MakeSpace(1);
//    printLine(42, '-'); // this functions a line with a symbol of the programmer's choice. function defined in Persona.cpp
//    cout << "\n\t\tWelcome to BlueWing Airways" << endl;
//    printLine(42, '-');
//    MakeSpace(1); // prints extra lines
//    int option;
//    cout << "\n\nWould you like to enter the information from the keyboard or from another file?\n";
//    cout << "\t\t\t1. Keyboard \t\t\t2. File\n";
//    cin >> option;
//    
//    ifstream input;
//    input.open("//users//adish//desktop//input.txt");
//    if (input.fail())
//    {
//        cout << "File does not exist";
//    }
//    
//    
//    int rowSize;
//    cout << "How many rows are in the plane?\n"; // defining number of rows
//    if(option == 1)
//        cin >> rowSize;
//    else if (option == 2)
//        input >> rowSize;
//    const int seatsInEachRow = 4;
//    cout << "There are " << rowSize << " rows and " << seatsInEachRow << " seats in each row on this flight\n";
//    //
//    // getting input for number of seats in an airplane using dynamic array
//    Char_ptr *seats = new Char_ptr[rowSize]; // dynamcally allocating memory for rows
//    //
//    // allocating memory for each row
//    for (int i = 0; i < rowSize; i++)
//    {
//        seats[i] = new char[seatsInEachRow]; // number of seats for each row
//    }
//    //
//    cout << "Today's seating arrangement" << endl;
//    printLine(25, '-');
//    //
//    // filling up the initial seating arrangemnts
//    for (int i = 0; i < rowSize; i++) // rows seating
//    {
//        for (int j = 0; j < 4; j++) // columns seating
//        {
//            seats[i][j] = 65 + j; // converting the ASCII character to get characters 'A' 'B'.... etc.
//        }
//    }
//
//    // begin asking for seat numbers and assign them accordingly
//   while(1)
//   {
//       MakeSpace(1);
//       PrintSeatingArrangement(seats, rowSize, seatsInEachRow);
//       MakeSpace(2);
//       cout << "You have chosen to provide info with keyboard" << endl;
//       cout << "Seats available: " << SeatsAvailable(seats, rowSize, seatsInEachRow) << "/" << (rowSize * seatsInEachRow) << endl;
//       cout << "Enter your desired seat number: ";
//       //
//
//       string seatName = "";
//       //
//       if (option == 1)
//           cin >> seatName;
//       else if (option == 2)
//           input >> seatName;
//       //
//       if (seatName == "end")
//       {
//           break;
//       }
//       if(seatName.length() != 2)
//       {
//           cout << "Incorrect information entered";
//           MakeSpace(3);
//           continue;
//       }
//       char rowNumber = seatName.at(0); // first component of string
//       int rowNumberIndex = 0;
//       if (('1' <= rowNumber) || (rowNumber <= (rowSize + '4'))) // if the row number goes out of bound
//       {
//           rowNumberIndex = rowNumber - 0x30;
//           rowNumberIndex = rowNumberIndex - 1;
//       }
//       else
//       {
//           cout << "Row does not exist";
//           MakeSpace(2);
//           continue;
//       }
//       char seatNumber = seatName.at(1); // second component of string
//       int seatNumberIndex = 0;
//       if (('A' >= seatNumber) || (seatNumber <= (seatsInEachRow + 'D'))) // if the seat name goes out of bound for capital letters
//       {
//           seatNumberIndex = seatNumber - 0x40;
//           seatNumberIndex = seatNumberIndex - 1;
//       }
//       else if (('a' >= seatNumber) || (seatNumber <= (seatsInEachRow + 'd')))  // if the seat name goes out of bound for lower letters
//       {
//           seatNumberIndex = seatNumber - 0x60;
//           seatNumberIndex = seatNumberIndex - 1;
//       }
//       else
//       {
//           cout << "Seat name does not exist";
//           MakeSpace(2);
//           continue;
//       }
//       
//       if (seats[rowNumberIndex][seatNumberIndex] != 'X')
//       {
//           seats[rowNumberIndex][seatNumberIndex] = 'X';
//           cout << "The seat name " << seatName << " is now taken.\n";
//           printLine(10, '_');
//           cout << "Reservation complete";
//           printLine(10, '_');
//           MakeSpace(2);
//           continue;
//       }
//       else if (seats[rowNumberIndex][seatNumberIndex] == 'X')
//       {
//           cout << "The seat named " << seatName << " has already been taken.\n";
//       }
//   }
//    
//    input.close(); // closing the input stream to the file
//    for (int i = 0; i < rowSize; i++)
//    {
//        delete seats[i]; // deleting the values stored in the array
//    }
//
//    delete[] seats; // deleting pointers to all rows
//
//}
//
//
//
//
//int SeatsAvailable(Char_ptr *seats, int rowSize, int numberOfSeatsPerRow)
//{
//    int seatsAvailable = 0;
//    for (int i = 0; i < rowSize; i++) // rows seating
//    {
//        for (int j = 0; j < numberOfSeatsPerRow; j++) // columns seating
//        {
//            // if the value at current index locatin of rows is NOT 'X', then we increments the seats available
//            if (seats[i][j] != 'X')
//            {
//                seatsAvailable++;
//            }
//        }
//    }
//    return seatsAvailable;
//}
//
//
//void PrintSeatingArrangement(Char_ptr *seats, int rowSize, int numberOfSeatsPerRow)
//{
//    for (int i = 0; i < rowSize; i++) // rows seating
//    {
//        for (int j = 0; j < numberOfSeatsPerRow; j++) // columns seating
//        {
//            cout << seats[i][j] << " "; // outputting the seats in this order
//        }
//        cout << "\n";
//    }
//}
//
//
///* CODE OUTPUT
//*
// *Excercise 1
// 
// ------------------------------------------
// 
// Welcome to BlueWing Airways
// ------------------------------------------
// 
// 
// 
// Would you like to enter the information from the keyboard or from another file?
// 1. Keyboard 			2. File
// 1
// How many rows are in the plane?
// 4
// There are 4 rows and 4 seats in each row on this flight
// Today's seating arrangement
// -------------------------
// 
// A B C D
// A B C D
// A B C D
// A B C D
// 
// 
// You have chosen to provide info with keyboard
// Seats available: 16/16
// Enter your desired seat number: 1A
// The seat name 1A is now taken.
// __________
// Reservation complete__________
// 
// 
// 
// X B C D
// A B C D
// A B C D
// A B C D
// 
// 
// You have chosen to provide info with keyboard
// Seats available: 15/16
// Enter your desired seat number: 2C
// The seat name 2C is now taken.
// __________
// Reservation complete__________
// 
// 
// 
// X B C D
// A B X D
// A B C D
// A B C D
// 
// 
// You have chosen to provide info with keyboard
// Seats available: 14/16
// Enter your desired seat number: 2A
// The seat name 2A is now taken.
// __________
// Reservation complete__________
// 
// 
// 
// X B C D
// X B X D
// A B C D
// A B C D
// 
// 
// You have chosen to provide info with keyboard
// Seats available: 13/16
// Enter your desired seat number:
//**/