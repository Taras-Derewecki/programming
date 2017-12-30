/****************************************************************************************
Programmer: Taras Derewecki
Date: 09/23/2015

Input Output Question #2
****************************************************************************************/
#include <iostream>
#include <string>
using namespace std;

int main(){

	int numOne;
	string stuffHere;
	double decimalOne;


	cout << "Enter an integer: " << endl;
	cin >> numOne;
	cout << "You entered: " << numOne << endl;


	cout << "Enter a sentence: " << endl;
	cin >> stuffHere;
	cout << "You entered: " << stuffHere << endl;

	cout << "Enter a decimal: "  << endl;
	cin >> decimalOne;
	cout << "You entered: " << decimalOne << endl;


	system ("pause");
	return 0;
	/******************************************************************************************
	When I tried entering "5o1", the compiler truncated anything that had the letter and on,
	and it filled in the sentence value for me with the letter followed by the remaining 
	integer.

	When I tried entering a space between my sentence, it truncated the space and whatever
	I had on, and the compiler put whatever was left into some weird decimal value into my 
	decimal input.

	It truncated the "%" sign, and kept the numeric value.
	******************************************************************************************/
}
