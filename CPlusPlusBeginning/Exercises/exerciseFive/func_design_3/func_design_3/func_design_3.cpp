/**************************************************************************
Programmer:Taras Derewecki
Date: 11/16/2015
Function Design Problem 3: Slope-Intercept

This program finds the slope-intercept form of any 2 pairs of numbers,
or one pair of numbers and a slope.
**************************************************************************/

#include <iostream>
#include <cmath> 

using namespace std;

int main(){

	double slope, intercept; // formula
	double x1, y1, x2, y2; // input
	double delta_x, delta_y, b; // formulas
	int input; // for utilizing the if statements

	cout << "Enter '1' Two sets of points only \n";
	cout << "Enter '2' One set of points & a slope \n";

	cin >> input;

	if (input == 1){

		cout << "Enter X1: ";
		cin >> x1;

		cout << "Enter Y1: ";
		cin >> y1;

		cout << "Enter X2: ";
		cin >> x2;

		cout << "Enter Y2: ";
		cin >> y2;

		delta_x = x2 - x1;
		delta_y = y2 - y1;

		slope = delta_y / delta_x; // (y2-y1)/(x2-x1)

		intercept = y1 - slope * x1; // y2 - slope * x2

		cout << "Equation of the line with end points: (" << x1 << ", " << y1 
			<< ") and (" << x2 << ", " << y2 << ") : Y = ";
		cout << slope << "X " << ((intercept < 0) ? ' ' : '+') 
			<< intercept << "\n";

		system("PAUSE");
		return 0;
	}

	if (input == 2){

		cout << "Enter X1: ";
		cin >> x1;
		cout << "Enter Y1: ";
		cin >> y1;

		cout << "Slope: ";
		cin >> slope;


		b = (slope*-(x1) +y1);


		cout << "slope-intercept form: " << "Y = " << slope << 'X' 
			<< " + " << b << endl;

		system("pause");
		return 0;
	}


	else
		cout << "ERROR: Invalid user input! \n";
}