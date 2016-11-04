/********************************************************************************************
Programmer: Taras Derewecki
Date: 09/15/2015

This program reads five integers and determines and prints the largest
and smallest integers in the group.
********************************************************************************************/

#include <iostream>
using namespace std;

int main() {
	int largest, smallest, numOne, numTwo, numThree, numFour, numFive; //input
	cout << "Input 5 integers followed by an enter for each integer entered:" << endl;
	cin >> numOne >> numTwo >> numThree >> numFour >> numFive;
	 
	// numOne == largest, smallest;
	largest = numOne;
	smallest = numOne;

	if (numTwo < smallest){
		smallest = numTwo;
	}
	if (numTwo > largest){
		largest = numTwo;
	}
	if (numThree > largest){
		largest = numThree;
	}
	if (numThree < smallest){
		smallest = numThree;
	}
	if (numFour < smallest){
		smallest = numFour;
	}
	if (numFour > largest){
		largest = numFour;
	}
	if (numFive < smallest){
		smallest = numFive;
	}
	if (numFive > largest){
		largest = numFive;
	}

	cout << "The smallest integer entered was: " << smallest << endl;
	cout << "The largest integer entered was: " << largest << endl;

	system("pause");
	return 0;
}