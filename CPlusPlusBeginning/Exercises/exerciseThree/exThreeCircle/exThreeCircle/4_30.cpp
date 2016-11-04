/********************************************************************
Programmer:Taras Derewecki
Date: 10/06/2015
Chapter 4 Section 30: Circle
********************************************************************/
#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	double r; // radius input
	double const PI = 3.14159;// constant
	double d; // diameter control
	double c; // circumference control
	double a; // area control

	cout << "Enter radius of circle: ";
	cin >> r;

	d = r * 2;
	c = r * 2 * PI;
	a = r * r * PI;

	cout << setprecision(2) << fixed << "The diameter of circle is " << d << endl
		<< "The circumference of circle is " << c << endl
		<< "The area of circle is " << a << endl;

	system("PAUSE");
	return 0;
}