/******************************************************************************
Programmer: Taras Derewecki
Date: 02/19/2016
Project Two: Permutations

Project Description:

This modularized C++ program will recursively generate all the permutations of
any given n distinct objects (in this case use characters). 
******************************************************************************/

#include <iostream>
#include <cstring>

using namespace std;

void swap( char&, char& );
void permute( string, int, int );


int main()
{
    
    
    string str;        // stores characters into a string
    int input;         // stores number of characters
    int x = 0, y = 0;  // removes spaces
    
    cout<< "How many characters do you wish to permute: "; cin >> input;
    
    cin.ignore();
    
    cout << endl << "Enter "<< input <<" character(s): ";
    
    getline(cin,str);
    
   
    
    while( str[x] != '\0' )
    {
        if( str[x] == ' ' )
        { 
            x++;   
        }
        
        else
        {
            str[y] = str[x];
            x++;
            y++;
        }
        
    }
    
    str.erase( input,str.length() );
    
    permute( str, 0, input );
    
    cout << endl;

    return 0;
}

void swap( char& x, char& y ) // swap function accepts two char-type variables as parameters and switches their spots

{
    
    char temp;  // temporary variable to create the swap function
    
    temp = x;
    
    x = y;
    
    y = temp;
    
}

void permute( string str, int x, int input ) // accepts a string, two integers, and returns the permutations of them

{
    
    int y; // counter-controlled variable
    
    static int z = 1;
    
    if ( x == input )
    
        cout << endl << "Permutations " << z++ << " : " << str << "\t";
    
    else
        
    {
        
        for ( y = x; y < input; y++ )
        {
            
            swap( str[x],str[y] );
            
            permute( str, x + 1, input );
            
            swap( str[x], str[y] );
            
        }
        
    }
    
}
