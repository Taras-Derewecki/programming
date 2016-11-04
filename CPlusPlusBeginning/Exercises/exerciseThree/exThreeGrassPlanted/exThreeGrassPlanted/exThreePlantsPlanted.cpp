/***********************************************************************************
Programmer: Taras Derewecki
Date: 10/20/2015
 Sel Control 3: Grass Planted
***********************************************************************************/

#include <iostream>
using namespace std;
		int main(){

			char g; // This will be used for the grass type input

			cout << "Enter a character to represent the grass type: ";
			cin >> g;
			cout << endl << endl;

			switch (g){

			case 'R':
				cout << "Grass Type: Rye" << "\n" << endl;
				break;

			case 'F':
				cout << "Grass Type: Fescue" << "\n" << endl;
				break;

			case 'B':
				cout << "Grass Type: Bermuda" << "\n" << endl;
				break;

			case 'z':
				cout << "Grass Type: Zoysia" << "\n" << endl;
				break;

			case 'P':
				cout << "Grass Type: Pampas" << "\n" << endl;
				break;

			default:
				cout << "Unknown grass type." << "\n" << endl;
				break;
			}

			system("PAUSE");
			return 0;

		}