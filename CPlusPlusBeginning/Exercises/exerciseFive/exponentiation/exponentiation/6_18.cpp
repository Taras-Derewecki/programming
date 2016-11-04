/****************************************************************************************************
Programmer: Taras Derewecki
Date: 11/17/2015
Chapter 6 Section 18: Exponentiation
****************************************************************************************************/

#include <iostream>
using namespace std;

int power(int, int);// prototype

int main()
{
	int t, d; // input

	cout << "Base: ";
	cin >> t;
	cout << endl << "Exponent: ";
	cin >> d;
	cout << endl;
	cout << "Result: " << power(t, d) << endl;

	system("PAUSE");
	return 0;
}

//POWER FUNCTION
int power(int t, int d)
{
	int g = 1;
	while (d > 0)
	{
		g *= d;
		d--;
	}
	return g;
}