/*********************************************************************************
Programmer: Taras Derewecki
Date: 11/02/2015
Chapter 5 Section 29: Peter Minuit
*********************************************************************************/

#include <iostream>
#include <iomanip>
#include <cmath> 

using namespace std;

double amt(double p){

	//double amt; // deposit end of the year
	//double p = 24.0; // amt before interest
	double rate = .05; // Rate of Interest
	int yr =  1;
	

	if (yr = 1){
		return p = 24 * pow(1.0 + rate, yr);

	}

}


int main(){


	//double amt; // deposit end of the year
	double p = 24.0; // amt before interest
	double rate = 0.05; // Rate of Interest


	cout << "Year" << setw(30) << "Amount on Deposit" << endl;


	cout << fixed << setprecision(2);
	for (rate = .05; rate <= 0.1; rate += 0.01)
	{

		for (int yr = 1; yr <= 387; ++yr)
		{

			cout << setw(2) << yr << setw(24) << amt(p) << endl; // check here
			system("PAUSE");
			return 0;
		} 
		cout << endl;
	}

	system("PAUSE");
	return 0;

} 

