/*********************************************************************************
Programmer: Taras Derewecki
Date: 11/17/2015
Chapter 6 Section 30: Reverse Digits
********************************************************************************/

#include <iostream>
using namespace std;


int reverseDigit(int); // prototype


int main()
{
	int num; //input

	cout << "Enter a number to reverse: ";
	cin >> num;

	cout << "The number you entered reversed " << num << " is " << reverseDigit(num) << "." << endl;

	system("PAUSE");
	return 0;
}


int reverseDigit(int num)
{

	int a = 0;//control variable
	int b; //control variable

	while (num > 0)
	{

		b = num%10; //formula
		a *= 10 + b; //formula
		num /= 10; //formula

	}

	return a;

}