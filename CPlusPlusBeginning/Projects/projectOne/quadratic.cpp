/*********************************************************************************
Programmer: Taras Derewecki
Date: 10/13/2015
Project One: Quadratic
*********************************************************************************/
#include <iostream>
#include <cmath>
#include <iomanip>
using namespace std;


int main(){

	double a, b, c; // inputs
	double e1, e2; // equation variables 
	double norm, i; //a chunk of a quadratic equation for imaginary results
	double d; // chunk of the quadratic equation for convenience sake
	

	cout << "A Value: ";
	cin >> a;
	cout << endl;

	cout << "B Value: ";
	cin >> b;
	cout << endl;

	cout << "C Value: ";
	cin >> c;
	cout << endl;

	while (a == 0.0){
		cout << "Error: The input you have entered is not a quadratic. Try again: \n\n";
		
		cout << "A Value: ";
		cin >> a;
		cout << endl;

		cout << "B Value: ";
		cin >> b;
		cout << endl;

		cout << "C Value: ";
		cin >> c;
		cout << endl;
	}


	d = (pow (b,2)) - (4.0 * a*c);


	if (d > 0.0){
		e1 = (-b + sqrt(d)) / (2 * a);
		e2 = (-b - sqrt(d)) / (2 * a);
		cout << " Equation 1: " << setprecision(3) << fixed << e1 << endl;
		cout << "Equation 2: " << setprecision(3) << fixed << e2 << endl;

	}

	else if (d == 0.0){
		e1 = (-b + sqrt(d)) / (2 * a);
		cout << setprecision(3) << fixed << e1 << endl;

	}

	else{
		norm = -b / (2.0 * a);
		i = sqrt(-d) / (2.0 * a);
		cout << setprecision(3) << fixed << norm << " + "
			<< setprecision(3) << fixed << i << 'i' << endl;

		cout << setprecision(3) << fixed << norm << " - " << setprecision(3) 
			<< fixed << i << 'i' << endl;
	}
		

	system ("PAUSE");
	return 0;
}
