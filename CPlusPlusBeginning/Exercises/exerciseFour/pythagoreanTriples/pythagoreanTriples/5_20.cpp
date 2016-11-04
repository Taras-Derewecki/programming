/****************************************************************************
Programmer: Taras Derewecki
Date: 11/02/2015
Chapter 5 Section 20: Pythagorean Triples
****************************************************************************/

#include <iostream>
#include <iomanip>

using namespace std;

int main()
{
	int a, s, d; // input
	int c = 0, c_1 = 0; //incrementing variables

	for (a = 1; a <= 500; a++)
		for (s = 1; s <= 500; s++)
			for (d = 1; d <= 500; d++)
			{
				c_1++;
				if ((a*a + s*s == d*d))
					c++;
			}
	cout << "# of Pythagorean Triples with duplicates: " << c << endl;
	cout << "The Innermost for loop is entered " << c_1 << " times." << endl << endl;
	c = 0;
	c_1 = 0;
	for (a = 1; a <= 500; a++)
		for (s = a; s <= 500; s++)
			for (d = s; d <= 500; d++)
			{
				c_1++;
				if ((a*a + s*s == d*d))
					cout << a << " " << s << " " << d << " " << "\n";
					c++;
			}
	cout << "# of Pythagorean Triples with duplicates: " << c << endl;
	cout << "The most inner for the loop has been entered " << c_1 << " times." << endl;

	system("pause");
	return 0;
}