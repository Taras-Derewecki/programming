/*************************************************************************************
Programmer: Taras Derewecki
Date: 11/04/2015
Mortgage Project
*************************************************************************************/

#include <iostream>
#include <cmath>
#include <iomanip>
#include <fstream>

using namespace std;

	int main(){
		ofstream os;
		os.open("results.txt");


		double p; // amt borrowed (principal)
		double r; // interest rate (decimal)
		double i; // interest rate (percent)
		double months; // term of the loan (months)
		double mp; // monthly payment formula
		double mi; // for monthly interest
		double yrs;// term of loan in years
		double a; // counter control variable
		double total = 0.0; // control variable for loop
		double balance; // another variable to describe principal
		

		cout << "Enter Longevity of Loan (in years): ";
		cin >> yrs;

		cout << "Amount Borrowed: $";
		cin >> p;


		cout << "Interest Percentage Rate: ";
		cin >> r;


/*******************************************************************************
								FORMULAS
*******************************************************************************/

		i = (r / 100)/12; // convert percent to decimal
		

		months = yrs * 12; // convert yrs to months

		balance = p;// balance each month

		mp = i * pow((1 + i), months) / (pow((1 + i), months) - 1)  * p;
		// formula for monthly mortgage payment

/*****************************************************************************
								FORMULAS
*****************************************************************************/			

		os << setprecision(2) << fixed
			<< "Your mortgage payment each month:  $" << mp
			<< endl;

		os << setw(3) << "Principal: " << setw(12) << '$' << p << endl;

		os << setw(3) << "Interest Rate: " << setw(12) << r << '%' << endl;

		os << setw(3) << "Years: " << setw(20) << yrs << endl;

		os << setw(3) << "Payment: " << setw(14) << '$' << mp << endl;

		os << endl;

		os << setw(3) << "Months" << setw(12) << "Principal" << setw(12) 
			<< "Interest"<< setw(12) << "Payment\n";

		os << fixed << showpoint << setprecision(2);

		for (a = 0; a <= months; a++){

			mi = i * balance;
			total+= mi;

			os << setw(7) << a << setw(12) << balance << setw(12) << mi
				<< setw(12) << mp << endl;
		
			balance += mi - mp;

		}

		//os << setw(7) << a << setw(12) << "0.00" << setw(12) << "0.00" << "\n";

		

		os << "\n";
		os << "Total Interest: $" << total << "\n";
		os << "Total Cost: $" << (total + p) << "\n";

		cout << "Go to results.txt" << endl;

		os.close();
		system("PAUSE");
		return 0;
	}	