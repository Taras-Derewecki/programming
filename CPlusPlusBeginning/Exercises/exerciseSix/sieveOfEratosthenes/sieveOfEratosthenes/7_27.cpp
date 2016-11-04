/***********************************************************************************
Programmer: Taras Derewecki
Date: 11/23/2015
Chapter 7, Section 27: Sieve of Eratosthenes
***********************************************************************************/
#include <iostream>
#include <fstream>

using namespace std;
int main()
{
	const int maxNumber = 1000000;
	int count = 1; // counter
	bool array[maxNumber];

	for (int i = 0; i < maxNumber; ++i)
		array[i] = true;

	for (int x = 2; x < maxNumber - 1;)
	{
		if (count == 10001)
		{
			cout << x;
			break;
		}
		//mark all multiples
		for (int y = 2; (y*x) < maxNumber - 1; ++y)
		{
			array[x*y] = false;
		}
		//find next prime
		for (int val = x + 1; val < maxNumber - 1; val++)
		{
			if (array[val])
			{
				x = val;
				++count;
				break;
			}
		}
	}
	system("PAUSE");
	return EXIT_SUCCESS;
}