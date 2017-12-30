/****************************************************************************************
Programmer: Taras Derewecki
Date: 09/23/2015

Input Output Question #3
****************************************************************************************/

#include <iostream>
#include <string>
#include <iomanip>
using namespace std;

int main(){

	

	cout << resetiosflags(ios::adjustfield);

	cout << left << "ID" << "\t" << "First Name" << "\t" << "Last Name" << "\t" << "Balance" << endl;

	cout << left << '1' << "\t" << "Mary" << "\t\t" << "Worth" << "\t\t" << "100.00" << endl;

	cout << left << '2' << "\t" << "John" << "\t\t" << "Kildare" << "\t\t" << "15.10" << endl;

	cout << left << '3' << "\t" << "Harvey" << "\t\t" << "Jones" << "\t\t" << "65.27" << endl;

	cout << left << '4' << "\t" << "Wilbur" << "\t\t" << "Murphy" << "\t\t" << "1145.43" << endl;

	cout << left << '5' << "\t" << "Sandra" << "\t\t" << "Dee" << "\t\t" << "0.00" << endl;

	cout << left << '6' << "\t" << "Amy" << "\t\t" << "Santucci" << "\t" << "231.55" << endl;

	cout << left << '7' << "\t" << "Melissa" << "\t\t" << "Cox" << "\t\t" << "2.01" << endl;

	cout << left << '8' << "\t" << "Morgan" << "\t\t" << "Freeman" << "\t\t" << "1789.03" << endl;

	cout << left << '9' << "\t" << "Jack" << "\t\t" << "Nicholson" << "\t" << "123.67" << endl;

	cout << left << "10" << "\t" << "John" << "\t\t" << "Brown" << "\t\t" << "426.87" << endl;






	system ("pause");
	return 0;
}