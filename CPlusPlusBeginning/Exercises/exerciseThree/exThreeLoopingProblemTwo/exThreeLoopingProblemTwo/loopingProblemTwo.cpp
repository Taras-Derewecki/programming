/************************************************************************
Programmer: Taras Derewecki
Date: 10/19/2015
Looping Problem Two
************************************************************************/
#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
	float value, sum, average, minimum, maximum;
	int count;
	
	sum = 0.0;
	count = 0;
	cout << "Enter a value: ";
	cin >> value;
	minimum = value;
	maximum = value;



	while (value >= 0.0)
	{

		sum += value;
		count++;
		if (value > maximum)
			maximum = value;
		else if (value < minimum)
			minimum = value;

		cout << "Enter a value: ";
		cin >> value;

		if (value == 0){
			cout << "No data entry" << endl;
			average = sum / count;
			cout << "There were " << setprecision(2) << fixed << count << " numbers" << endl;
			cout << "Average was " << setprecision(2) << fixed << average << endl;
			cout << "Minimum was " << setprecision(2) << fixed << minimum << endl;
			cout << "Maximum was " << setprecision(2) << fixed << maximum << endl;
		}


	}


	system("PAUSE");
	return 0;
}