/*
Programmer: Taras Derewecki
Date: 01/12/2015
Assignment One: Linked Lists

Reads in a linked list of integers using pointers to structures 
instead of an array indices.
*/

#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
using namespace std;


// structure for the pointer in your text file
struct entry
{
	int value;
	struct entry *nextPtr; // next pointer variable is pointing the the structure of entry
};

struct entry *getEntry(); // prototype

int main()
{

	//int array[50]; // array of 50 elements
	string fileName;
	ifstream file; // Reads integers from INside a file
	//int fileName;
	int data;
	struct entry *firstPtr, *lastPtr, *auxPtr;
	int i = 0;
	 

	cout << "Input the filename for the list of numbers: " 
	<< endl;
	cin >> fileName;
	cout << "\n";
	file.open("numberFile.txt"); //
	file >> data;
	auxPtr = getEntry();
	firstPtr=lastPtr=auxPtr;
	auxPtr->value=data;
	auxPtr -> nextPtr = NULL;

	//entry *lastPtr;
	//entry *firstPtr = getEntry(fileName); // assigning address of first value to firstPtr
	while ( !file.eof() )
	{	
    	file>>data;
    	auxPtr = getEntry();
    	auxPtr->value=data;
    	auxPtr -> nextPtr = NULL;
		lastPtr -> nextPtr = auxPtr;
		lastPtr = auxPtr;
		//entry *lastPtr=getEntry(fileName); // everytime the value of lastPtr changes until the last value is read;
	}

	file.close();
	auxPtr = firstPtr;

	while(auxPtr != NULL)
	{
		cout << auxPtr -> value << " ";
		auxPtr = auxPtr -> nextPtr;

	  	++i;
	
		if((i) % 10 == 0)
		{
			cout << endl;
		}

	}
	cout << endl;

	/*for (int i=0; i < size; i++)
	{
    	cin >> values[i];
	}

    cout << endl;
    cout << values[size];*/


  
	return 0;
}

	struct entry *getEntry() 	  //the getEntry from prototype 
								  //is pointing to the structure entry 
								  //which has an arguement of the file name
	{
		static struct entry array[50];
		static int nextEntry=0;
		if (nextEntry >= 50)
		{
			return NULL;
		}

		else
		{
			array[nextEntry].value = 0;
			nextEntry++;
			return &array[nextEntry - 1];
		}

	}