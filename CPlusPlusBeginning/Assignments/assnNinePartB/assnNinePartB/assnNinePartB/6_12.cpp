/*****************************************************************************
Programmer: Taras Derewecki
Date: 10/23/2015
Assignment Nine Part B: Parking Charges
****************************************************************************/
#include <iostream>
#include <iomanip>
using namespace std;

double calcCharge(double);

int main()
{
	
	double x, y, z; // input

	cout << "Enter hours for three customers: " << endl;
	cin >> x >> y >> z;

	cout << "Car" << setw(10)<< "Hours" << setw(10) << "Charge" << endl;

	cout << '1' << setw(10) << fixed << setprecision(1) << x
		<< setprecision(2) << setw(10) << calcCharge(x) << endl;

	cout << '2' << setw(10) << fixed << setprecision(1) << y
		<< setprecision(2) << setw(10) << calcCharge(y) << endl;

	cout << '3' << setw(10) << fixed << setprecision(1) 
		<< z
		<< setprecision(2) 
		<< setw(10)
		<< calcCharge(z) 
		<< endl;

	cout << "TOTAL" << setw(5) << fixed 
		<< setprecision(1) 
		<< x + y + z
		<< fixed << setprecision(2) 
		<< endl << setw(10)
		<< calcCharge(x) + calcCharge(y) + calcCharge(z) << endl;

	system("PAUSE");
	return 0;
}


double calcCharge(double hrs) // calculated charge function
{
	if (hrs <= 3)
		return 2.00;
	else
	{
		if (hrs < 24)
			return 2.00 + (hrs - 3) * 0.5;
		else
			return 10.00;
	}
}