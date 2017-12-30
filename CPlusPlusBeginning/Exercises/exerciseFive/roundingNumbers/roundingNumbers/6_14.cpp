/************************************************************************************************
Programmer: Taras Derewecki
Date: 11/16/2015
Chapter 6 Section 14: Rounding Numbers
************************************************************************************************/

#include <iostream> 
#include <cmath>

using namespace std;


double in; // input
double integer(double); // prototype
double tenths(double); // prototype
double hundredths(double); // prototype
long double thousands(double); // prototype


int main()
{

	cout << "Type a number with tons of decimal places: " << endl;

	cin >> in;

	cout << endl;

	cout << in << ", round to integer is: " << integer(in) << endl;
	cout << in << ", round to tenths decimal is: " << tenths(in) << endl;
	cout << in << ", round to hundredths decimal: " << hundredths(in) << endl;
	cout << in << ", round to thousands: " << thousands(in) << endl;

	system("PAUSE");
	return 0;
}


double integer(double number)
{
	return floor(number + .5);

}

double tenths(double number)
{
	return floor(number * 10 + .5) / 10;

}



double hundredths(double number)
{
	return floor(number * 100 + .5) / 100;

}


long double thousands(double number)
{
	return floor(number * 1000 + .5) / 1000;

}