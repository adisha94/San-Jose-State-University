////
////  Lab#4.cpp
////  C++_Central
////
////  Created by Adish Betawar on 3/29/15.
////  Copyright (c) 2015 Adish Betawar. All rights reserved.
////
////
//
//// solution copied from instructor for educational purposes only
//#include "EaseOfAccesss.h"
//
//int main()
//{
//    // Excercise 1
//    char message[200] = "  noW  iS   thE    TiMe  fOr  aLl\n" \
//    "         gOOD MEN TO  ComE TO   tHe\n" \
//    "  		aId\n" \
//    "oF\n" \
//    "\n" \
//    "\n" \
//    "   ThE  CounTRY.\n";
//
//    char formatted_message[121]; // is this allowed?
//    int length = strlen(message);
//    bool space_Check = false; // checkking for whitespaces in the string
//    bool case_Check = true; // checking for wether the character is capitalized or not
//
//    cout << "Excercise 1\n\n\n";
//
//    for (int i = 0; i < length; i++) // reading through the string for formatting
//    {
//
//    }
//
//}
//
//
//void Exercise4_1()
// {
//	/* For testing only */
//char str[200] = "  noW  iS   thE    TiMe  fOr  aLl\n" \
//"         gOOD MEN TO  ComE TO   tHe\n" \
//"  		aId\n" \
//"oF\n" \
//"\n" \
//"\n" \
//"   ThE  CounTRY.\n";
//char nstr[101];
//
//int length;
//int j = 0;
//
//cout << "***Running Exercise4_1 ... " << endl;
//
//length = strlen(str);
//bool is_firstblank = false; // Used for the compressing consecutive whitespaces
//bool is_initial = true; // Used for removing the leading whitespaces
//
//// Read in all character and change all characters to lowercase and compress
//// consecutive whitespaces to a single blank.
//for (int i = 0; i < length; i++)
//{
//    if (is_whitespace(str[i]))
//    {
//        if (is_initial)
//        {
//            // Skip the leading whitespaces
//            continue;
//        }
//        // compress all consecutive whitespace into one blank
//        if (is_firstblank == false)
//        {
//            nstr[j] = ' ';
//            j++;
//            is_firstblank = true;
//        }
//    } else
//    {
//        if (is_initial)
//        {
//            // We have got the first non-whitespace character
//            is_initial = false;
//        }
//        is_firstblank = false;
//        nstr[j] = tolower(str[i]);
//        j++;
//    }
//}
// cout << "j = " << j << endl;
//nstr[j] = '\0';
//nstr[0] = toupper(nstr[0]);
//
//cout << "Old sentence is " << endl;
//cout << str << endl;
//cout << "New sentence is " << endl;
//cout << nstr << endl;
// }
