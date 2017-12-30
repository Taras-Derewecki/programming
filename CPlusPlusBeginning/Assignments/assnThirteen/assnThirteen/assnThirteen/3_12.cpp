/********************************************************************************************
Programmer: Taras Derewecki
Date: 11/20/2015
Assignment Thirteen: Account Class

This program to creates a class account with data member's accountBalance
and member functions debit, credit and getBalance methods. This creates objects 
for two classes and test each method of a class.

********************************************************************************************/

#include <cstdio>
#include <cstdlib>
#include <iostream>

using namespace std;

//add account class
class Bank_Account
{
    
public:
    Bank_Account(double);
    void setBal(double);
    double getBal();
    double debitBal(double);
    double creditBal(double);
    
private:
    double bal; // integer for bank account balance
    
};

#include <cstdio>
#include <cstdlib>
#include <iostream>

using namespace std;

//Adds a constructor
Bank_Account::Bank_Account(double initialBal)
{
    if (initialBal >= 0)
        setBal(initialBal);
    
    if (initialBal < 0)
    {
        bal = 0;
        cout << "Account balance can't be negative. Account amount set as 0" << endl;
    }
}

void Bank_Account::setBal(double initialBal)
{
    bal = initialBal;
}

double Bank_Account::debitBal(double debitAmt)
{
    if (debitAmt > bal)
        cout << "Your balance is not enough." << endl;
    else
    {
        bal -= debitAmt;
    }
    
    return bal;
    cout << endl;
}

double Bank_Account::creditBal(double creditAmt)
{
    bal += creditAmt;
    return bal;
    
}

double Bank_Account::getBal()
{
    return bal;
    
}

#include <cstdio>
#include <cstdlib>
#include <iostream>

using namespace std;

int main()
{
    Bank_Account accountOne(500);
    Bank_Account accountTwo(350);
    
    double transaction; //variable for a transaction
    double acctNum; //variable for an account number
    double debitAmt; //variable for debit amount
    double creditAmt; //variable for credit amount
    
    //display initial balances
    cout << "Initial balance of Account 1 is " << accountOne.getBal() << endl;
    cout << "Initial balance of Account 2 is " << accountTwo.getBal() << endl;
    
    cout << "Please select one of the following options (enter the number):" << endl;
    cout << "1. Balance" << endl;
    cout << "2. Debit" << endl;
    cout << "3. Credit" << endl;
    
    cin >> transaction;

	while (transaction >= 4 || transaction <= 0){
		cout << "ERROR CODE 0504: Invalid Response!" << endl;
		break;
	}

	if (transaction == 1){
		cout << "Balance is selected" << endl;
		cout << "Select the account (enter the number): " << endl;
		cout << "1. account 1\n2. account 2" << endl;

		cin >> acctNum;

		if (acctNum == 1){
			cout << "Account 1 balance: " << accountOne.getBal() << endl;
		}

		if (acctNum == 2){
			cout << "Account 2 balance: " << accountTwo.getBal() << endl;
		}
		else{
			cout << "ERROR CODE 0504: Invalid Response!" << endl;

		}


	}

	if (transaction == 2){
		cout << "Debit is selected" << endl;
		cout << "Select the account (enter the number): " << endl;
		cout << "1. account 1\n2. account 2" << endl;

		cin >> acctNum;

		if (acctNum == 1){
			cout << "Account 1 balance: " << accountOne.getBal() << endl;
			cout << "Enter debit amount: " << endl;
			cin >> debitAmt;
			accountOne.debitBal(debitAmt);
			cout << "Current balance is " << accountOne.getBal() << endl;
		}

		if (acctNum == 2){
			cout << "Account 2 balance: " << accountTwo.getBal() << endl;
			cout << "Enter debit amount: " << endl;
			cin >> debitAmt;
			accountTwo.debitBal(debitAmt);
			cout << "Current balance is " << accountTwo.getBal() << endl;
		}

		else{
			cout << "ERROR CODE 0504: Invalid Response!" << endl;
		}
	}

	if (transaction == 3){
		cout << "Credit is selected" << endl;
		cout << "Select the account (enter the number): " << endl;
		cout << "1. account 1\n2. account 2" << endl;

		cin >> acctNum;

		if (acctNum == 1){
			cout << "Account 1 balance: " << accountOne.getBal() << endl;
			cout << "Enter credit amount: " << endl;
			cin >> creditAmt;
			accountOne.creditBal(creditAmt);
			cout << "Current balance is " << accountOne.getBal() << endl;
		}

		if (acctNum == 2){
			cout << "Account 2 balance: " << accountTwo.getBal() << endl;
			cout << "Enter credit amount: " << endl;
			cin >> creditAmt;
			accountTwo.creditBal(creditAmt);
			cout << "Current balance is " << accountTwo.getBal() << endl;
		}

		else{
			cout << "ERROR CODE 0504: Invalid Response!" << endl;
		}

	}
    
    system("PAUSE");
    return 0;
    
}