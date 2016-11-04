/***************************************************************************************
Programmer: Taras Derewecki
Date: 10/15/2015
5.23 & 5.24: Stars
***************************************************************************************/
#include <iostream>
using namespace std;


int main()
{
	int i, j, k; // Manipulation variables
	int input; // User input
	cout << "Max Stars(1-19): ";
	cin >> input;

	for (j = 1; j <= input; j += 2){
	
		for (i = 1; i <= (input - j) / 2; i++)
			cout << " ";
		for (k = 1; k <= j; k++)
			cout << "*";
		cout << "\n";
	}


	for (j = input - 1; j >= 2; j -= 2){
	
		for (i = 1; i <= (input - j + 1) / 2; i++)
			cout << " ";
		for (k = 1; k < j; k++)
			cout << "*";;
		cout << "\n";
	}



	system("pause");
	return 0;

}
