/*********************************************************************************************
Programmer: Taras Derewecki
Date: 09/15/2015

This program reads two integers and determines if the first is a multiple of the second.
(Use modulus operator)

Integer m is a multiple of n iff there is an integer c such that m = c * n

If n is a factor of m iff there is an integer of c such that m = c * n

If m is a multiple of n, what is m % n?
*********************************************************************************************/

#include <iostream>
using namespace std;

int main(){
	int numOne, numTwo; // input

	cout << "Enter two integer values followed by an enter after each one: " << endl;
	cin >> numOne >> numTwo;

	if (numOne % numTwo == 0){
		cout << numOne << " is a multiple of " << numTwo << endl;
	}
	else {
		cout << numOne << " is not a multiple of " << numTwo << endl;
	}

	system("pause");
	return 0;
}
