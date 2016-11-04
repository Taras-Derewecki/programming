/*******************************************************************************
Programmer: Taras Derewecki
Date: 11/02/2015
Chapter 5 Section 8: Smallest Integer
*******************************************************************************/

#include <iostream>

using namespace std;

int main()
{
	int input;//  input
	int small; // output


	cout << "Enter integers (The first value read \n specifies the number of values remaining): ";
	cin >> input;
	cin >> small;

	for (int b; input > 1; input--)
	{
		cin >> b;
		if (b < small)
			small = b;
	}
	cout << "Smallest integer is " << small << endl;


	system("PAUSE");
	return 0;
}
