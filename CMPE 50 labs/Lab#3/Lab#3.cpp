//////
//////  Lab#3.cpp
//////  C++_Central
//////
//////  Created by Adish Betawar on 2/16/15.
//////  Copyright (c) 2015 Adish Betawar. All rights reserved.
//////
////
//using namespace std;
//#include "fstream"
//#include "iostream"
//#include <stdlib.h>
//#include <cstdlib>
//#include <unistd.h> // for changing the directory of files
//#include <iomanip>
//
//
//
//
//void SortSmallestoLargest(int a[], int number_used);
//void SortLargestoSmall(int a[], int number_used);
//void swap_values(int &a, int &b);
//int index_of_smallest(const int a[], int start_index, int number_used);
//int index_of_largest(const int a[], int start_index, int number_used);
//
//int main1()
//{
//    ifstream exe1In; // reading from the file
////
//    const int MAX_LINES_FILE = 512;
////    /*
////     * Excercise 1
////        1. Display location of input file
////        2. Open the input file and check error for opening the the file
////        3. Read input file line by line up to the end
////            a.) store in the internal char array
////        4. Close the input file once we reach the end of the file
////        5. Open output file for writing and check error for opening the file
////        6. Iterate through the input char array
////            a.) Write the uppercase char into the output file.
////        7. Close output file
////     */
////    //
////    // 1. Display location of input file
//    cout << "Excercise 1: \n";
//    cout << "The input file used is (LabInput3-1.txt) from the desktop.\n";
// 
//    //
////    // 2. Open the input file and check error for opening the the file
//    exe1In.open("//users//adish//desktop//LabInput3-1.txt");
//    if (exe1In.fail())
//    {
//        cout << "Failed to open input file: //users//adish//desktop//LabInput3-1.txt.\n";
//        cout << "Program terminated";
//        exit(1);
//    }
//
//
////    // 3. Read input file line by line up to the end of file
//    char charArray[MAX_LINES_FILE];
//    int lineCount = 0;
//    while (!exe1In.eof())
//    {
//        exe1In >> charArray[lineCount++]; // reading and storing in charArray variable
//    }
//    //
//    // 4. Close the input file once we reach the end of the file
//    exe1In.close();
//    
//    //
//    // 5. Open output file for writing and check error for opening the file
//    ofstream exe1Out;
//    exe1Out.open("//users//adish//desktop//sample.txt");
//    if (exe1Out.fail())
//    {
//        cout << "Failed to open output file: //users//adish//desktop//sample.txt.\n";
//        cout << "Program terminated";
//        exit(1);
//    }
////    //
////    // 6. Iterate through the input char array
//    
//    for(int i = 0; i < lineCount; i++)
//    {
//
//     // 6a.) Write the uppercase char into the output file.
//        exe1Out << (char)toupper(charArray[i]);  // writing to the output file
//        cout << (char)toupper(charArray[i]);    // displaying output for the user
//    }
//    cout << "\nArray has been outputted to the file (sample.txt)" << "\n";
//    
//
//    // 7. Close output file
//    exe1Out.close();
//    
//    
//    
//    
////    /*
////     * Excercise 2:
////        1. Give option to user for inputting the list of integers
////            a.) OPTION 1: read from keyboard
////            b.) OPTION 2: read from a file
////        2. If the user selects first option (keyboard)
////            a.) Ask user to input the integers manually
////        3. If the user selects second option (file)
////            a.) Prompt the user for the file name
////            b.) Attempt to open the input file and test for failure
////            c.) Read the information from the input file
////            d.) close the input file
////        4. Sort list of integers array
////        5. Iterate through the integer list
////            a.) check if the current integer value is present in the uniqueIntArray (make new array)
////                i) if not present, then add it
////        6. iterate through the uniqueIntArray
////            a.) iterate through the user input integer list
////                i) if numbers are same
////                ii) increment count
////            b.) save counter in repeatCounterArray (makeNewArray)
////     
////     
////        7. Open file stream to output report and test for failure
////            a. make two columns that does the following line by line
////                i) first column shows one occurance of integer (from uniqueIntArray)
////                ii) second column shows repeat count (from repeatCountArray)
////            b. iterate through uniqueIntArray to print report.
////
////     */
////    
//    cout << "\n\nExcercise 2: \n";
//    
//    ifstream exe2In;
//    ofstream exe2Out;
//
//    //
////    /*
////     1. Give option to user for inputting the list of integers
////     a.) OPTION 1: read from keyboard
////     b.) OPTION 2: read from a file
////     */
//    int option;
//    
//    const int numElements = 50;
//    int userIntegerArray[numElements]; // array 1
//    int uniqueIntegerArray[numElements]; // array 2
//    int repeatCounterArray[numElements]; // array 3
//    cout << "Select method of inputting integer lists.\n\n" << "\t\t\t1. Keyboard" << "\t\t\t2. File\n\n";
//    cin >> option;
//    int userIntCount = 0;
//    if (option == 1) // 1a reading information from keyboard
//    {
//        cout << "Reading from keyboard\n";
//        for (int i = 0; i < numElements; i++)
//        {
//            int userInt = 0;
//            cin >> userInt;
//            if (userInt < 0)
//            {
//                break;
//            }
//            userIntegerArray[i] = userInt;
//            userIntCount++;
//        }
//    }
//    
//    else if (option == 2)
//    {
//        cout << "Reading from file\n";
//        chdir("//users//adish//desktop");
//        cout << "Specify file. Please include the ";
//        
//        char filename[20];
//        exe2In.open(filename);
//        if (exe2In.fail())
//        {
//            cout << "Failed to open input file: //users//adish//desktop//" << filename << "\n";
//            cout << "Program terminated";
//            exit(0);
//        }
//        while (!exe2In.eof())
//        {
//            exe2In >> userIntegerArray[userIntCount++]; // reading and storing in charArray variable
//        }
//        //
//        // 4. Close the input file once we reach the end of the file
//        exe2In.close();
//    }
//    else
//    {
//        cout << "Incorrect option chosen, " << option << " \n";
//        cout << "Program terminated";
//        exit(1);
//    }
//    if (userIntCount == 0)
//    {
//        cout << "User integer list is empty" << "\n";
//        cout << "Program terminated";
//        exit(1);
//    }
//    //
//    // 4. Sort list of integer array
//    SortLargestoSmall(userIntegerArray, userIntCount);
//    //
//    // 5. Iterate through the integer list
//            // a.) check if the current integer value is present in the uniqueIntArray (make new array)
//                //i) if not present, then add it
//    int uniqueElementCount = 0;
//    for (int i = 0; i < userIntCount; i++)  // array 1
//    {
//        bool elementFound = false;
//        int userInt = userIntegerArray[i];
//        for (int j = 0; j < uniqueElementCount; j++)
//        {
//            if (uniqueIntegerArray[j] == userInt)
//            {
//                elementFound = true;
//                break;
//            }
//        }
//        if (elementFound == false)
//        {
//            uniqueIntegerArray[uniqueElementCount++] = userInt;
//        }
//    }
//
//    //
//    //        6. iterate through the uniqueIntArray
//    //              a.) iterate through the user input integer list
//    //                  i) if numbers are same
//    //                  ii) increment count
//    //              b.) save counter in repeatCounterArray (makeNewArray)
//    for (int j = 0; j < uniqueElementCount; j++)
//    {
//        int uniqueInt = uniqueIntegerArray[j];
//        int count = 0;
//        for (int i = 0; i < userIntCount; i++)  // array 1
//        {
//            if (uniqueInt == userIntegerArray[i])
//            {
//                count++;
//            }
//        }
//        repeatCounterArray[j] = count;
//    }
//
//    //
//    //  7. Open file stream to output report and test for failure
//    //    a. make two columns that does the following line by line
//    //      i) first column shows one occurance of integer (from uniqueIntArray)
//    //      ii) second column shows repeat count (from repeatCountArray)
//    //   b. iterate through uniqueIntArray to print report.
//    
//    exe2Out.open("//users//adish//desktop//excercise2.txt");
//    if (exe2Out.fail())
//    {
//        cout << "Failed to open output file: //users//adish//desktop//excercise2.txt.\n";
//        cout << "Program terminated";
//        exit(1);
//    }
//    cout << "Output of the formatted report: \n";
//    cout << setw(10) << "N" << setw(13) << "Count\n";
//    
//    for (int j = 0; j < uniqueElementCount; j++)
//    {
//        int uniqueInt = uniqueIntegerArray[j];
//        int repeatCount = repeatCounterArray[j];
//        cout <<  setw(10) << uniqueInt << setw(10) << repeatCount << "\n";
//        exe2Out << uniqueInt << "\t" << repeatCount << "\n";
//    }
//        //
//        // 7. Close output file
//        exe2Out.close();
//
//    /**
//     *
//     * Excercise 3
//     
//     1. Read information from first file and store that information in  array.
//     2. Read information from second file and append that information in same array.
//     3. Sort the array from smallest to largest
//     4. Print report in the required format
//     */
//    
//    cout << "\n\n\n\nExcercise 3: \n";
//    
//    int array1[50];
//    ofstream exe3Out;
//    ifstream exe3In;
//    chdir("//users//adish//desktop");
//    //
//    //  1. Read information from first file and store that information in  array.
//    exe3In.open("//users//adish//desktop//array1.txt");
//    if (exe3In.fail())
//    {
//        cout << "Failed to open output file: //users//adish//desktop//array1.txt.\n";
//        cout << "Program terminated";
//        exit(1);
//    }
//
//    int count = 0;
//    while (!exe3In.eof())
//    {
//        exe3In >> array1[count++]; // reading and storing in charArray variable
//    }
//    
//    exe3In.close();
//    
//    //
//    //        2. Read information from second file and append that information in  same array.
//    exe3In.open("//users//adish//desktop//array2.txt");
//    if (exe3In.fail())
//    {
//        cout << "Failed to open output file: //users//adish//desktop//array2.txt\n";
//        cout << "Program terminated";
//        exit(1);
//    }
//    
//    while (!exe3In.eof())
//    {
//        exe3In >> array1[count++]; // reading and appending in the same array
//        
//    }
//    exe3In.close();
//    
//    //
//    //      3. Sort the array from smallest to largest
//    SortSmallestoLargest(array1, count);
//    //
//    // 4. Print report in the required format
//    cout << "Printing required merged file report\n";
//    exe3Out.open("//users//adish//desktop//MergedArray.txt");
//    if (exe3Out.fail())
//    {
//        cout << "Failed to open output file: //users//adish//desktop//MergedArray.txt.\n";
//        cout << "Program terminated";
//        exit(1);
//    }
//    for (int i = 0; i < count; i++)
//    {
//        if (i == 0)
//        {
//            cout << array1[i];
//            exe3Out << array1[i];
//        }
//        else
//        {
//            cout << setw(i) << array1[i];
//            exe3Out << setw(i) << array1[i];
//        }
//    }
//    cout << "\n";
//    exe3Out << "\n";
//    return 0;
//}
//
//
//
//
//
//void SortSmallestoLargest(int a[], int number_used)
//{
//    int index_of_next_smallest;
//    for (int i = 0; i < number_used - 1; i++)
//    {
//        index_of_next_smallest = index_of_smallest(a, i, number_used);
//        swap_values(a[i], a[index_of_next_smallest]);
//    }
//}
//
////sorts from smallest to largestddd
//void SortLargestoSmall(int a[], int number_used)
//{
//    int index_of_next_largest;
//    for (int i = 0; i < number_used - 1; i++)
//    {
//        index_of_next_largest = index_of_largest(a, i, number_used);
//        swap_values(a[i], a[index_of_next_largest]);
//    }
//}
//
//
//void swap_values(int &a, int &b)
//{
//    int temp;
//    temp = a;
//    a = b;
//    b = temp;
//}
//
//int index_of_smallest(const int a[], int start_index, int number_used)
//{
//    int min = a[start_index], index_of_min = start_index;
//    for (int i = start_index + 1; i < number_used; i++)
//    {
//        if (a[i] < min)
//        {
//            min = a[i];
//            index_of_min = i;
//        }
//    }
//    return index_of_min;
//}
//
//int index_of_largest(const int a[], int start_index, int number_used)
//{
//    int max = a[start_index], index_of_max = start_index;
//    for (int i = start_index + 1; i < number_used; i++)
//    {
//        if (a[i] > max)
//        {
//            max = a[i];
//            index_of_max = i;
//            
//        }
//    }
//    return index_of_max;
//}
////
////
////
////
////
///////*
////// Excercise 1:
////// The input file used is (LabInput3-1.txt) from the desktop.
////// HELLOCMPECLASS 
//////Array has been outputted to the file (sample.txt)
//////
//////
//////Excercise 2:
//////Select method of inputting integer lists.
//////
//////1. Keyboard			2. File
//////
//////1
//////Reading from keyboard
//////23 34 45 5 4 5 4 4 4 3 2 2 1 -1
//////Output of the formatted report:
//////N       Count
//////45         1
//////34         1
//////23         1
//////5         2
//////4         4
//////3         1
//////2         2
//////1         1
//////
//////
//////
//////
//////Excercise 3:
//////Printing required merged file report
//////12 2  3   4    4     5      6       6       45        56
//////Program ended with exit code: 0
//////*/