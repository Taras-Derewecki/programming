/*********************************************************************************
Programmer: Taras Derewecki
Assignment Three
Date: 01/28/2015

The purpose of this program is read in integers and outputs their hex, oct, and 
character equivalent. 
**********************************************************************************/
#include <iostream>
#include <iomanip>
#include <fstream>
using namespace std;

int main()
{

	ofstream output; // used to output to a file
	output.open( "file.txt" ); // opens output file

			cout << setw(15) <<"Octal:" << setw(20) <<		//sets the width in between all titles
			  "Decimal:" << setw(20) << "Hexadecimal: " << 
			 	setw(25) << "ASC II Character: ";

			 output << setw(15) <<"Octal:" << setw(20) <<
			  "Decimal:" << setw(20) << "Hexadecimal: " << 
			 	setw(25) << "ASC II Character: ";

	for (int i = 33; i <= 126; i++)		//for loop to print out numbers 33 to 126 in
	{									// octal, decimal, hexadecimal, and character format


		cout << endl << setw(10) << oct << '0' <<i <<	// octal value
			  	setfill(' ')<< setw(20)<< dec << i <<							// decimal value
			 	setw(20)<< "0x" << hex << i << 					// hexadecimal value
			 	setw(20) << static_cast<char>(i);				// character Value	

		output << endl << setw(10) << oct <<'0'<< i <<		// octal value for file
			  	setw(20)<< dec << i <<					// decimal value for file
			 	setw(20)<< "0x" << hex << i << 			// hexadecimal value for file
			 	setw(20)<< static_cast<char>(i);		// character value for file				// character value
	}

	cout << endl << endl;
	cout << "File Name: file.txt " << endl;

	output << endl << endl;
	output << "File Name: file.txt " << endl;


	output.close(); // close file
	return 0;
}