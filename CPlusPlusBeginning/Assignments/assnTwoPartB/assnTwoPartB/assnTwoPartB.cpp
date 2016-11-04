/******************************************************************
This program demonstrates cin and cout.

Programmer: Taras Derewecki
******************************************************************/

#include <iostream>
#include <string>

using namespace std;

int main()
{
	int year;
	int month;
	int day;
	cout << "Enter the month, day, and year in integer form." << endl;
	cin >> month >> day >> year;

	cout << month << "/" << day << "/" << year << endl;

	system("pause");
	return 0;

}