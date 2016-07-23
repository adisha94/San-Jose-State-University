//
//  Lab#5.h
//  C++_Central
//
//  Created by Adish Betawar on 3/10/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#ifndef C___Central_Lab_5_h
#define C___Central_Lab_5_h

class CounterType
{
public:
    CounterType(); // default constructor
    CounterType(int i); //non default constructor
    void increment(); // incrementing count value
    void decrement(); // decrementing count value
    int get_Counter(); // getter (accessor function)
    void FileWrite(ofstream &write); // (IO file print function)
private:
    int counter;
};

#endif


