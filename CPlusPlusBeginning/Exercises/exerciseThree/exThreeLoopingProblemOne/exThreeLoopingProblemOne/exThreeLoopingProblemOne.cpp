/********************************************************
Programmer: Taras Derewecki
Date: 10/06/2015
Looping Problem One
********************************************************/
#include <iostream>

using namespace std;
int main(){
	int i=0, sum = 0, n;
	cout << "Enter a number between 0-100" << endl;
	cin >> n;

	do{
		sum = sum + n;
		n = n - 1;
	} 
	
	while (i <= n);
	cout << " The sum is " << sum << endl;


	system("PAUSE");
	return 0;
	
}
	