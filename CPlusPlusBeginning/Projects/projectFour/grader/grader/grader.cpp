/**************************************************************************************
Programmer: Taras Derewecki
Date: 12/11/2015
Grader Project

This program that takes a list of final scores from one .txt file for a classroom 
consisting of 99 students or less and determines the following outcome in a file:
1) Mean (Greek letter mu)
2) Standard Deviation (Greek letter sigma)
3) # of grades in each category: (A, A-, B+, B-, C+, C, C-, D+, D, and F)
**************************************************************************************/

#include <iostream>
#include <iomanip>
#include <fstream>
#include <cmath>
#include <string>
using namespace std;

int main(){
	string file_name;

	int max_grade = 0; // maximum grade
	int min_grade = 101; // minimum grade
	double std_dev; // standard deviation
	int rint = 0; //variable to read integers 
	int arr = 0; //number of ints in array 
	int sum = 0; // sum
	double avg = 0; // average
	double var = 0.0, varTotal = 0.0; // used for finding variance
	int c = 0; // counter-controlled variable
	int array[100]; // array
	int grades[11] = {0}; // array for grades


	cout << "Enter the name of a file of grades to be calculated: "; // prompts the user for the input file
	cin >> file_name;


	ifstream myfile(file_name.c_str(), ios::in); //this counts up to the number of valid integers in the array 

	while (!myfile.eof())
	{
		myfile >> rint;  // inputs the integers
		array[arr] = rint;
		 arr++;
		 //c++;
		//cout << c << endl << arr << endl;


	}

	for (int c = 0; c < arr; c++){ // for loop to find the sum

		sum += array[c];

		
		if (array[c] > max_grade)
		{
			max_grade = (int)array[c]; // find the max grade
		}
		if (array[c] < min_grade)
		{
			min_grade = (int) array[c]; //finds the min grade
		}
		
	}
	//cout << sum;


	//arr
	avg = (double) sum /  arr; // equation to find the average

		varTotal = 0.0;

	for (int c = 0; c < arr; c++){ // finds variance
		var = pow((array[c] - avg), 2);
		varTotal += var;
	}

	
	std_dev = sqrt(varTotal / (double) arr);
	cout << "Average: " << avg << endl; // outputs the average
	cout << "Standard deviation: " << std_dev << endl; // outputs the standard deviation
	c = 0;
	//cout << c << endl << arr << endl;

	while (c < arr){ // takes each input and categorizes it with an A, A-, B+ , B, B- , C+ , C, D, or F


		if (array[c] >= (avg + ((4.0 / 3.0) * std_dev))){
			grades[0]++;
		}
		else if (array[c] >= (avg + ((3.0 / 3.0) * std_dev))){
				grades[1]++;
		}
		else if (array[c] >= (avg + ((2.0 / 3.0) * std_dev))){
			grades[2]++;
		}
		else if (array[c] >= (avg + ((1.0 / 3.0) * std_dev))){
			grades[3]++;
		}
		else if (array[c] >= (avg + ((0.0 / 3.0) * std_dev))){
			grades[4]++;
		}
		else if (array[c] >= (avg - ((1.0 / 3.0) * std_dev))){
			grades[5]++;
		}
		else if (array[c] >= (avg - ((2.0 / 3.0) * std_dev))){
			grades[6]++;
		}
		else if (array[c] >= (avg - ((3.0 / 3.0) * std_dev))){
			grades[7]++; 
		}
		else if (array[c] >= (avg - ((4.0 / 3.0) * std_dev))){
			grades[8]++; 
		}
		else if (array[c] >= (avg - ((5.0 / 3.0) * std_dev))){
			grades[9]++;
		}
		else if (array[c] < (avg - ((5.0 / 3.0) * std_dev))){
			grades[10]++; 
		}
		//cout << array[c];
		c++;

		//cout << c << endl << arr << endl;
	}

	//cout << c << endl << arr << endl;

	ofstream fileTwo("categorizedGrades.txt"); //opens file for output

	fileTwo << "A" << setw(10) << "A-" << setw(10) << "B+" << setw(10) << "B" << setw(10) << "B-" << setw(10)
		<< "C+" << setw(10) << "C" << setw(10) << "C-" << setw(10) << "D+" << setw(10) << "D" << setw(10) << "F"
		<< endl;

	fileTwo << grades[0] << setw(10) << grades[1] << setw(10) << grades[2] << setw(10) << grades[3] << setw(10) << grades[4] << setw(10) << grades[5]
		<< setw(10) << grades[6] << setw(10) << grades[7] << setw(10) << grades[8] << setw(10) << grades[9] << setw(10) << grades[10] << endl << endl;

	fileTwo << "Average" << setw(25) << "Standard Deviation" << setw(20) << "Highest Grade" << setw(15)
		<< "Lowest Grade" << setw(15) << "Range" << endl;


	 fileTwo << avg << setw(18) << std_dev << setw(23) << max_grade << setw(14) << min_grade << setw(18) << (max_grade - min_grade);



	// Tell user of the file name
		//cout << c << endl << arr << endl;


	cout << "File name: categorizedGrades.txt" << endl;
	cout << "# of values on file: " << arr << endl;

	fileTwo.close();

	system("pause");
	return 0;
}
