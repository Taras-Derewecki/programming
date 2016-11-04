/*******************************************************************************
Programmer: Taras Derewecki
Date: 02/26/2016
Assignment 7: Palindromes

Program Description:

The program utilizes a stacks to determine if a program is a palindrome or not.
*******************************************************************************/

#include <iostream>

using namespace std;

char ch_array[25];
char *skptr;

void pushFx( char character )
{
	*skptr = character;
	skptr++;
}

char popFx()
{
	skptr--;
	return *skptr;
}

int main(){
	skptr = &ch_array[0];  //set pointer to first array point 
	char input[25];
	char inputTwo[25];
	char conversion;
	int counter = 0;
	int counter_global = 0;
	cout << "Enter a word to be palindromed: "; cin.getline(input, 25);
	int i = 0;
	while ( input[i] != '\0' )
	{
		i++;
		counter++;
	}

	for ( int j = 0; j < counter; ++j )
	{
		if ( input[j] >= 65 && input[j] <= 90 ) // for upper case
		{
			pushFx( input[j] );
			inputTwo[counter_global] = input[j];
			counter_global++;
		}
		if ( input[j] >= 97 && input[j] <= 122 ) // for lower case
		{
			conversion= input[j] - 32;// change from lower to upper case
			pushFx( conversion );
			inputTwo[ counter_global ] = conversion;
			counter_global++;
		}
	}

	for ( int j = 0; j < counter_global; ++j )
		{
			if ( inputTwo[j] == popFx() )
			{

			}

			else
			{
				cout << "This isn't a palindrome" << '\n';
				system("PAUSE");
				return 0;
			}
		}
	cout << "This is a palindrome!! :)" << endl;
	return 0;
}