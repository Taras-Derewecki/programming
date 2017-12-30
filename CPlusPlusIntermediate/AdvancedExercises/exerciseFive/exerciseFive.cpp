/*********************************************************************
Programmer: Taras Derewecki
Date: 04/09/2016
Exercise Five: Trees

Program Description:
    This program creates a tree for the following string data 
    (stored in an input file – sample shown below), where: 
    1) the leftmost string goes into a node; 
    2) the middle string goes into the node’s left child; 
    3) the rightmost string goes into the node’s right child.

    However, the string “null” in the middle position means the node 
    has no left child, and the string “null” in the rightmost 
    position means the node has no right child.
********************************************************************/

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

// Structure of Node
struct Node
{
    struct Node* r;
    string word;
    struct Node* l;
};

// function from the node to a getEntry pointer
struct Node *getEntry()
{
    struct Node *newPtr;

    newPtr = new struct Node;
    newPtr -> r = NULL;
    newPtr -> word = "";
    newPtr -> l = NULL;

    return newPtr;
};


/*******************************************************************
                            PROTOTYPES
*******************************************************************/

void fn( struct Node *yui, string x, string y, string z );

void anotherFN( struct Node *z );

/*******************************************************************
                            PROTOTYPES
*******************************************************************/ 

int main()
{
    struct Node *h;
    struct Node *g;

    string fileName;    // user-specified input file
    ifstream infile; // input file

    cout << "File Name? ";
    cin >> fileName;

    infile.open( fileName ); // open input file
    
    string x, y, z;

    infile >> x;
    infile >> y;
    infile >> z;
    
    g = getEntry();
    g -> word = x;
    
    if ( y == "null" )
    {
        g -> r = NULL;
    }
    else
    {
        h = getEntry();
        h -> word = y;
        g -> r = h;
    }
    
    if ( z == "null" ) g -> l = NULL;

    else
    {
        h  = getEntry();
        h -> word = z;
        g -> l = h;
    }
    
    while ( !infile.eof() )
    {
        infile >> x;
        infile >> y;
        infile >> z;

        h  = getEntry();
        h -> word = x;

        fn( g, x, y, z );
    }
    
    anotherFN( g );
    infile.close();
    return 0;
}
/*******************************************************************
                            FUNCTIONS
*******************************************************************/

// Function recursively searches for the matching word x then adds
//  y and z... to x!
void fn( struct Node *yui, string x, string y, string z )
{
    if ( yui -> word == x )
    {
        if ( y == "null" ) yui -> r = NULL;

        else
        {
            yui -> r = getEntry();
            yui -> r -> word = y;
        }
        
        if ( z == "null" ) yui -> l = NULL;

        else
        {
            yui -> l = getEntry();

            yui -> l -> word = z;
        }
    }

    else
    {
        if ( yui -> r != NULL ) fn( yui -> r, x, y, z );
            
        if ( yui -> l != NULL) fn( yui -> l, x, y, z );     
    }
}

//recursive function that prints put in post order
void anotherFN( struct Node *z )
{
    struct Node *move = z;
    
    if ( move -> r != NULL ) anotherFN( move -> r );
    
    if ( move -> l != NULL ) anotherFN( move -> l );
        
    cout << move -> word << "\t";
}

/*******************************************************************
                            FUNCTIONS
*******************************************************************/