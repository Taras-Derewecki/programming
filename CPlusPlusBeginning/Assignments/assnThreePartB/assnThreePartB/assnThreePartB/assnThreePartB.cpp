/************************************************************************
Programmer: Taras Derewecki

The point of this program is to ask the user for two integers,
obtain the numbers from the user, then print the larger number
followed by the words "is larger." If the numbers are equal,
print the message "These numbers are equal."
(Cf. Assignment 2, Part 4)
************************************************************************/

#include <iostream>
using namespace std;

int main(){

	int numOne, numTwo;

	cout << "Enter two integer values followed by an enter in between the two values: " << endl;
	cin >> numOne;
	cin >> numTwo;
	cout << "You entered: " << numOne << ", " << numTwo << endl; 

	if (numOne > numTwo){
		cout << "The larger number is " << numOne << endl;
	}
	else if (numOne < numTwo){
		cout << "The larger number is " << numTwo << endl;
	}
	else if (numOne == numTwo){
		cout << "These numbers are equal" << endl;
	}

	system("pause");
	return 0;
}