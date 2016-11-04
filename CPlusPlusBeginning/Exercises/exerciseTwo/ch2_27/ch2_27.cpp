/****************************************************************************************
Programmer: Taras Derewecki
Date: 09/23/2015

Chapter 2 Section 27
****************************************************************************************/

#include <iostream>
using namespace std;

int main()
{
	cout<< 'A' << " = " << static_cast <int> ('A') << endl
		<< 'B' << " = " << static_cast <int> ('B') << endl
		<< 'C' << " = " << static_cast <int> ('C') << endl
		<< 'a' << " = " << static_cast <int> ('a') << endl
		<< 'b' << " = " << static_cast <int> ('b') << endl
		<< 'c' << " = " << static_cast <int> ('c') << endl
		<< '0' << " = " << static_cast <int> ('0') << endl
		<< '1' << " = " << static_cast <int> ('1') << endl
		<< '2' << " = " << static_cast <int> ('2') << endl
		<< '$' << " = " << static_cast <int> ('$') << endl
		<< '*' << " = " << static_cast <int> ('*') << endl
		<< '+' << " = " << static_cast <int> ('+') << endl
		<< '/' << " = " << static_cast <int> ('/') << endl
		<< ' ' << " = " << static_cast <int> (' ') << endl;

	system("pause");
	return 0;
}
