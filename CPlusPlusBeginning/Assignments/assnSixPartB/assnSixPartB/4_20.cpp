/****************************************************************************************************
Programmer: Taras Derewecki
Date: 10/01/2015
Assignment Six, Chapter 4 Section 20
****************************************************************************************************/
#include <iostream>
using namespace std;

int main(){

	//initializing variables in declarations
	unsigned int passes = 0; //number of passes
	unsigned int failures = 0; // number of failures
	unsigned int studentCounter = 0; //student counter

	//process 10 students using counter-controlled loop
	while (studentCounter <= 9){
		//Prompt the user for input and obtain value from the user
		cout << "Enter result (1 = pass, 2 = fail): ";
		int result = 0; // one exam result (1 = pass, 2 = fail)
		cin >> result; //input result

		while (result > 2 || result < 1){

			cout << "You have entered an invalid digit, please try again: " << endl;
			cin >> result;

		}


		

		//if ... else nested in while
		if (result == 1)		  // if result is 1,
		passes = passes + 1; //increment passes;


		

		if (result == 2){
			failures = failures + 1;
		}
		{
			// else result is not 1
		}
	 // increment failures

		// increment studentCounter so loop eventually terminates
		studentCounter = studentCounter + 1;
		} // end while

		// termination phase: display number of passes and failures
		cout << "Passed " << passes << "\nFailed " << failures << endl;

		// determine whether more than eight students passed
		if (passes > 8){
			cout << "Bonus to instructor!" << endl;
		}
		
	

	system ("pause");
	return 0;
}