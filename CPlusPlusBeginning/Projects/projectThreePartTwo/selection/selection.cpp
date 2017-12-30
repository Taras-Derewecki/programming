/********************************************************************************************
Programmer: Taras Derewecki
Date: 11/30/2015
Selection Sorter

This program sorts numbers via a selection algorithm
********************************************************************************************/

#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
#include <array>
#include <cstdlib>
#include <vector>

using namespace std;

int main()
{
	string file; // obtains file name
	int selectarray[100]; //holds 100 integers
	int s = 0; //int to read integers
	int count = 0; // counter control vartiable
	int filler = 0; // for an array to be 0
	int least = 0; // for an array to be 0
	int temp = 0;// temporary name to hold something
	int swaps = 0; //number of swaps

	for (int i = 0; i < 100; i++)
	{
		selectarray[i] = 0; // initializes the array
	}

	cout << "Enter the name of a file of integers to be sorted: " << endl; //prompts the user for the name of the file
	cin >> file;
	ifstream newfile(file); //reads in the name
	ofstream outfile("result.txt"); // reads out another file



	while (true)
	{
		newfile >> s;

		//cout << s << " "<< count << endl;

		selectarray[count] = s;
		count++;

		

		if (newfile.eof()){
			break;
		}
		

	}
	// cout << count << endl;

	for (int k = 0; k < count; k++)
	{
		filler = k;
		least = k;

		for (int i = k + 1; i < count; i++)
			if (selectarray[i] < selectarray[least]) // index swap
			{
				least = i;
			}

		if (filler != least) //if to fill and least are not equal, swap
		{
			temp = selectarray[filler];
			selectarray[filler] = selectarray[least];
			selectarray[least] = temp;
			swaps++; //swap counter
		}

	}

	//for (int x = 0; x < count; x++){
	//	outfile << selectarray[x] << ' ';
	//}

	outfile << endl;

	cout << "The sorted integer-formatted numbers are the file: result.txt" << endl; // outputs the sorted integers
	cout << "Total Numbers (Integer Format): " << count << endl; // Number of integers
	cout << "Total Swaps: " << swaps << endl; // Number os swaps preformed

	outfile << "The sorted integer-formatted numbers are the file: result.txt" << endl; // outputs the sorted integers
	outfile << "Total Numbers (Integer Format): " << count << endl; // Number of integers
	outfile << "Total Swaps: " << swaps << endl << endl; // Number os swaps preformed

	for (int y = 0; y<count; y++){
		for (int z = 0; z <= 9; z++){
			if (y != count){
				cout << right << setw(4) << selectarray[y];
				outfile << right << setw(4) << selectarray[y];
				y++;
			}
			else {
				cout << endl;
				outfile << endl;
				system("PAUSE");
				return 0;
			}
		}
		y -= 1;
		cout << endl;
		outfile << endl;
	}

	newfile.close();
	outfile.close();

	system("PAUSE");
	return 0;


}