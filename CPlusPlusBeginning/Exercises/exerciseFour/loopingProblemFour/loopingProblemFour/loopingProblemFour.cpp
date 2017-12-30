/********************************************************************************
Programmer: Taras Derewecki
Date: 11/02/2015
Looping Problem 4
********************************************************************************/

#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	double value; // input
	double sum, average, minimum, maximum; // output
	int c; // manip variable

	sum = 0.0;
	c = 0;
	cout << "Enter a value: ";
	cin >> value;
	minimum = value;
	maximum = value;



	do
	{

		sum += value;
		c++;
		if (value > maximum)
			maximum = value;
		else if (value < minimum)
			minimum = value;

		cout << "Enter a value: ";
		cin >> value;

	} while (value != 0);

	average = sum / c;

	cout << "No data entry" << endl;
	cout << "Numbers: " << setprecision(2) << fixed << c << endl;
	cout << "Average: " << setprecision(2) << fixed << average << endl;
	cout << "Minimum: " << setprecision(2) << fixed << minimum << endl;
	cout << "Maximum: " << setprecision(2) << fixed << maximum << endl;






	system("pause");
	return 0;
}
