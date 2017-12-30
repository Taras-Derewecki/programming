/******************************************************************************
Programmer: Taras Derewecki
Date: 10/07/2015
Chapter 5 Section 5
******************************************************************************/
#include <iostream>
#include <string>
using namespace std;

int main() {

	double d=0;
	double sum = 0;
	double number;

	cout << "Enter the number of the amount of integers you would like to add: " << endl;
	cin >> d;

	for (double j = 1;  d >= j; j++)

	{
		cout << "Enter the integers" << endl;
		cin >> number;
		sum += number;
	}

	cout << "Sum: " << sum << endl;
	system("PAUSE");
	return 0;

}