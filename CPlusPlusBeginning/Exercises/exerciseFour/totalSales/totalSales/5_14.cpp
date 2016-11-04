/*******************************************************************************
Programmer: Taras Derewecki
Date: 11/02/2015
Chapter 5 Section 14: Total Sales
*******************************************************************************/

#include <iostream>
using namespace std;

int main()
{
	int num, qty = 0; // Set Initial Values

	int qty1 = 0, qty2 = 0, qty3 = 0, qty4 = 0, qty5 = 0; // Set Initial Values

	double amt1 = 0.0, amt2 = 0.0, amt3 = 0.0, amt4 = 0.0, amt5 = 0.0;
	// Set Initial Values

	for (num = 0; num != -1;)
	{

		cout << "Enter the product number and quantity sold (-1 ends the program): ";
		cin >> num;
		cin >> qty;

		switch (num)
		{

		case 1:
			qty1 += qty;
			amt1 += qty * 2.98;
			break;

		case 2:
			qty2 += qty;
			amt2 += qty * 4.50;
			break;

		case 3:
			qty3 += qty;
			amt3 += qty * 9.98;
			break;

		case 4:
			qty4 += qty;
			amt4 += qty * 4.49;
			break;

		case 5:
			qty5 += qty;
			amt1 += qty * 6.87;
			break;

		default:
			cout << "Wrong product number, enter the correct product number" << endl;
			break;
		}

	}

	cout << "Product number of how many were sold: " 
		<< qty1 + qty2 + qty3 + qty4 + qty5 << endl;

	cout << "How many were sold of the product: " 
		<< amt1 + amt2 + amt3 + amt4 + amt5 << endl;

	system("PAUSE");
	return 0;
}