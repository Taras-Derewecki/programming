/*********************************************************************************
Programmer: Taras Derewecki
Date: 11/17/2015
Chapter 6 Section 37: Iterative Fibonacci Series
*********************************************************************************/
#include <iostream>
using namespace std;


double fibonacci(int n);//prototype

int main()
{
	int a; //input

	cout << "How many numbers would you like to ouput: " << endl;
	cin >> a;

	for (int j = 0; j < a; ++j)
	{
		cout << fibonacci(j) << endl;
	}
	system("PAUSE");
	return 0;
}

/*non recursive fibonacci function*/
double fibonacci(int n)
{
	double prevNum = -1; // formula
	double res = 1; //formula
	double sum;// formula
	int j; //counter control variable

	for (j = 0; j <= n; ++j)
	{
		sum = res + prevNum;
		prevNum = res;
		res = sum;
	}

	return res;
}