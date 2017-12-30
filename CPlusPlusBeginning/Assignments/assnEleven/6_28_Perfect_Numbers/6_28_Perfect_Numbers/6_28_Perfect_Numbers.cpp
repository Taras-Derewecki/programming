/********************************************************************************
Programmer: Taras Derewecki
Date: 11/04/2015
Chapter 6 Section 28: Perfect Numbers

This program prints all perfect numbers and its divisors from 1-1000 on a file
named, "perfect.txt".
********************************************************************************/

#include <iostream>
#include <fstream>

using namespace std;
bool isPerfect(int, ofstream&); // prototype

int main()
{
	ofstream perfNum("perfect.txt");

	for (int number = 1; number <= 1000; number++) // number is a counter control variable
	{
		
		isPerfect(number, perfNum);

	}
	cout << "Open the (perfect.txt) file \n";
	perfNum.close();
	system("PAUSE");
	return 0;
}

bool isPerfect(int number, ofstream& os)
{

	int n = 0; // counter control variable
	//cout << number << endl;
	for (int i = 1; i < number; i++)
	{
		if (number %i == 0)
		{
			n += i;
		}
	}
	//os << n <<' ' << number << endl;
	if (number == n)
	{
	
		os << "\nPerfect #: " << number << "\nDivisors: \n";

		for (int i = 1; i < number; i++)
		{
			if (number % i == 0)
			{
				os << i << ' ' << endl;
			}
		}
		os << endl;

	}

	return true;

}