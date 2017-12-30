/****************************************************************
Programmer: Taras Derewecki
Date: 10/06/2015
Chapter 4 Section 32: Triangle Sides
****************************************************************/
#include <iostream>

using namespace std;

int main()
{
	double sideA, sideB, sideC; // inputs
	cout << "Enter the three numbers: " << endl;
	cin >> sideA >> sideB >> sideC;

	if ((sideA + sideB <= sideC) || (sideB + sideC <= sideA) || (sideA + sideC <= sideB))
		cout << "They could NOT represent the sides of a triangle" << endl;

	else
		cout << "They could represent the sides of a triangle" << endl;


	system("PAUSE");
	return 0;
}