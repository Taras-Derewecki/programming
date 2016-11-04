/**************************************************************
Programmer: Taras Derewecki
Date: 10/06/2015
Chapter 4 Section 33: Right Sides of a Triangle
**************************************************************/
#include <iostream>

using namespace std;

int main()
{
	int sideA, sideB, sideC; // inputs

	cout << "Enter three numbers: " << endl;
	cin >> sideA >> sideB >> sideC;

	if ((sideA*sideA + sideB*sideB == sideC*sideC)

		|| (sideB*sideB + sideC*sideC == sideA*sideA)

		|| (sideC*sideC + sideA*sideA == sideB*sideB))

		cout << "they are the sides of a right triangle" << endl;
	else
		cout << "they are NOT the sides of a right triangle" << endl;


	system("PAUSE");
	return 0;
}
