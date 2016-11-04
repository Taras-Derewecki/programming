/***************************************************************************
Programmer: Taras Derewecki
Date: 11/20/2015
Chapter 7 Section 13: Duplicate Elimination
**************************************************************************/

#include <iostream>
#include <iomanip>
using namespace std;

int main()
{

	int i; // counter control variable
	int blah = 0; // set variable
	int in; // input
	int myArray[20]; // array

	for (int c = 1; c <= 20; c++)
	{

		cout << "Enter a number between 10-100: " << endl;
		cin >> in;


		if (in < 10 || in > 100)
		{
			cout << setw(5) << "Not in valid range. ";
			continue;
		}

		for (i = 0; i < blah; i++)

		{
			if (myArray[i] == in)
			{
				break;
			}
		}

		if (i == blah)
		{
			myArray[blah] = in;
			blah++;
		}

		else
		{
			cout << "Error Code 100: Repeated Number";
		}

	}

	cout << "Unique numbers in the arrays are: ";

	for (i = 0; i < blah; i++)
	{
		cout << setw(5) << myArray[i];
	}

	cout << endl;
	system("PAUSE");
	return 0;
}