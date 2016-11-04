/********************************************************************************************
Programmer: Taras Derewecki
Date: 03/02/2016
Assignment Eight: Queue-based linked lists

Program Description:

This program will create a queue-based linked list application that allows the user to enter 
a list of positive integers (up to 25), possibly with duplicates in the linked list. The 
application should enqueue the integers in the order specified by the user, removing any 
duplicates, and allow the user to enter 0 or a negative integer to quit entering integers. 
Then, print out the queue resulting from head to tail.
*********************************************************************************************/

#include <iostream>
#include <cstdlib>
#include <string>
#include <iomanip>
#include <fstream>
using namespace std;



struct entry // structure for the pointer in your text file
{
	int value;				// for the pointer's integer value that will be used in main
	struct entry *nextPtr; // next pointer variable is pointing the the structure of entry
};

struct entry *getEntry(); // prototype


int main()
{
	int data; // input
	bool noDuplicate; // to check if it is not a duplicate
	struct entry *firstPtr, *lastPtr, *auxPtr; // pointers for a linked list
	int i = 0; //  my counter variable
	//int inputArray[25];

	cout << "Enter 25 positive integers(Entering a zero or any negative integer will ";
	cout << "result in program termination): ";

	cin >> data;

	firstPtr = getEntry();
	firstPtr -> value = data;
	firstPtr -> nextPtr = NULL;
	lastPtr = firstPtr;
	//cout << "H" << endl;

	while ( data > 0 )
	{	
		cin >> data;
		noDuplicate = true;
		auxPtr = firstPtr;

		// cout << "h" << endl;

		while(auxPtr != NULL)
		{
			if (auxPtr -> value == data )
			{
				noDuplicate = false;
				break;
				//cout << auxPtr -> value << " ";
			}

			// cout << "h" << endl;
			auxPtr = auxPtr -> nextPtr;

			
		}

			if (noDuplicate)
			{
		    	auxPtr = getEntry();
    			auxPtr -> value = data;
    			auxPtr -> nextPtr = NULL;
				lastPtr -> nextPtr = auxPtr;
				lastPtr = auxPtr;
			}

	}	

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
	
/*
		if( data != isDuplicate )
		{
			cout << data;
			break;
		}

		else
		{
			cin >> data;
			break;
		}
*/
	

	//auxPtr = firstPtr;
	cout << endl;
  
	return 0;
}


	struct entry *getEntry() 	  //the getEntry from prototype 
								  //is pointing to the structure entry 
								  //which has an arguement of the file name
	{
		static struct entry array[25];
		static int nextEntry=0;
		if (nextEntry >= 25)
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