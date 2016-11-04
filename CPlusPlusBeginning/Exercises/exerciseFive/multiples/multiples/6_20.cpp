/**********************************************************************************
Programmer: Taras Derewecki
Date: 11/17/2015
Chapter 6, Section 20: Multiples
**********************************************************************************/
#include<iostream>
using namespace std;

bool multiple(int, int); // prototype

int main()
{
	int num_One, num_Two;
	int d; // count control variable
	int num; // input

	cout << "Pairs of numbers: ";
	cin >> num;

	for (d = 0; d < num; d++)
	{
		cout << "enter 1st number: ";
		cin >> num_One;
		cout << "enter 2nd number: ";
		cin >> num_Two;

		if (multiple(num_One, num_Two))
			cout << num_Two << " is a multiple of " << num_One << endl << endl;
		else
			cout << num_Two << " isn't a multiple of " << num_One << endl << endl;
	}
	system("PAUSE");
	return 0;
}
bool multiple(int t, int d)
{
	int q = t;
	while (q <= d)
	{
		if (q == d)
			return true;
		q += t;
	}
	return 0;
}