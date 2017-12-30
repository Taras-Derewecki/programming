/**********************************************************************
Programmer: Taras Derewecki
Date: 10/06/2015
Chapter 4 Section 27: Decimal Equivalent of Binary
**********************************************************************/
#include <iostream>

using namespace std;

int main()
{
	int binary; //input
	int decimal = 0; //formula and control variable
	int control = 1; // control variable

	cout << "Enter number in binary format: ";
	cin >> binary;

	while (binary >= 1)
	{
		decimal = decimal + (binary % 10)*control;
		binary /= 10;
		control *= 2;

		cout << "Decimal: " << decimal << " Binary: " << binary << " Control: " << control << endl;
	}

	cout << "Decimal: " << decimal << endl;


	system("PAUSE");
	return 0;
}