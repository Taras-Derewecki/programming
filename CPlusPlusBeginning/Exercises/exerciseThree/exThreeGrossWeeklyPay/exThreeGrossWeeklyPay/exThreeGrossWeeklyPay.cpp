/**********************************************************
Programmer: Taras Derewecki
Date: 10/06/2015
Gross Weekly Pay
**********************************************************/
#include <iostream>
using namespace std;

int main(){

	double grossWeeklyPay, hourlyWage, hours, grossWeeklyPayOne;

	cout << "Enter your hourly wage: " << endl;
	cin >> hourlyWage;
	
	cout << "Enter your hours worked for this week: " << endl;
	cin >> hours;

	if (hours > 40){
		grossWeeklyPay = 40 * hourlyWage + ((hours - 40) * hourlyWage * 1.5);
	
		cout << "Your gross weekly pay for this week: " << '$' << grossWeeklyPay << endl;
		}


		if (hours <= 40){
			grossWeeklyPayOne = hourlyWage * hours;
			cout << "Your gross weekly pay for this week: " << '$' << grossWeeklyPay << endl;
		}
	

	system("PAUSE");
	return 0;





}