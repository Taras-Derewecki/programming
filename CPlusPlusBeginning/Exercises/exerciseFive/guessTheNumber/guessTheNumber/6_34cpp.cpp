/******************************************************************
Programmer: Taras Derewecki
Date: 11/17/2015
Chapter 6 Section 34: Guess The Number
******************************************************************/

#include <iostream>
#include <cstdlib>

using namespace std;

int main()
{

	int a; // function
	int b; //input
	char letter; // input

	do
	{

		a= rand() % 1000;

		cout << "Can you guess the number between 1-1000?" << endl;

		do
		{

			cin >> b;

			if (b < a)
			{
				cout << "\nToo low. Try again - ";
			}
			if (b> a)
			{
				cout << "\nToo high. Try again - ";

			}

		} while (b != a);

		cout << endl << "Well Done! You have guessed the number correctly :D " << endl;
		cout << endl << endl << "Play Again? :o(Y or N) - " << endl;
		cin >> letter;

	} while ((letter == 'y') || (letter == 'Y'));

	system("pause");
	return 0;

}