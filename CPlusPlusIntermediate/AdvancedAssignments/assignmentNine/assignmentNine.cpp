/**********************************************************************************
Programmer: Taras Derewecki
Date: 03/15/2016
Assignment Nine: Hash table for Names
Program Description:

This program creates a hash table for names (first name and last name only, no 
telephone numbers).
**********************************************************************************/
#include <fstream>
#include <iostream>
#include <string>

using namespace std;

struct Entry // structure named Entry
{
	bool denial; // checks if a spot must be denied, resulting in a  denial to the spot
	string firstName; // first name in the list
	struct Entry *nextPtr; // pointer for the next part in the list
};

struct Entry *getEntry(); // function of Entry to a pointer

int main()
{
	struct Entry *personName; // pointer in person's name
	struct Entry *middleMan; // another name for the auxillary pointer
	struct Entry *listOfNames[ 256 ] = { NULL }; // holds 256 characters
	
	unsigned char key = 0; // allows positive values only
	unsigned char key_index = 0; // allows positive values only

	string input; // user input on what file name is
	ifstream fileOfInput; // reads in a file from somewhere 

	cout << "Enter File Name Here: " << endl;
	cin >> input;
	cout << endl;

	fileOfInput.open( input ); 

	while( !fileOfInput.eof() )
	{
		personName = getEntry();

		getline( fileOfInput, personName -> firstName );

		for ( int i = 0; i < personName -> firstName.length(); i++ )
		{
			key ^= personName -> firstName[ i ];
		}

		key_index = key;

		if ( listOfNames[ key_index ] == NULL )
		{
			listOfNames[ key_index ] = personName;
		}

		else
		{
			middleMan = listOfNames[ key_index ];

				while ( middleMan -> nextPtr != NULL )
				{
					middleMan = middleMan -> nextPtr;
				}

			middleMan -> nextPtr = personName;
		}
	}

	fileOfInput.close();

	for ( int i = 0; i < 256; i++ )
	{
		
		if ( listOfNames[ i ] != NULL )
		{
			cout << "Shelf Number " << i << ' ' << "stores the name(s) ";
			middleMan = listOfNames[ i ];

			while ( middleMan != NULL )
			{
				cout << middleMan -> firstName;
				middleMan = middleMan -> nextPtr;               
			}

			cout << endl;
		}

		i++;
	}

	return 0;
}

struct Entry *getEntry()
{
	static int nextEntry = 0;
	static struct Entry array[ 100 ];

	if ( nextEntry > 99 )
	{
		return NULL;
	}

	else
	{
		array[nextEntry].firstName = "";
		array[nextEntry].denial = false;
		array[nextEntry].nextPtr = NULL;
		nextEntry++;
		return &array[ nextEntry - 1 ];
	}

}