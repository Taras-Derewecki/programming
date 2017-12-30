/*******************************************************************************
Programmer: Taras Derewecki
Date: 11/03/2015
Looping Number Five
*******************************************************************************/

#include <iostream>
#include <cmath>
using namespace std;

int main()
{

	int dan, tar; // Input
	int sum_of_squares = 0, sum_of_cubes = 0; // Sums of squares and cubes variable initially set to 0
	cout << "Enter initial positive number: \n";
	cin >> dan;

	cout << "Enter a greater ending positive number: \n";
	cin >> tar;

	while (dan <= tar){

		sum_of_squares += pow (dan, 2);
		sum_of_cubes += pow(tar, 3);
		dan++;


	}

	cout << "Sum of Squares: " << sum_of_squares << endl;
	cout << "Sum of Cubes: " << sum_of_cubes << endl;



	system("PAUSE");
	return 0;

}
