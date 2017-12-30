/******************************************************************************
Programmer: Taras Derewecki
Date: 03/29/2016
Exercise Four: Priority Queue
Program Description:
Implement a priority queue of maximum length 25. Use priorities ranging from 0 
to 10 with the highest priority a 0. Prompt the user for a priority and a job 
name (a string), and allow the user to enter a -1 priority to quit entering 
jobs. This exercise requires that you implement a function to insert a job 
anywhere in the queue, which must be implemented as a linked list. Do not 
remove any duplicates; that is, the same job can be entered multiple times 
with the same or different priorities. After the user has quit entering 
priorities and jobs, print out the resulting queue from head to tail.
******************************************************************************/

#include <iostream>
#include <string>
using namespace std;

struct entry
{
	int priority; // stores the priority in the list
	string jobName;	// job name of different parts
	struct entry *leftPtr;	// right pointer attribute for any given element in the linked list       
	struct entry *rightPtr;	// left pointer attribute for any given element in the linked list
};

struct entry *getEntry() // pointer of getEntry to structure of entry
{
	static struct entry list[ 25 ]; //  array of 25 elements
	static int nextEntry = 0;

	if ( nextEntry >= 25 ) return NULL;
	list[ nextEntry ].priority = 0;
	list[ nextEntry ].jobName = " ";
	list[ nextEntry ].leftPtr = NULL;
	list[ nextEntry ].rightPtr = NULL;
	nextEntry++;
	return &list[ nextEntry - 1 ];
}

int biSort( struct entry *, struct entry *, struct entry *, struct entry *);  // prototype

int main()
{
	
	struct entry *h, *t, *m;// head, tail, and middle of list
	struct entry *x = new struct entry;	// the middle man of the list (auxillary pointer)
	h = t = m = NULL;
	

	x -> priority = 1;


	while (x -> priority > 0)
	{
		cout << "Enter a priority number followed by a job name, or enter a number less than zero to exit: ";
		x = getEntry();
		cin >> x -> priority >> x -> jobName;

		if (x -> priority <= 0)
		{
			break;
		}

		if (h == NULL)
		{
			h = m = t = x;
		}

		else
		{
			biSort(h, m, t, x);

			if (t -> rightPtr != NULL)
			{
				t = t -> rightPtr;
			}

			else if (h -> leftPtr != NULL)
			{
				h = h -> leftPtr;
			}
		}

		
	}

	x = h;

	cout << endl;
	cout << "Priority" << "\t" << "job name" << endl;
	cout << "_________________________________" << endl;

	while (x != NULL)
	{
		cout << x->priority << "\t\t" << x -> jobName << endl;
		x = x -> rightPtr;
	}
	cout << endl;

	return 0;
}

/*************************************************************************
			I RECYCLED MY FUNCTION FROM PROJECT THREE BELOW HERE!
*************************************************************************/

int biSort(entry *h, entry *m, entry *t, entry *x)	// function
{
	struct entry *temp; // temporary variable

	if (x->priority > m->priority) // if x's value is greater than m's value
	{
		if (m->rightPtr == NULL)
		{
			m->rightPtr = x;
			x->leftPtr = m;
		}

		else
		{
			temp = m->rightPtr;

			while (temp->rightPtr != NULL)
			{
				if (x->priority > temp->priority)
				{
					temp = temp->rightPtr;
				}

				else break;
			}

			if (x->priority < temp->priority)
			{
				x->rightPtr = temp;
				x->leftPtr = temp->leftPtr;
				temp->leftPtr->rightPtr = x;
				temp->leftPtr = x;
			}

			else if (x->priority < temp->priority) 
			{

			}

			else if (temp == t)
			{
				x->leftPtr = temp;
				temp->rightPtr = x;
				t = x;
			}

			else
			{
				x->leftPtr = temp->leftPtr;
				x->rightPtr = temp;
				temp->leftPtr->rightPtr = x;
				temp->leftPtr = x;
			}
		}
	}

	else if (x->priority < m->priority) // if x's value is less than m's value
	{
		if (m->leftPtr == NULL)
		{
			x->rightPtr = h;
			h->leftPtr = x;
			x = h;
		}

		else
		{
			temp = m->leftPtr;

			while (temp->leftPtr != NULL)
			{
				if (x->priority < temp->priority)
				{
					temp = temp->leftPtr;
				}

				else break;
			}

			if (x->priority > temp->priority)
			{
				x->leftPtr = temp;
				x->rightPtr = temp->rightPtr;
				temp->rightPtr->leftPtr = x;
				temp->rightPtr = x;
			}

			else if (temp == h)
			{
				x->leftPtr = NULL;
				h->leftPtr = x;
				x->rightPtr = h;
			}

			else
			{
				x->rightPtr = temp->rightPtr;
				x->leftPtr = temp;
				temp->rightPtr->leftPtr = x;
				temp->rightPtr = x;
			}
		} 
	}

	else // if x's value is equal to m's value
	{
		x->rightPtr = m->rightPtr;
		x->leftPtr = m;
		m->rightPtr = x;
	}
	return 0;
}


/*************************************************************************
			I RECYCLED MY FUNCTION FROM PROJECT THREE ABOVE HERE!
*************************************************************************/