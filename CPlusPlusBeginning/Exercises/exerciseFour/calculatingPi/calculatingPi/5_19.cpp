/*****************************************************************************
Programmer: Taras Derewecki
Date: 11/02/2015
Chapter 5 Section 19: Calculating Pi
*****************************************************************************/

#include <iostream>
#include <iomanip>

using namespace std;



int main()
{
	cout << fixed << setprecision(10) << showpoint;

	for (double tar = 1; tar <= 10000; tar++){
		double pi;
		if (tar == 1){
			pi = 4;
			cout << tar << " : " << pi << "\n";
		}

		else if ((int)(tar) % 2 == 1){

			pi += (4 / ((2 * tar) - 1));
			cout << tar << " : " << pi << "\n";

		}

		else{
			pi -= (4 / ((2 * tar) - 1));
			cout << tar << " : " << pi << "\n";
		}
		}
	system("PAUSE");
	return 0;
	}