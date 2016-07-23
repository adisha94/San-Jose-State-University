//
//  Administrator.cpp
//  C++_Central
//
//  Created by Adish Betawar on 5/4/15.
//  Copyright (c) 2015 Adish Betawar. All rights reserved.
//


#include "Administrator.h"

void Administrator::set_supervisor(string admin_supervisor)
{
    supervisor = admin_supervisor;
}

void Administrator::read_Admin() // input function for reading in administrator's data
{
    cout << "What is the administrator's name?: ";
    getline(cin, title, '\n'); // getline allows for whitespaces while cin does not
    cout << "What department is " << title << " in charge of?: ";
    cin >> department;
    cout << "Who is " << title << "'s immediate supervisor?";
    cin >> supervisor;
}
void Administrator::print_Admin( ) // output function for printing administrator's data
{
    cout << "Administrator: " << title << endl;
    cout << "Immediate Supervisor: " << supervisor << endl;
    cout << "Department: " << department << endl;
    cout << "Annurl Salary: " << salary << endl;
}
void Administrator::print_Check()
{
    set_net_pay(salary);
    cout << "\n__________________________________________________\n";
    cout << "Pay to the order of " << get_name( ) << endl;
    cout << "The sum of " << get_net_pay( ) << " Dollars\n";
    cout << "_________________________________________________\n";
    cout << "Check Stub NOT NEGOTIABLE \n";
    cout << "Employee Number: " << get_ssn( ) << endl;
    cout << "Salaried Employee. Regular Pay: "
    << salary << endl;
    cout << "_________________________________________________\n";
    
}


