/*************************************************************************
Programmer: Taras Derewecki
Date: 10/06/2015
Chapter 4 Section 16: Salary Calculator
*************************************************************************/

#include <iostream>
#include <iomanip>
#include <cmath>

using namespace std;

int main()
{
	double totalSalary = 0; //output
	double salary; //output
	double hours; //input
	double rate; //input


	cout << "Enter hours worked (-1 to end): ";
	cin >> hours;

	while (hours != -1)
	{

		cout << "Enter hourly rate of the employee ($00.00): ";
		cin >> rate;

		if (hours <= 40)
		{
			salary = hours * rate;
			cout << "Salary is $" << setprecision(2) << fixed << salary << endl;
		}
		else
		{
			totalSalary = (40 * rate) + ((hours - 40)*rate*1.5);
			cout << "Salary is $" << setprecision(2) << fixed << totalSalary << endl;
		}
		cout << "\n Enter hours worked (-1 to end): ";
		cin >> hours;

	}

	system("PAUSE");
	return 0;
}