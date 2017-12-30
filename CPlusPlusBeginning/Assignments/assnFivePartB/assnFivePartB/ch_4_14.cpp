/*******************************************************************************************
Programmer: Taras Derewecki
Date: 09/22/2015

This program will determine whether a department-store customer has exceeded the credit
limit on a charge account.

For each customer, the following facts are to be input by the user:
1. Account number (an integer)
2. Balance at the beginning of the month
3. Total of all items charged this month by the customer
4. Total of all credits applied to the customers account this month
5. Allowed credit limit
*******************************************************************************************/

#include <iostream>
using namespace std;

int main(){
	int acctNum;
	double balance, totalItems, totalCredits, creditLimit;

	cout << "Enter your account number here: \n";
	cin >> acctNum;

	cout << "Enter your balance at the beginning of the month here: \n";
	cin >> balance;

	cout << "Enter your total of all items charged to you: \n";
	cin >> totalItems;

	cout << "Enter your total of all credits applied to your account this month: \n";
	cin >> totalCredits;

	cout << "Enter your total credit limit: \n";
	cin >> creditLimit;

	if (creditLimit < balance){
		cout << "You have exceeded your credit limit \n";
	}
	else if (creditLimit == balance){
		cout << "Your balance is equal to your credit limit \n";
	}
	else {
		cout << "You have not exceeded your credit limit \n";
	}



	system ("pause");
	return 0;
}