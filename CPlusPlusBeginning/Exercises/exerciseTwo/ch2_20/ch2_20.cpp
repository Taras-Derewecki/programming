/****************************************************************************************
Programmer: Taras Derewecki
Date: 09/23/2015

Chapter 2 Section 20
****************************************************************************************/

#include <iostream>
using namespace std;

int main()
{
	double pi = 3.14159;
	int radius;

	cout << "Please enter the radius: ";
	cin >> radius;

	cout << "The diameter is " << 2 * radius << endl;
	cout << "Circumference is " << 2 * pi * radius << endl;
	cout << "The area of circle is " << pi * radius * radius << endl;

	system("pause");
	return 0;
}
