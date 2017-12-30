/****************************************************
Prompts the user for two real coordinates, 
and displays where it lies on the Cartesian plane.
To be compiled WITHOUT debugging!

Programmer: Taras Derewecki
*****************************************************/

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	double xCoord, yCoord; //The coordinates

	//Input
	cout << "Enter two real coordinates => ";
	cin >> xCoord >> yCoord;

	//Start output and standardize the display
	cout << fixed << showpoint;
	cout << "Point (" << xCoord << ". " << yCoord << ") is ";

	//Determine the rest of the output
	if (xCoord == 0.0) {
		if (yCoord == 0.0){
			cout << "at the origin" << endl;
			system("pause");
			return 0;
		}
		cout << "on the y-axis" << endl;
		system("pause");
		return 0;
	}
	if (yCoord == 0.0){
		cout << "on the x-axis" << endl;
		system("pause");
		return 0;
	}
	// both coordinates are not 0.0
	if (xCoord > 0.0) {
		if (yCoord > 0.0){
			cout << "in the first quadrant" << endl;
			system("pause");
			return 0;
		}
		cout << "in the fourth quadrant" << endl;
		return 0;
	}
	//x-coordinate is < 0.0
	if (yCoord > 0.0){
		cout << "in the second quadrant" << endl;
		system("pause");
		return 0;
	}
	cout << "in the third quadrant" << endl;
	system("pause");
	return 0;
	
	
}