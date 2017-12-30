/*******************************************************************************
Programmer: Taras Derewecki
Date: 11/02/2015
Chapter 5 Section 10: Factorials
*******************************************************************************/

#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	int res = 1; // set control variable 

	for (int j = 1; j <= 5; j++){
		res *= j;
		cout << "Factorial of" << setw(5) << j << setw(5) << "is"
			<< setw(5) << res << endl;
	}



	system("PAUSE");
	return 0;

	// It is beyond the range of the variable type.
}