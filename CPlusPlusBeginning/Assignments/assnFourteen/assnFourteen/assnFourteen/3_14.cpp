/*********************************************************************************
Programmer: Taras Derewecki
Date: 12/02/2015
Chapter 3 Section 14: Employee Class
*********************************************************************************/

#include <iostream> 
#include <iomanip>
#include <cmath>
#include <string>
using namespace std;

class Employee{ // Class

public:
	Employee (){} // Constructor to pass parameters into


	Employee(string fname, string lname, int msal, int ysal, int ysalr){
	
		first = fname; //displays first name
		last = lname; // displays last name
		monthlySalary = msal; // display monthly salary
		yearlySalary = ysal; // display yearly salary
		yearlySalaryRaise = ysalr; // display employee 10% raise

	}


	/******************************************************************
							SET METHODS
	******************************************************************/
	void setFirst(string fname){
		first = fname;
	}
	void setLast(string lname){
		last = lname;
	}

	void setYearlySalary(int ysal){
		yearlySalary = ysal*12;
	}

	void setYearlySalaryRaise(int ysalr){
		yearlySalaryRaise = (ysalr * 12) * 1.1;
	}


	void setMonthlySalary(int msal){
		monthlySalary = msal;


	}
	/****************************************************************
							SET METHODS
	****************************************************************/


	/****************************************************************
							GET METHODS
	****************************************************************/
		string getFirst(){
			return first;
		}
		string getLast(){
			return last;
		}
		int getYearlySalary(){
			return yearlySalary;
		}

		int getYearlySalaryRaise(){
			return yearlySalaryRaise;
		}
	
		int getMonthlySalary(){
			return monthlySalary;
		}

		/****************************************************************
							GET METHODS
		****************************************************************/


		/****************************************************************
		  Display Employee's method, which I cout in the main function
		****************************************************************/
		void displayEmployee(){
			cout << "First Name: " << first << endl;
			cout << "Last Name: " << last << endl;
			cout << "Monthly Salary: $" << monthlySalary << endl;
			cout << "Yearly Salary: $" << yearlySalary << endl;
			cout << "Yearly Salary with a 10% Raise: $" << yearlySalaryRaise << endl;

		}

		/****************************************************************
		Display Employee's method, which I cout in the main function
		****************************************************************/

private:
	string first; // for first name
	string last; // for last name
	int monthlySalary, yearlySalary, yearlySalaryRaise; // for monthly, yearly, and yearly salary raise
};


int main(){
	Employee employeeOne, employeeTwo; // call from the class "Employee
	string first, last; // input
	int monthlySal, monthlySalOne; // input


	/***************************************************************************
									FIRST EMPLOYEE
	***************************************************************************/

	cout << "Enter your first name: " << endl;
	cin >> first;
	cout << endl;
	employeeOne.setFirst(first);
	cout << "You've entered: " << employeeOne.getFirst() << endl << endl;

	cout << "Enter your last name: " << endl;
	cin >> last;
	cout << endl;
	employeeOne.setLast(last);
	cout << "You've entered: " << employeeOne.getLast() << endl << endl;

	cout << "Enter your monthly salary: " << endl;
	cin >> monthlySal;
	cout << endl;
		employeeOne.setMonthlySalary(monthlySal);
		cout << "You've entered: $" << employeeOne.getMonthlySalary() << endl << endl;


		employeeOne.setYearlySalary(monthlySal);
		cout << "Yearly Salary: $" << employeeOne.getYearlySalary() << endl << endl;

		cout << "You've received a 10% raise!" << endl;
		employeeOne.setYearlySalaryRaise(monthlySal);
		cout << "Yearly Salary: $" << employeeOne.getYearlySalaryRaise() << endl << endl;

		employeeOne.displayEmployee();

	/***************************************************************************
									FIRST EMPLOYEE
	***************************************************************************/



	/***************************************************************************
									SECOND EMPLOYEE
	***************************************************************************/
	

	cout << "Enter your first name: " << endl;
	cin >> first;
	cout << endl;
	employeeTwo.setFirst(first);
	cout << "You've entered: " << employeeTwo.getFirst() << endl << endl;

	cout << "Enter your last name: " << endl;
	cin >> last;
	cout << endl;
	employeeTwo.setLast(last);
	cout << "You've entered: " << employeeTwo.getLast() << endl << endl;

	cout << "Enter your monthly salary: " << endl;
	cin >> monthlySalOne;
	cout << endl;
	employeeTwo.setMonthlySalary(monthlySalOne);
	cout << "You've entered: $" << employeeTwo.getMonthlySalary() << endl << endl;

	employeeTwo.setYearlySalary(monthlySalOne);
	cout << "Yearly Salary: $" << employeeTwo.getYearlySalary() << endl << endl;

	employeeTwo.setYearlySalaryRaise(monthlySalOne);
	cout << "You've received a 10% raise!" << endl;
	cout << "Yearly Salary: $" << employeeTwo.getYearlySalaryRaise() << endl << endl;

	employeeTwo.displayEmployee();


	/***************************************************************************
									SECOND EMPLOYEE
	***************************************************************************/



	system("PAUSE");
	return 0;
}