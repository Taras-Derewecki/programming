/************************************************************************************************************
Programmer: Taras Derewecki
Date: 11/12/2015
Chapter 6 Section 16: Dice Rolling

This program rolls two die and locates the number of times a sum occurs
************************************************************************************************************/
#include <iostream>
#include <cstdlib> ///for use of rand and srand
#include <ctime>
#include <iomanip>

using namespace std;

int main(){

	int t, d; // counter control variables
	int sum[11]; //Array




	for (int i = 0; i < 11; i++){
		sum[i] = 0;

		for (int i = 0; i < 36000; i++){
		
			srand(i * time(0)); // formula

			t = 1 + rand() % 6; // die roll
			d = 1 + rand() % 6;// die roll


			sum[t + d - 2]++; // formula
		}
		
		cout << "Sum: 2     3      4      5      6      7      8      9      10     11    12" << endl;// output
		cout << "---------------------------------------------------------------------------\n";// output
		
		for (int i = 0; i < 11; i++) // # of times a sum occurred
		{
			cout << setw(7) << sum[i];
		}

		cout << endl;

		system("PAUSE");
		return 0;
	}
}
