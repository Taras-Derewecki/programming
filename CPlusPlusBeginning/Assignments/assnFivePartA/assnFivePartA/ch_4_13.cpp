/*******************************************************************************************
Programmer: Taras Derewecki
Date: 09/22/2015

This program uses a while loop to input the miles driven and gallons used for trip.

The program should calculate and display the miles per gallon obtained for each trip
and print the combined miles per gallon for all tankfuls up to this point.

Miles driven and gallons used are to be doubles.

*******************************************************************************************/

#include <iostream>
#include <cmath>
using namespace std;

int main(){
	double milesDriven, gallonsUsed, totalMiles, totalGals; //input and loop control variables
	int counter; //loop controlled variable

	
	
	totalGals = 0;
	totalMiles = 0;
	counter = 0;

	cout << "Enter how many miles were driven, or enter 0 to quit \n";
	cout << "Enter miles driven " <<"(" << counter + 1 << ")" <<": " << endl;
		cin >> milesDriven;

		counter++;

		while (milesDriven > 0){


			cout << "Enter how many gallons were used, or enter 0 to quit \n";
			cout << "Enter your gallons used " << "(" << counter + 1 << ")" << ": " << endl;
			cin >> gallonsUsed;
			totalMiles += milesDriven;
			totalGals += gallonsUsed;

			cout << "You have used " << milesDriven / gallonsUsed
				<< " mile(s) per gallon \n";
			cout << "You have used " << totalMiles/ totalGals
				<< " total mile(s) per gallon \n";

			cout << "Enter miles driven" << "(" << counter + 1 << ")" << ": " << endl;
			counter++;
			cin >> milesDriven;

		}

	// system("pause");
	return 0;
}
