/****************************************************************************************************
Programmer: Taras Derewecki
Date: 09/30/2015

Chapter 4 Section 17
****************************************************************************************************/

#include <iostream>
#include <string>
using namespace std;


int main() {
	int largest = 0;// output
	int counter = 0; //loop manipulation variable
	int number = 0;//user input

	cout << "Enter the first integer: " << endl;
	cin >> number;

	counter++;

	while (counter < 10) {
		cout << "Enter another integer: " << endl;
		cin >> number;



		if (number > largest){
			largest = number;
		}

		counter++;

	}
	cout << "The largest integer is: " << largest << endl;

	system("pause");
	return 0;

}