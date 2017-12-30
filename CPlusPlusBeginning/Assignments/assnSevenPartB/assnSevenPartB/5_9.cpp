/******************************************************************************
Programmer: Taras Derewecki
Date: 10/07/2015
Chapter 5 Section 9
******************************************************************************/
#include <iostream>
using namespace std;

int main() {
	int input; //input
	int product = 1; // output


	cout << "Enter a positive odd integer: " << endl;
	cin >> input;

	while (input % 2 == 0 || input <= 0){
		cout << "Invalid user input, enter a positive odd integer: "
			<< endl;
		cin >> input;

	}

	for (int i = 1; i <= input; i += 2){

		 product *= i;

		// cout << input * i << endl;  debug statement

	}


	cout << "Product: " << product << endl;

	/*******************************************************************************************
	"23" over loads the variable type "int" due to its limited amount of space it can hold.
	*******************************************************************************************/

	system("pause");
	return 0;

}