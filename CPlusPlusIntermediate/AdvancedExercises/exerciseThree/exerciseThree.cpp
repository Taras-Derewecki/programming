/**********************************************************************************
Programmer: Taras Derewecki
Date: 03/15/2016
Exercise Three: Finite State Machine
Program Description:

Given a list of strings separated by commas (NO spaces allowed), and terminated by 
a period. You are to write a program that identifies valid C++ identifiers and 
non-negative integers.
**********************************************************************************/

#include <iostream>
#include <cstring>
#include <string>

using namespace std;

bool validNumber( char ); // prototype
bool validLetter( char ); // prototype

int main() 
{
    
    char stringValue[ 100 ]; // array for string of characters or numbers
    char stringGarbage[ 100 ]; // array for string between the characters
    int invalid; // checks for an error
    
    cout << "Enter a String of Your Choosing Without Spaces: ";
    cin.getline( stringValue, 100 ); // accepts normal character or integer values of 100 elements
    
    int a = 0; // counter variable
    int b = 0; // counter varibale
    int g = 0; // counter variable
    
    
    
    while ( stringValue[ a ] != '.' )
    {
        g = 0;

        while ( stringValue[ a ] != ',') 
        {
            stringGarbage[ g ] = stringValue[ a ];
            a++;
            g++;
        }
        
        
        stringGarbage[ g ] = '\0';
        b = a;
        a = 0;

        if ( validLetter ( stringGarbage[ a ] ) ) 
        {
            for ( int c = 0; c < g; c++ ) 
            {
                if ( ! ( validLetter( stringGarbage[ c ] ) ) && !( validLetter ( stringGarbage[ c ] ) ) && !( stringGarbage[ c ] == '_' ) ) 
                {
                    invalid = c;
                    cout << "\nThe Substring is Invalid!: ";

                    for ( int k = invalid; k < g; k++ ) 
                    {
                        cout << stringValue[ k ];
                    }

                    cout << '\n' << endl;
                    return 0;
                }
                
            }
            
        }
        
        else if ( validNumber( stringGarbage[ a ] ) ) 
        {
            for ( int k = 0; k < g; k++ ) 
            {
                if ( !validNumber( stringGarbage[ k ] ) ) 
                {
                    invalid = k;
                    cout << "\nThe Substring is Invalid!: ";

                    for ( int d = invalid; d < g; d++ ) 
                    {
                        cout << stringValue[ d ];
                    }

                    cout << '\n' << endl;
                    return 0;
                }

            }
            
        }

        else 
        {
            invalid = 0;
            cout << "\nThe Substring is Invalid!: ";

            for ( int m = invalid; m < g; m++ ) 
            {
                cout << stringValue[ m ];
            }

            cout << '\n' << endl;
            return 0;
        }
        
        stringGarbage[ 0 ] = '\0';
        a = b + 1;
    }
    
    cout << "\nThe String is Valid!: ";

    for ( int d = 0; d < a; d++ )
    {
        cout << stringValue[ d ];
    }
    
    cout << '\n' << endl;
    return 0;
}

bool validNumber ( char input ) 
{
    switch ( input )
    {
        case '0':
        case '1':
        case '2':
        case '3':
        case '4':
        case '5':
        case '6':
        case '7':
        case '8':
        case '9':

            return true;
            break;


        default:
            return false;
            break;
    }
}

bool validLetter ( char anotherInput ) 
{
    switch ( anotherInput )
    {
        case 'A':
        case 'B':
        case 'C':
        case 'D':
        case 'E':
        case 'F':
        case 'G':
        case 'H':
        case 'I':
        case 'J':
        case 'K':
        case 'L':
        case 'M':
        case 'N':
        case 'O':
        case 'P':
        case 'Q':
        case 'R':
        case 'S':
        case 'T':
        case 'U':
        case 'V':
        case 'W':
        case 'X':
        case 'Y':
        case 'Z':
        case 'a':
        case 'b':
        case 'c':
        case 'd':
        case 'e':
        case 'f':
        case 'g':
        case 'h':
        case 'i':
        case 'j':
        case 'k':
        case 'l':
        case 'm':
        case 'n':
        case 'o':
        case 'p':
        case 'q':
        case 'r':
        case 's':
        case 't':
        case 'u':
        case 'v':
        case 'w':
        case 'x':
        case 'y':
        case 'z':

            return true;
            break;


        default:
            return false;
            break;
    }
}