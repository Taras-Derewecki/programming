/*********************************************************************************
Programmer: Taras Derewecki
Date: 11/20/2015
Chapter 7, Section 28: Palindromes
*********************************************************************************/

#include <iostream>
#include <fstream>
#include <cstring>


using namespace std;

int main(void){
	char input[300]; //array
	do{
		bool palindrome = true;

		cout << "Please enter a word: " << endl;
		cin >> input;
		int len = strlen(input);
		int(len / 2);
		if (len>0){
			for (int i = 0; i<(len); i++)
			{
				if (input[i] != input[len - 1 - i])
					palindrome = false;
			}
		}
		if (palindrome == true)
		{
			cout << "This is a palindrome" << endl;
		}
		else
		{
			cout << "This isn't a palindrome" << endl;
		}

	} while (input != "END");

	return 0;

}