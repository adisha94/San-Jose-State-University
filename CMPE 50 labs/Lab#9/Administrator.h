//
//  Administrator.h
//  C++_Central
//
//  Created by Adish Betawar on 5/4/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//


// using snake form notation
#ifndef __C___Central__Administrator__
#define __C___Central__Administrator__

#include "salariedemployee.h"

class Administrator: public SalariedEmployee
{
private:
    string title; // main group leader
    string department; // branch in company for responsibility
    string supervisor; // the boss of the leader
public:
    void set_supervisor(string admin_supervisor);
    void read_Admin(); // input function for reading in administrator's data
    void print_Admin(); // output function for printing administrator's data
    void print_Check(); // overloading?
};

#endif /* defined(__C___Central__Administrator__) */
