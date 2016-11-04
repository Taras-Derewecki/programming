/*******************************************************************************************
Programmer: Taras Derewecki
Date: 09/22/2015

This program should use a while loop to input each of these facts: calculate and display the
new balance (= beginning balance + charges - credits) and determine whether the new balance
exceeds the customer's credit limit.

For those customers whose credit limits is exceeded, the program should display the
customer's account number, credit limit, new balance, and the message
"Credit Limit Exceeded."
*******************************************************************************************/
 
#include <iostream>
#include <cmath>

using namespace std;

int main()
{
	double totalChargesMonth = 0;
	double totalCreditsMonth = 0;
	int accountNumber;
	double initialBalance;
	double availableCredit;
	double newBalance;

	cout << "Enter account number (or 0 to quit): ";
	cin >> accountNumber;

	while (accountNumber != 0)
	{
		cout << "Enter beginning balance: ";
		cin >> initialBalance;
		cout << "Enter total charges: ";
		cin >> totalChargesMonth;
		cout << "Enter total credits: ";
		cin >> totalCreditsMonth;
		cout << "Enter credit limit: ";
		cin >> availableCredit;

		newBalance = (initialBalance + totalChargesMonth - totalCreditsMonth);

		if (newBalance > availableCredit)
		{
			cout << "\n New balance is " << newBalance << endl;
			cout << "Account: " << accountNumber << endl;
			cout << "Credit limit: " << availableCredit << endl;
			cout << "Balance: " << newBalance << endl;
			cout << "Credit Limit Exceeded." << endl;
		}
		else
		{
			cout << "\n New balance is " << newBalance << endl;
		}

		cout << "Enter account number (or 0 to quit): ";
		cin >> accountNumber;
	}


	system("pause");
	return 0;
}