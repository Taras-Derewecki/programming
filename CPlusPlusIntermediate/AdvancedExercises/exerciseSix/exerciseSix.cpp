/************************************************************************
Programmer: Taras Derewecki
Date: 04/30/2016
Exercise Six: 
Program Description:
	Write a program that generates random words from a training set as 
	explained in the lectures on graphs. Do not hard-code the training 
	set! Read it from a file.
************************************************************************/

#include <iostream> 
#include <fstream> 
#include <string> 
#include <cstdlib> 
#include <ctime> 
#include <cstring> 

using namespace std;

const int SIZE = 27; //variable for 26 chars + 1
const int WORDSIZE = 25; // max word size allowed

/************************************************************************************
									FUNCTIONS
************************************************************************************/

int data( string tArray[], int s, char m, char d )
{
	int c = 0; // counter

	for (int i = 0; i < s; i++)
	{
		int j = 0;
		while ( tArray[i][j] != '\0' )
		{
			if ( tArray[i][j] == m && tArray[i][j + 1] == d )
				c++;
				j++;
		}
	}
	return c;
}


int evalChar( string tArray[], int s, char m )
{
	int c = 0;

	for ( int i = 0; i < s; i++ )
	{
		int d = tArray[i].length();
		if ( tArray[i][d - 1] == m ) c++;
	}

	return c;
}


int buildChar(string tArray[], int s, char m) //builds first character row
{
	int c = 0;

	for (int i = 0; i < s; i++)
	{
		if (tArray[i][0] == m) c++;			
	}

	return c;
}


int getRandom(int s) //gets the random
{

	int random = ( rand() % s ) + 1;
	return random;
}


char getChar(char cArray[], int i) { return cArray[i]; }

/************************************************************************************
									FUNCTIONS
************************************************************************************/

int main()
{

	char cArray[SIZE]; // char for array of characters in set
	string tArray[SIZE]; //string of training array
	int firstChars[SIZE]; //variable for array of first character multiplicities
	int transArray[SIZE][SIZE]; //variable for transition array of multiplicities
	char word[WORDSIZE]; //char for word being built

	string input; // user-specified file
	int x , y;

	cout << "Input File: "; cin >> input;

	ifstream infile( input.c_str(), ios :: in );
	infile >> x;

	for (int i = 0; i < x; i++) infile >> cArray[i];

	cArray[x] = '\0';
	cout << cArray[x];

	infile >> y;

	for (int i = 0; i < y; i++) infile >> tArray[i];
		
	srand(time(0));

	for (int i = 0; i < x; i++) // builds matrix
	{
		for (int j = 0; j < x + 1; j++)
		{
			if (j == x) transArray[i][j] = evalChar(tArray, y, cArray[i]);
		
			else transArray[i][j] = data(tArray, y, cArray[i], cArray[j]);	
		}
	}

	for (int i = 0; i < x; i++)
	{
		firstChars[i] = buildChar(tArray, y, cArray[i]);
	}
	
	int iterate; // how many times it iterates

	cout << "# of Iterations? ";
	cin >> iterate;

	string inputTwo;

	cout << "Output File: ";
	cin >> inputTwo;

	ofstream outfile( inputTwo.c_str(), ios :: out );

	for (int i = 0; i < iterate; i++)
	{
		int numbers = 0, end, first;
		while (numbers < 25)
		{
			first = getRandom(y);

			if (numbers == 0)
			{
				int j = 0, total = 0;

				while (total < first)
				{
					j = j % x;
					total += firstChars[j];
					j++;
				}

				j--;
				word[numbers++] = getChar(cArray, j);
				end = j;
			}

			else
			{
				int j = 0, total = 0;

				while (total < first)
				{
					j = j % (x + 1);
					total += transArray[end][j];
					j++;
				}

				j--;
				word[numbers++] = getChar(cArray, j);
				end = j;
			}
		
			if (end == x) break;	
		}
	
		outfile << word << endl;
	}

	cout << endl;
	return 0;
}
