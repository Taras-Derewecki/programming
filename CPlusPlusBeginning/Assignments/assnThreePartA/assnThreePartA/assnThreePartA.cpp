/**********************************************************************
Programmer: Taras Derewecki

The point of this program is to ask the user for 2 numbers,
obtain the numbers from the user and print the sum, product,
difference, and quotient of the numbers.

Needed:
- Numbers must be integers
- Prompt the user with cout
- Read the input using cin
- Print out the results (cf. output in Exercise 2.19 in text)
- Copy and paste from Assignment 1, part 2, and Assignment 2, part 2;
  then modify appropriately.
**********************************************************************/
#include <iostream>
#include <cmath>
using namespace std;

int main(){
	int numOne, numTwo;

	cout << "Type in two integer-value numbers followed by an enter in between the values: " << endl;
	cin >> numOne;
	cin >> numTwo;
	cout << "You have entered: " << numOne <<", "<< numTwo << endl;
	cout << "The sum of these two numbers are: "<< numOne + numTwo << endl;
	cout << "The product of these two numbers are: " << numOne * numTwo << endl;
	cout << "The difference of these two numbers are: " << numOne - numTwo << endl;
	cout << "The quotient of these two numbers are: " << numOne / numTwo << endl;

	system("pause");
	return 0;
}