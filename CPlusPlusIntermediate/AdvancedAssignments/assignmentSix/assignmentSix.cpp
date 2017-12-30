/*********************************************************************************
Programmer: Taras Derewecki
Date: 02/16/2016
Assignment Six: Machine Integer Representation

This program will allows the user to enter an unsigned integer 
(the maximum value of an unsigned 4-byte int is 232 = 4,294,967,296) and reverses
its format (from little to big endian, or vice versa). Print out the user-entered
number in hexadecimal and binary, reverse the endianness, and print the reverse 
in hexadecimal and binary.

For this exercise you may NOT use the C++ hex formatting capability of the 
extraction operator (<<). Write your own routines to print a number in 
hexadecimal and binary using bit operators: <<, >>, &, |, and/or ~.

It is recommended that you use the following constants, a union to represent 


You will find that it is very important that you use unsigned chars. 
In most machine architectures, negative integers are represented in 2s 
complement format with the most significant bit a 1. To convert a binary (byte) 
1, or 00000001, to negative -1 in binary, use the following procedure: 1) find 
the 1s complement; that is, flip all the 1s and 0s: 11111110; 2) add 1 to the 
result: 11111110 + 00000001 = 11111111, or 0xFF. Hence a 0xFF as an unsigned 
char is 255 (decimal), and 0xFF as a (signed) char is -1 (decimal).

Here is a sample run: 
Enter an unsigned integer in base 10 => 23456789 

In hex: 
15 EC 65 01

In binary: 
00010101 11101100 01100101 00000001 

Reverse endian: 
In hex: 01 65 EC 15

In binary: 
00000001 01100101 11101100 00010101
*********************************************************************************/

#include <iostream>

using namespace std;

const int INTSIZE = 4; // in bytes 
const int BYTESIZE = 8; // in bits
const int NIBSIZE = 4; // nibble, in bits

union integer4 
{    
	unsigned int intrep;
	unsigned char byterep[INTSIZE];
}; 

void prHex( unsigned char ); // prototype
void prBin( unsigned char ); // prototype

int main()
{

	integer4 input; // integer that allows for more positive integers
	cout << "Enter an unsigned integer in base 10: "; cin >> input.intrep;
	cout << endl;

	/*************************************************************************
		Controls Hexadecimal Formatting... DO NOT TOUCH
	*************************************************************************/
	cout << "Hexadecimal Form: ";
	for ( int i = 0; i < 4; i++ )
	{
    	prHex( input.byterep[i] );
	}
	cout << endl;
	/*************************************************************************
		Controls Hexadecmial Formatting... DO NOT TOUCH
	*************************************************************************/

	
	/*************************************************************************
		Controls Binary Formatting... DO NOT TOUCH
	*************************************************************************/
	cout << "Binary Form: ";
	for ( int i = 0; i < 4; i++ )
	{
    	prBin( input.byterep[i] );
	}	
	cout << endl << endl;
	/*************************************************************************
		Controls Binary Formatting... DO NOT TOUCH
	*************************************************************************/


	/************************************************************************
		Reverse Endian Formatting... DO NOT TOUCH
	************************************************************************/
	cout << "Reverse Endian Form: " << endl << "Binary Form: ";
	for (int i = 3; i > -1; --i)
	{
		prBin( input.byterep[i] );
	}
	cout << endl << "Hexadecimal Form: ";

	for (int i = 3; i > -1; --i)
	{
		prHex( input.byterep[i] );
	}
	cout << endl;

	/************************************************************************
		Reverse Endian Formatting... DO NOT TOUCH
	************************************************************************/
	
	//prBin( input ); //prBin( mask ); prBin( input & mask );
	//cout << "Reverse Endian Form: " << swap(input);
	//cout << "Binary Form: " << &input >> 4;


	return 0;
}

void prHex( unsigned char input )
{
	char hex[ 16 ] = { '0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F' };
	char digOne = hex[ input / 16 ];
	char digTwo = hex[ input % 16 ];
	cout << digOne << digTwo << ' ';

	return;
}

void prBin( unsigned char input )
{
	unsigned int mask = 128;
	while( mask >= 1 )
	{
		if ( ( input & mask ) == 0 ) { cout << '0'; }
		else { cout << '1'; }
		mask >>= 1;
	}

	cout << ' ';

	return;
}