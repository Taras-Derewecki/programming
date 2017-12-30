/***************************************************************
Programmer: Taras Derewecki
Date: 10/06/2015
Chapter 4 Section 34A: Factorial
***************************************************************/
#include <iostream>
using namespace std;

int main(){

int x; //input control
int result = 1; //output

cout << "Enter number: ";
cin >> x;

while (x > 0){
	result = result * x;
	x--;
}
cout << result << endl;

system("PAUSE");
return 0;
}