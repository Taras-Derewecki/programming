#include <iostream>
#include <iomanip>

using namespace std;

double fahrenheit(double); //prototype

double celsius(double); // prototype

int main()

{

	cout << "Celsius" << setw(15) << "Fahrenheit" << endl;
	cout << "_______________________" << endl << endl;

	for (int deg = 0; deg <= 100; deg++)
	{
		if (deg % 5 == 0)
		{
			cout << deg << setw(15) << fahrenheit(deg) << endl;
		}
	}

	cout << "_______________________" << endl << endl;

	for (int deg = 0; deg <= 100; deg++)
	{
		if (deg % 5 != 0)
		{
			cout << deg << setw(15) << fahrenheit(deg) << endl;
		}
	}

	cout << "__________________________" << endl << endl;

	for (int deg = 32; deg <= 212; deg++)
	{
		if ((deg + 4) % 9 != 0)
		{
			cout << celsius(deg) << setw(15) << deg << endl;
		}
	}

	system("pause");
	return 0;
}


double celsius(double fahrenheit)

{

	return ((5 * fahrenheit - 160) / 9);

}

double fahrenheit(double celsius)
{

	return ((9 * celsius + 160) / 5);

}