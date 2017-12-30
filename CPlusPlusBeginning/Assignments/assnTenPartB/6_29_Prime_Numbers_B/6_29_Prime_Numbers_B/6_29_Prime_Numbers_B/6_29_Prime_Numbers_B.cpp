/***************************************************************************
Programmer: Taras Derewecki
Date: 10/29/2015
Chapter 6 Section 29 Part B: Prime Numbers
***************************************************************************/

#include <iostream>
#include <fstream>
#include <cmath>
using namespace std;

bool prime(int); //prototype

int main()
{
	ofstream outputPrime("outputPrime.txt");
	if (!outputPrime){
		cout << "Failed to open outputPrime.txt \n";

		system("PAUSE");
		return 0;

	}

	outputPrime << "2 is prime. " << endl;

	for (int a = 3; a <= 10000; a += 1)
	{
		if (prime(a))
			outputPrime << a << " is prime. " << endl;
	}

	outputPrime.close();
	cout << "The output of the prime numbers is in the file (outputPrime.txt). \n"
		<< "Hold on a minute while we get things started... \n";


	system("PAUSE");
	return 0;
}
bool prime(int a)     
{
	bool pr = false;

	for (int s = 2; s <= sqrt(a); s++)
	{
		if (a % s == 0)
			return pr;
	}
	
	return true;
}
