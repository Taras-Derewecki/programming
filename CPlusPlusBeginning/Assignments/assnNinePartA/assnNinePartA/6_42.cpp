/******************************************************************************
Programmer: Taras Derewecki
Date: 10/22/2015
Assignment Nine Part A: Distance Between Points
******************************************************************************/
#include <iostream>
#include <cmath>
using namespace std;

double dc(double, double, double, double); // Prototype

int main()
{
	
	double x_1, x_2, y_1, y_2; // input
	double d; // formula

	cout << "Enter the value of x1: ";
	cin >> x_1;
	cout << "Enter the value of y1: ";
	cin >> y_1;
	cout << "Enter the value of x2: ";
	cin >> x_2;
	cout << "Enter the value of y2: ";
	cin >> y_2;

	d = dc(x_1, x_2, y_1, y_2);

	cout << "The distance between the coordinates is: " << d << endl;


	system("pause");
	return 0;

}
	double dc(double x_1, double x_2, double y_1, double y_2){
	return sqrt(pow((x_1 - x_2), 2.0) + pow((y_1 - y_2), 2.0));
}