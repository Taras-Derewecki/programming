/********************************************************
Programmer: Taras Derewecki
Date: 11/12/2015
Functions Question 6
********************************************************/
#include <iostream> 
using namespace std;

int main()
{

	double quizOne, quizTwo, examOne, examTwo; // Input
	double qOne, qTwo,equationOne,equationTwo; // Formula Variables
	double finalGrade;// Formula for the end result

	cout << "Percentage of First Quiz: ";
	cin >> quizOne;
	cout << "Percentage of Second Quiz: ";
	cin >> quizTwo;
	cout << "Percentage of First Exam: ";
	cin >> examOne;
	cout << "Percentage of Second Exam: ";
	cin >> examTwo;

	qOne = quizOne*0.2;
	qTwo = quizTwo*0.2;
	equationOne = examOne*0.3;
	equationTwo = examTwo*0.3;

	finalGrade = qOne + qTwo + equationOne + equationTwo;

	cout << "Final Grade: " << finalGrade << endl;


	system("pause");
	return 0;
}
