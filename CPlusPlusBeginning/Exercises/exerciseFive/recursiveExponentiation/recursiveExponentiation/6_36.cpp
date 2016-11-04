/*****************************************************************************
Programmer: Taras Derewecki
Date: 11/17/2015
Chapter 6 Section 36: Recursive Exponentiation
*****************************************************************************/
#include <iostream>
using namespace std;

int power(int, int); // prototype

int main()
{
	int base, exponent; // input

	cout << "Enter a base: ";
	cin >> base;
	cout << endl;

	cout << endl << "Enter an exponent: ";
	cin >> exponent;
	cout << endl;

	cout << "Result: " << pow(base, exponent) << endl;

	system("PAUSE");
	return 0;
}

int power(int base, int exponent)
{
	while (exponent != 1)
	{
		return base * power(base, (exponent - 1));
	}
	return base;
}