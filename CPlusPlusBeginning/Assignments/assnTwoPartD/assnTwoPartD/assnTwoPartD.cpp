/************************************************************************
Compares two integers and displays their relationship

Programmer: Taras Derewecki
************************************************************************/

#include <iostream>
using namespace std;

int main()
{
	int number1; //user input
	int number2; //user input
	cout << "Enter two integers to compare => ";
	cin >> number1 >> number2;

	if (number1 == number2)
		cout << number1 << " equals " << number2 << endl;
	if (number1 != number2)
		cout << number1 << " does not equal " << number2 << endl;
	if (number1 > number2)
		cout << number1 << " is greater than " << number2 << endl;
	if (number1 < number2)
		cout << number1 << " is less than " << number2 << endl;
	if (number1 >= number2)
		cout << number1 << " is greater than or equal to " << number2 << endl;
	if (number1 <= number2)
		cout << number1 << " is less than or equal to " << number2 << endl;

	system("pause"); //only needed for Windows machines
	return 0;
}