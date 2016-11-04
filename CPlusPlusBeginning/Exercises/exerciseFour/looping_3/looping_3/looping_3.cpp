/********************************************************************************
Programmer: Taras Derewecki
Date: 11/02/2015
Looping Problem 3
********************************************************************************/

#include <iostream>

using namespace std;

int main()
{
	int num = 0; // input
	int sum = 0; // output

	cout << "Enter a number from 0-100" << endl;
	cin >> num;

	if (num > 100)
	{
		cout << "please enter a number between 0-100: " << endl;

	}
	else{

		for (int i = 0; i <= num; i++)
		{
			sum = sum + i;
		}
		cout << " The sum of the numbers are " << sum << endl;
	}
	system("PAUSE");
	return 0;



}

