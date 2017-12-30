/*******************************************************************************
Programmer: Taras Derewecki
Date: 10/29/2015
Chapter 6 Section 29: Prime Numbers
*******************************************************************************/

#include <iostream>
#include <cmath>
#include <fstream>

using namespace std;

int pr(int); // prototype


int main()
{

	int g;

	cout << "Enter integer: ";
	cin >> g;
	pr(g);

		system("PAUSE");
	return pr(g);

	
}

int pr(int g)
{
	int pr = 0;
	for (int f = 2; f < g; f++)
	{
		if (g % f == 0)
			pr++;

	}
	if (pr > 0)
		cout << "Integer Not Prime \n";
	else
		cout << "Prime Integer \n";

	system("PAUSE");
	return 0;
}