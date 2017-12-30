/*****************************************************************************************
Programmer: Taras Derewecki
Date: 04/25/2016
Project Four: Binary Tree Sort
Program  Description:
	Develop a C++ program that will recursively alphabetize a set of strings in a 
	user-specified file using the tree sort algorithm while maintaining a balanced 
	binary tree at all times. 
*****************************************************************************************/
#include <iostream>
#include <string>
#include <fstream>
using namespace std;

// Structure for tree
struct Node
{
	string name;//string of key will be taken from file
	struct Node *lC, *rC; // left and right children
	int height, balance, multiplicity;// height, balance, multiplicity
};

struct Node* getNode( string realName )// function to the struct Node pointing to getNode
{
	struct Node* node = new Node;// dynamic allocation of a new node with its' attributes
	
	node -> name = realName;
	node -> lC = NULL;
	node -> rC = NULL;
	node -> balance = 0;
	node -> multiplicity = 1;
	node -> height = 1;
	return node;
}

int height( struct Node *root )// Finds height
{
 if ( root == NULL ) return 0;

	return root -> height;
}

int total( int x, int y ) // Finds total
{
	return( x > y ) ? x : y; // bitwise operators
}

struct Node *shiftRight( struct Node *root ) // Shifts to the right 
{
	struct Node *t1 = root -> lC;
	struct Node *t2 = t1 -> rC;
	
	// Shifting occurs
	t1 -> rC = root;
	root -> lC = t2;
	
	// height update
	root -> height = total( height( root -> lC ), height( root -> rC ) ) + 1;
	t1 -> height = total( height( t1 -> lC ), height( t1 -> rC ) ) + 1;

	return t1;
}

struct Node *shiftLeft( struct Node *root ) // Shifts to the left
{
	struct Node *t1 = root -> rC;
	struct Node *t2 = t1 -> lC;

	// Shifting occurs
	t1 -> lC = root;
	root -> rC = t2;

	// Height update
	root -> height = total( height( root -> lC ), height( root -> rC ) ) + 1;
	t1 -> height = total( height( t1 -> lC ), height( t1 -> rC ) ) + 1;

	return t1;
}


int balance( struct Node *root ) // Get Balance
{
	if ( root == NULL) return 0;

	return height( root -> lC ) - height( root -> rC );
}

struct Node* addNode( struct Node* root, string realName ) // Adds nodes
{
	
	if ( root == NULL ) return( getNode( realName ) );

	if ( realName < root -> name ) root -> lC = addNode( root -> lC, realName );

	else if ( realName > root -> name )
		root -> rC = addNode( root -> rC, realName );

	else
	{
		root -> multiplicity++;
		return root;
	}

	
	root -> height = total( height( root -> lC ), height( root -> rC ) ) + 1;
	int b = balance( root );

/*******************************************************************
						FOUR IMBALANCES
*******************************************************************/

	// L - L Imbalance
	if ( b > 1 && realName < ( root -> lC ) -> name ) return shiftRight( root );

	// R - R Imbalance
	if ( b < -1 && realName > ( root -> rC ) -> name ) return shiftLeft( root );

	// L - R Imbalance
	if ( b > 1 && realName > ( root -> lC ) -> name )
	{
		root -> lC = shiftLeft( root -> lC );
		return shiftRight( root );
	}

	// R - L Imbalance
	if ( b < -1 && realName < ( root -> rC ) -> name )
		{
			root -> rC = shiftRight( root -> rC );
			return shiftLeft( root );
		}

	root -> balance = balance( root );
	
	return root;
}

void balanceSearch( Node *root ) // Finds Balance
{
 if ( root != NULL )
	{
		balanceSearch( root -> lC );
		root -> balance = balance( root );
		balanceSearch( root -> rC );
	}
}

void spacing( int c ) // tabular formatting
{
	for ( int i = 0; i < (12 - c); i++ ) cout << " ";
}

void printInOrder( struct Node *root ) // In-Order Notation
{
	if ( root != NULL )
	{
		printInOrder( root -> lC ); 
		cout << "\n  " << root -> name;
		spacing( root -> name.length() );

		string left, right;

		if ( root -> lC == NULL ) left = "NULL";

		else left = ( root -> lC ) -> name;
			
		if ( root -> rC == NULL ) right = "NULL";

		else right = ( root -> rC ) -> name;

		cout << left;
		spacing( left.length() );
		cout << right;
		spacing( right.length() );
		cout << root -> height << " \t " << root -> balance << " \t     " << root -> multiplicity;
		printInOrder( root -> rC );
	}
}


int main()
{
	struct Node *tree = NULL;
	string input;     // user input
	ifstream infile; // user-specified file

	cout << "Enter The Requested File: "; cin >> input;

	infile.open( input.c_str(), ios :: in );

	while ( !infile.eof() )
	{
		infile >> input;
		tree = addNode( tree, input );
	}

	infile.close();
	balanceSearch( tree );
	cout << "  Node        Left        Right       Height     Balance     Multiplicity\n";
	printInOrder( tree );
	cout << "\n" ;

	return 0;
}
