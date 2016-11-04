/*******************************************************************************************
Programmer: Taras Derewecki
Date: 09/23/2015

Input Output Question # 1
*******************************************************************************************/

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int main(){

	ofstream tdereweckiFile;
	tdereweckiFile.open("Weapons.txt");
	tdereweckiFile << "sword, spear, shield" << endl;
	tdereweckiFile.close();


	system ("pause");
	return 0;
	// Yes, the OS made a file for my text
}