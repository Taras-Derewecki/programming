/*****************************************************************************
Programmer: Taras Derewecki
Date: 04/05/2016
Assignment Eleven: Matrices Operations
Program Description:
	This program reads two matrices and: 1) adds them (if compatible) and 
	prints their sum, 2) subtracts them (if compatible) and prints their 
	difference, and 3) multiplies them (if compatible) and prints their 
	product.
*****************************************************************************/

#include <iostream>
#include <string>
#include <iomanip>
#include <fstream>

using namespace std;

int main()
{
	ifstream in; // reads in input from a file
	ofstream out; // outputs final result to a new file
	string matrixNameOne, matrixNameTwo; // matrices the user will enter
	double a[ 10 ][ 10 ], b[ 10 ][ 10 ], multiply[ 10 ][ 10 ], add[ 10 ][ 10 ], subtract[ 10 ][ 10 ]; // matrices dimensions of max 10 x 10
	double rowOne, columnOne, rowTwo, columnTwo; //variables for 2 rows, 2 columns, and
	int i, j, k; // variables for 3 counters

	// Stores elements of first matrix
	cout << "Enter the name of the first matrix input file: ";
	cin >> matrixNameOne;

	in.open( matrixNameOne );
	out.open( "matrices.txt" );

	in >> rowOne >> columnOne; // reads in user input for columns and row one
	
	out << "A Matrix: " << endl;
	for ( i = 0; i < rowOne; ++i )
		for ( j = 0; j < columnOne; ++j )
		{
			in >> a[ i ][ j ];
			out << setw(5) << setfill(' ') << a[ i ][ j ];

			if ( j == columnOne - 1 )
				out << endl;
		}

	in.close(); // closes input file

	// Stores elements of second matrix
	cout << "Enter the name of the second matrix input file: ";
	cin >> matrixNameTwo;
	in.open( matrixNameTwo );

	in >> rowTwo >> columnTwo; // reads in user column and row two

	out << "B Matrix: " << endl;

	for ( i = 0; i < rowTwo; ++i )

		for ( j = 0; j < columnTwo; ++j )
		{
			in >> b[ i ][ j ];
			out << setw(5) << setfill(' ') << b[ i ][ j ];
			if ( j == columnTwo - 1 )
				out << endl;
		}

	in.close();

	// Initialize elements of matrix multiplied to 0
	for ( i = 0; i < rowOne; ++i )
		for ( j = 0; j < columnTwo; ++j )
		{
			multiply[ i ][ j ] = 0;
			add[ i ][ j ] = 0;
			subtract[ i ][ j ] = 0;
		}

	// Multiplies matrix A and B and stores it in to array "multiply"
	for ( i = 0; i < rowOne; ++i )
		for ( j = 0; j < columnTwo; ++j )
			for ( k = 0; k < columnOne; ++k )
			{
				multiply[ i ][ j ] += a[ i ][ k ] * b[ k ][ j ];
			}
	if ( rowOne == rowTwo && columnOne == columnTwo ) 
	{
		for ( i = 0; i < rowOne; ++i )
			for ( j = 0; j < columnTwo; ++j )
			{
				add[ i ][ j ] += a[ i ][ j ] + b[ i ][ j ];
			}

		for ( i = 0; i < rowOne; ++i )
			for ( j = 0; j < columnTwo; ++j )
				{
					subtract[ i ][ j ] += a[ i ][ j ] - b[ i ][ j ];
				}


		out << endl << "A Matrix + B Matrix = " << endl;

		for ( i = 0; i < rowOne; ++i )
			for ( j = 0; j < columnTwo; ++j )
			{
				out << setw(5) << setfill(' ') << add[ i ][ j ];
				if ( j == columnTwo - 1 )
					out << endl;
			}

		out << endl << "A Matrix - B Matrix is " << endl;
		for ( i = 0; i < rowOne; ++i )
			for ( j = 0; j < columnTwo; ++j )
			{
				out << setw(5) << setfill(' ') << subtract[ i ][ j ];
				if ( j == columnTwo - 1 )
					out << endl;
			}
	}

	else 
	{
		cout << "\nMatrices are not square... Can't be added or subtracted!\n\n";
		return 1;
	}

	// If the column of first matrix in not equal to the row of the second matrix, ask user to enter the size of matrix again
	if ( columnOne != rowTwo )
	{
		cout << "\nError 0504: column of first matrix not equal to row of second! \n";
		return 1;
	}

	// Displays the multiplication of the two matrices
	out << endl << "A Matrix * B Matrix is " << endl;
	for ( i = 0; i < rowOne; ++i )
		for ( j = 0; j < columnTwo; ++j )
		{
			out << setw(5) << setfill(' ') << multiply[ i ][ j ];
			if ( j == columnTwo - 1 )
				out << endl;
		}

	cout << "\nFilename: matrices.txt. \n" << endl;
	return 0;
}