/*
 * Main.cpp
 *
 *  Created on: Jan 16, 2015
 *      Author: Adish
 */

#include "Main.h"
#include <Stdio.h>
#include <Stdlib.h>
#include <String.h>
#include <iostream>
#include <Math.h>

typedef struct
{
	int age;
	int sid;
	char name[128];
} Student_t;

Student_t me;
int main(void)
{
	printf("Enter you SID: "); scanf("%i", &(me.sid));
	printf("Enter you name: "); scanf("%i", &(me.name[0]));
	printf("Enter you age: "); scanf("%i", &(me.age));
	printf("You entered this: \n\t ID: %i, Name: \n\t%s, \n\t%i", me.sid, me.name, me.age);
	
	
	
	return 0;
}