/**************************************************************
Part C: Cube

This program demonstrates the use of three functions.
**************************************************************/

#include <iostream>
using namespace std;

int Square(int);
int Cube (int);


int main()
{
	cout << "The square of 27 is " << Square(27) << endl;
	cout << "and the cube of 27 is " << Cube(27) << endl;

	system("pause");
	return 0;
}

int Square(int n)
{
	return n * n;
}

int Cube(int n)
{
	return n * n * n;
}