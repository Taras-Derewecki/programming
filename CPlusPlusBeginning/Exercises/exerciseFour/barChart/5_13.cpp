/****************************************************************************
Programmer: Taras Derewecki
Date: 11/02/2015
Chapter 5 Section 13: Bar Chart
****************************************************************************/

#include <iostream>

using namespace std;

int main()
{
	int v, w, x, y, z; // input
	cout << "Enter five integers from 1 - 30: ";
	cin >> v >> w >> x >> y >> z;

	for (int q = 1; q <= v; q++)
	{
		cout << "*";
	}
	cout << endl;

	for (int q = 1; q <= w; q++)
	{
		cout << "*";
	}
	cout << endl;

	for (int q = 1; q <= x; q++)
	{
		cout << "*";
	}
	cout << endl;

	for (int q = 1; q <= y; q++)
	{
		cout << "*";
	}
	cout << endl;

	for (int q = 1; q <= z; q++)
	{
		cout << "*";
	}
	cout << endl;


	system("PAUSE");
	return 0;
}
