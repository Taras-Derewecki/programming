/*********************************************************************************
Programmer: Taras Derewecki
Date: 03/12/2015
Project Three: Modified Bisort

Program Description:
   This program will develop a highly modularized C++ program that will sort a set 
   of numbers using a modified binary sort algorithm while maintaining a doubly 
   linked sorted list. Use pointers to build the linked list. Give the user the 
   option to view every step of the sorting process (this verbose option will 
   print each step to the user’s monitor). Read the input from a file specified 
   by the user. Leave the sorted output in a file, and inform the user the name of 
   the file before exiting. Do not remove any duplicates found. A doubly linked 
   list has pointers in both directions.
*********************************************************************************/

#include <fstream>
#include <iostream>
#include <string>

using namespace std;

   struct entry //structure
   {        
   	int priority;           // contains priority essence of the integer     
   	struct entry *leftPtr;  // contains left pointer essence        
   	struct entry *rightPtr; // contains right pointer essence
   };

   struct entry *getEntry() // structure
   {
      static struct entry array[ 100 ]; // array of 100 elements
      static int nextEntry = 0;

      if ( nextEntry >= 100 ) return NULL;
      array[ nextEntry ].priority = 0;
      array[ nextEntry ].leftPtr = NULL;
      array[ nextEntry ].rightPtr = NULL;
      nextEntry++;
      return &array[ nextEntry - 1 ];
   }

   int biSort( struct entry *, struct entry *, struct entry *, struct entry * ); // prototype

   int main()
   {
      ifstream inputFile;
      ofstream outputFile("sortedfile.txt", ios::out);
      string file;
      cout << "Please enter a filename: ";
      cin >> file;
      inputFile.open(file);
      struct entry *h, *t, *m; // head (of the list), tail (of the list), middle (of the list) pointers from the structure
      struct entry *x = new struct entry; // current input priority, essentially an aux
      h = t = m = NULL;

      x -> priority = 1;


      while ( x -> priority > 0 )
      {
         x = getEntry();
         inputFile >> x -> priority;

         if ( x -> priority <= 0) 
            { 
               break;
            }

         if ( h == NULL)
         {
            h = m = t = x;
         }

         else // when the head pointer is not pointing to null
         {
            biSort( h, m, t, x );

            if ( t -> rightPtr != NULL )
            {
               t = t -> rightPtr;
            }

            else if ( h -> leftPtr != NULL )
            {
               h = h -> leftPtr;
            }

         }
      }



      x = h;
		cout << endl;


         while(x != NULL)
         {
            outputFile << x -> priority << " ";
            x = x -> rightPtr;
         }

         outputFile << endl;

      cout << "File Name: sortedFile.txt" << endl;
      outputFile.close();
      inputFile.close();
   	return 0;
   }




   int biSort( entry *h, entry *m, entry *t, entry *x ) // function call from prototype above main
   {
      struct entry *temp; // temporary variable, essentially an aux pointer...

      if ( x -> priority > m -> priority ) // when x's value is greater than m's value
      {
         if( m -> rightPtr == NULL )
            {
               m -> rightPtr = x;
               x -> leftPtr = m;
            }

         else
         {
            
            temp = m -> rightPtr;

            while( temp -> rightPtr != NULL )
            {
               if ( x -> priority > temp -> priority )
               {
                  temp = temp -> rightPtr;
               }

               else break;
            }

            if ( x -> priority < temp -> priority )
            {
               x -> rightPtr = temp;
               x -> leftPtr = temp -> leftPtr;
               temp -> leftPtr -> rightPtr = x;
               temp -> leftPtr = x;
            }

            else if ( x -> priority < temp -> priority )
            {
               
            }

            else if ( temp == t )
            {
               x -> leftPtr = temp;
               temp -> rightPtr = x;
               t = x; 
            }

            else
            {
               x -> leftPtr = temp -> leftPtr;
               x -> rightPtr = temp;
               temp -> leftPtr -> rightPtr = x;
               temp -> leftPtr = x;
            }
         }
      }

   else if ( x -> priority < m -> priority ) // when x's value is less than m's value
   {
         if( m -> leftPtr == NULL )
         {
            x -> rightPtr = h;
            h -> leftPtr = x;
			   x = h;
         }

         else
         {
            temp = m -> leftPtr;

            while( temp -> leftPtr != NULL )
            {
               if ( x -> priority < temp -> priority )
               {
                  temp = temp -> leftPtr;
               }

               else break; 
            }

            if ( x -> priority > temp -> priority )
            {
               x -> leftPtr = temp;
               x -> rightPtr = temp -> rightPtr;
               temp -> rightPtr -> leftPtr = x;
               temp -> rightPtr = x;
            }

            else if (temp == h)
            {
               x -> leftPtr = NULL;
               h -> leftPtr = x; 
               x -> rightPtr = h;
            }

            else
            {
               x -> rightPtr = temp -> rightPtr;
               x -> leftPtr = temp;
               temp -> rightPtr -> leftPtr = x;
               temp -> rightPtr = x;
            }
         } 
   }

   else // when x's value is equal to m's value
   {
      x -> rightPtr = m -> rightPtr;
      x -> leftPtr = m;
      m -> rightPtr = x;
   }

   return 0;
}


      




