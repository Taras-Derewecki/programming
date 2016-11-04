/**************************************************************************
Programmer: Taras Derewecki
Date: 02/08/2015
Assignment Four: Telephone Number Word Generator

This program interprets a 7 digit number, writes every possible 
seven-letter word corresponding to that number. There are 2187 (3^7) 
such words. Avoid phone numbers with digits of 0 and 1.
**************************************************************************/
#include <iostream>
#include <fstream>
#include <cstdlib>
using namespace std;

const int ROWSIZE = 10;
const int COLSIZE = 5;
const int NUMSIZE = 8;

void combine(char *array, char letters[ROWSIZE][COLSIZE], char *build_array, int n, ofstream& output) 
{

/******************************************************************** 
 char* is for user input
 char is for 2D array of letters
 char* is for an array in which to build the output
 int is for index into output array
*********************************************************************/

	if (n == NUMSIZE - 1) {
		output << build_array << endl;
		return;
	}
	else {
		int c = 0;	// counter to move through columns in 2-D array
		int b = array[n] - '0';	// counter to move through rows in 2-D array
		
		while (letters[b][c] != '\0') {
			build_array[n] = letters[b][c++];
			combine(array, letters, build_array, n + 1, output);
		}
	}
}

int main() 
{
	char array[NUMSIZE];	// array
	char buildArr[ROWSIZE] = { 0 };	// array
	int z = 0;	// counter to function
	ofstream os;	// output file

	cout << "Enter a seven digit number: "; 
	cin >> array; 
	cout << endl;

	os.open("combination.txt");

	if (!os.is_open())
		cout << "ERROR 0504: Unable to execute file. ";

	char letter[ROWSIZE][COLSIZE] = {{ '0', '\0', '\0', '\0', '\0' },
									 { '1', '\0', '\0', '\0', '\0' },
									 { 'A', 'B', 'C', '\0', '\0' },
									 { 'D', 'E', 'F', '\0', '\0' },
									 { 'G', 'H', 'I', '\0', '\0' },
									 { 'J', 'K', 'L', '\0', '\0' },
									 { 'M', 'N', 'O', '\0', '\0' },
									 { 'P', 'Q', 'R', 'S', '\0' },
									 { 'T', 'U', 'V', '\0', '\0' },
									 { 'W', 'X', 'Y', 'Z', '\0' }};

	combine(array, letter, buildArr, z, os);

	cout << "\nFilename: combination.txt" << endl;
	os.close();
	return 0;
}