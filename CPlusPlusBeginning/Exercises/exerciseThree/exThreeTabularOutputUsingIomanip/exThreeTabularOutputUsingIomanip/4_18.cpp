/***************************************************************
Programmer: Taras Derewecki
Date: 10/06/2015
Chapter 4 Section 18: Tabular Output Using Iomanip
***************************************************************/
#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	int i = 1;

	cout << setiosflags(ios::right) << setw(10) 
		 << "N" << setw(10) << "N*10" << setw(10) 
		 << "N*100" << setw(10) << "N*1000" << endl;

	while (i <= 5)
	{
		cout << setiosflags(ios::right) << setw(10) << i
			 << setw(10) << (i * 10) << setw(10) << (i * 100) << setw(10) 
			 << (i * 1000) << endl;
		i++;
	}

	system("PAUSE");
	return 0;
}