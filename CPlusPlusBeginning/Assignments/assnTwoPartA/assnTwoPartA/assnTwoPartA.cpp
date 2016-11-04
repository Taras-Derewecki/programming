/******************************************************************
SubstrOps program
This program demonstrates find and substr operations

Programmer: Taras Derewecki
******************************************************************/

#include <iostream>
#include <string> //substr type
using namespace std;

int main()
{
	string name = "Olivia Johnson Peterson";
	int index;
	index = name.find(' ');
	cout << "First Name: " << name.substr(0, index) << endl;
	name = name.substr(index + 1, name.length() -1);
	index = name.find(' '); //Note there is a space between the single quotes!
	cout << "Middle Name: " << name.substr(0, index) << endl;
	name = name.substr(index + 1, name.length() - 1);
	cout << "Last Name: " << name << endl;

	system("pause");
	return 0;

}