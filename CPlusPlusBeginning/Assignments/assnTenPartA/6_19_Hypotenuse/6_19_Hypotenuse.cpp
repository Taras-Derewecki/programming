/*********************************************************************************
Programmer: Taras Derewecki
Date: 10/29/2015
Chapter 6 Section 19: Hypotenuse
*********************************************************************************/

#include <iostream>
#include <iomanip>
#include <cmath>
#include <fstream>

using namespace std;

int main()
{
	double c(double, double); // prototype

	double side_1_1 = 3.0; // description of variable
	double side_1_2 = 4.0; // description of variable
	double side_2_1 = 5.0; // description of variable
	double side_2_2 = 12.0; // description of variable
	double side_3_1 = 8.0; // description of variable
	double side_3_2 = 15.0; // description of variable




	cout << "Hypotenuse of Triangle One: " << fixed << setprecision(2)
		<< c(side_1_1, side_1_2) << "\n";

	cout << "Hypotenuse of Triangle Two: " << fixed << setprecision(2) 
		<< c(side_2_1, side_2_2) << "\n";

	cout << "Hypotenuse of Triangle Three: " << fixed << setprecision(2) 
		<< c(side_3_1, side_3_2) << "\n";



	system("PAUSE");
	return 0;
}



double c(double side_1, double side_2)
{


	double side_3;
	side_3 = sqrt(side_1 * side_1 + side_2 * side_2);

	system("PAUSE");
	return side_3;
}