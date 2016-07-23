//
//  Lab#5.cpp
//  C++_Central
//
//  Created by Adish Betawar on 3/9/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//

#include <fstream>
#include <iostream>
#include <stdlib.h>
#include <cstdlib>
#include <unistd.h> // for changing the directory of files
#include <string>
using namespace std;

/*
 Excercise 2
 */


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


CounterType::CounterType() // defining default constructor
{
    counter = 0;
}

CounterType::CounterType(int i) // defining default constructor
{
    counter = i;
}

void CounterType::increment() // definning increment function. Purpose of function is to
{
    counter++;
    cout << "\n The value of counter is now: " << counter << "\n\n";
    
}

void CounterType::decrement()
{
    
    if (counter == 0)
    {
        cout << "We cannot decrement further" << endl;
    }
    else
    {
        counter--;
        cout << "\n The value of counter is now: " << counter << "\n\n";
    }
}

int CounterType::get_Counter()
{
    return counter;
}




void CounterType::FileWrite(ofstream &write)
{
    write << "\n" << "The value for counter is now printed to the file. \n The value for counter is: ---------------> " << counter;
}
void ScreenPrint(ostream &out)
{
    out << " ";
}

int main5()
{
    ofstream out;
    int option;
    int value;
    cout << "Enter non-default value for the constructor: ";
    cin >> value;
    CounterType director(value);
    cout << "\n";
    while(option != 5)
    {
        cout << "Choose an option to perform: " << "\n\t1. Access counter" << "\n\t2. Increment Counter" << "\n\t3. Decrement Counter" << "\n\t4. Write to File" << "\n\t5. Exit Program";
        cin >> option;
        if ( option == 1)
        {
            cout << "Value of counter accessed";
            cout << "\nThe intial value for counter is: " << value << "\n\n";
            continue;
        }
        else if(option == 2)
        {
            printf("\nValue Incremented\n");
            director.increment();
            continue;
        }
        else if(option == 3)
        {
            printf("\nValue Decremented\n");
            director.decrement();
            continue;
        }
        else if(option == 4)
        {
            printf("\nValue written to counter.txt\n");
            out.open("//users//adish//desktop//counter.txt", ios::app);
            out << "File updated: \n";
            director.FileWrite(out);
            out.close();
            continue;
        }
    }
    return 0;
}


/*
 
 
 */