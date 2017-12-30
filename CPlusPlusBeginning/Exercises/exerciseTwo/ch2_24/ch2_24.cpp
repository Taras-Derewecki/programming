/****************************************************************************************
Programmer: Taras Derewecki
Date: 09/23/2015

Chapter 2 Section 24
****************************************************************************************/

#include <iostream>
using namespace std;

int main()
{
	int x;

	cout << "Enter integer:" << endl;
	cin >> x;

	if (x % 2 == 0)
		cout << "The integer is even." << endl;
	if (x % 2 == 1)
		cout << "The integer is odd." << endl;

	system("pause");
	return 0;
}