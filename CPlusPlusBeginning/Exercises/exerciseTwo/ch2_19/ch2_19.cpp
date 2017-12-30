/****************************************************************************************
Programmer: Taras Derewecki
Date: 09/23/2015

Chapter 2 Section 19
****************************************************************************************/

#include <iostream>
using namespace std;

int main()
{
	int x, y, z;
	int sum, average, product, smallest, largest;

	cout << "Input three different integers: ";
	cin >> x >> y >> z;

	sum = x + y + z;
	average = (x + y + z) / 3;
	product = x * y * z;

	cout << "Sum is " << sum << endl;
	cout << "Average is " << average << endl;
	cout << "Product is " << product << endl;

	if ((x<y) && (x<z))
		cout << "Smallest is " << x << endl;
	if ((y<x) && (y<z))
		cout << "Smallest is " << y << endl;
	if ((z<x) && (z<y))
		cout << "Smallest is " << z << endl;
	if ((x>y) && (x>z))
		cout << "Largest is " << x << endl;
	if ((x<y) && (z<y))
		cout << "Largest is " << y << endl;
	if ((z>y) && (z>x))
		cout << "Largest is " << z << endl;

	system("pause");
	return 0;
}