/****************************************************************************************
Programmer: Taras Derewecki
Date: 09/23/2015

Chapter 2 Section 28
****************************************************************************************/

#include <iostream>
using namespace std;

int main()
{
	int fivedigit;
	int first, second, third, fourth, fifth;

	cout << "Please enter the five digit integer: ";
	cin >> fivedigit;

	if (fivedigit < 10000)
	{
		cout << "Incorrect digit! Try again!";
	}

	if (fivedigit > 99999)
	{
		cout << "Incorrect digit! Try again!";
	}


	first = fivedigit / 10000;
	second = (fivedigit / 1000) % 10;
	third = (fivedigit / 100) % 10;
	fourth = (fivedigit / 10) % 10;
	fifth = fivedigit % 10;

	cout << first;
	cout << " " << second;
	cout << " " << third;
	cout << " " << fourth;
	cout << " " << fifth;

	system ("pause");
	return 0;
}
