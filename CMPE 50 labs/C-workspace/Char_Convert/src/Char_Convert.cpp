//============================================================================
// Name        : Char_Convert.cpp
// Author      : Adish Betawar
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <Stdio.h>
#include <Stdlib.h>
#include <String.h>
#include <iostream>
#include <Math.h>

char Capitalize(char random[])
{
	int diff = 'a' - 'A'; // capitalizing the letter that is in the character array or 'String'
	while(random)
	{
		if (random >= 97 && random <= 122)
		{
			random = random - diff; // we capitalize from lowercase to uppercase letter characters
		}
	}
	return random;
}

int main(void)
{
	char randomString[300];
	printf("Enter your statement: ");
	scanf("%s", &randomString);
	printf("%s", randomString);
	Capitalize(randomString);
}
