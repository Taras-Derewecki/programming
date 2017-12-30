/***************************************************************************
Programmer: Taras Derewecki
Date: 01/21/2016
Assignment 2: Greatest Common Divisor

This recursive program determines the greatest common 
divisor of pairs of positive integers. I will prompt
the user for two integers and verify that they are both 
positive integers before proceeding. 
****************************************************************************/

#include <iostream>
#include <iomanip>

using namespace std;

int gcd(int, int); // function prototype with two argurments

int main()
{
	int x, y; //These are for the two integers in which the user will enter
	cout << "Please enter two positive integers: " << endl;
	cin >> x >> y;
	cout << "Greatest Common Divisor: " << gcd (x , y) << endl;


	return 0;
}

int gcd(int x, int y) // Function declared below main
{
	if(x % y == 0)
	{
		return y;
	}
	else
	{
		return gcd(y, x % y); // This is the key play in the recursive function... A Function that calls itself

	}

}