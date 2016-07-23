//
//  main.cpp
//  Final_Practice
//
//  Created by Adish Betawar on 5/11/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include "EaseOfAccesss.h"
#include "GenericList.h"

int something (int a, int b) throw(int);


int main()
{
    
    int value1;
    int value2;
    int value3;
    int value4;
    int value5;
    cout << "Enter some values\n";
    cin >> value1;
    cin >> value2;
<<<<<<< HEAD
    cin >> value3;
    cin >> value4;
    cin >> value5;
//    Swap(value1, value2);
//    Display("This is an awesome poo. This poo is abssolutely amaazing.\n");
//    Display("this is a test\n");
//    Display("Would you like to eat this poo?\n");
//    GenericList<int> list(5);
//    list.add(4);
//    list.add(25);
//    list.add(34);
//    list.add(3);
//    
//    list.Top();
//    cout << list.CurrentValue();
//    list.MoveNext();
//    cout << list.CurrentValue();
//    list.MoveBack();
//    cout << list.CurrentValue();
//    cout << list.length();
//    cout << list.ReturnItemAt(1);
//    
//    cout << list;
//    
//    for (list.Top(); list.CheckIfBottom() == false; list.MoveNext())
//    {
//        cout << list.CurrentItem() << " ";
//    }
    
    
    
=======
    Swap(value1, value2);
    Display('A');
    Display(.22);
    Display(33);
    Display(value1);
    Display(value2);
    Display("this is a test\n");

   GenericList<int> list(5);
   list.add(4);
    list.add(25);
    list.add(34);
    list.add(3);
    
    list.Top();
    cout << list.CurrentValue();
    list.MoveNext();
   cout << list.CurrentValue();
    list.MoveBack();
    cout << list.CurrentValue();
   cout << list.length();
  cout << list.ReturnItemAt(1);

   cout << list;

   for (list.Top(); list.CheckIfBottom() == false; list.MoveNext())
    {
      cout << list.CurrentItem() << " ";
   }
>>>>>>> origin/master
    vector<int> vec; // created a vector dynamically allocated array
    vector<string> vec2; // created a vector of string for this dynamic array
    
    
    
    vec.push_back(value1);
    vec.push_back(value2);

    vec.push_back(value4);
//    vec.push_back(value3);
    vec.push_back(value5);
    cout << "Current size of vector is: " << vec.size() << endl;
    for (int i = 0; i < vec.size(); i++)
    {cout << vec[i] << " ";}

    
    cout << "Current size of vector is: " << vec.size() << endl; // after /shrinking
    for (int i = 0; i < vec.size(); i++)
    {
        cout << vec[i] << " ";
    }
    cout << endl;

    int cnt = distance(vec.begin(), vec.end());
    
    cout << "Vector count: " << cnt << endl;
    
    vec.pop_back();
    cout << "Current size of vector is: " << vec.size() << endl;
    for (int i = 0; i < vec.size(); i++)
    {
        cout << vec[i] << " ";
    }

    return 0;
}

int something (int a, int b) throw(int)
{
    // insert something
    if(true)
        throw 1;
    
    return 2;
}