/*******************************************************************************
Programmer: Taras Derewecki
Date: 04/09/2016
Assignment Twelve: Matrices

Program Description:
    program, assigment12.cpp, which reads an adjacency matrix, M, 
    (which will be square) from a file, and computes powers of M: Mp, 
    where p varies from 1 to 5. Leave the output in a file; prompt the user 
    for the name of the output file or inform the user of the name of the 
    output file before exiting.
*******************************************************************************/
#include <iostream>
#include <cmath>
#include <iomanip>
#include <string>
#include <fstream>

using namespace std;

int main()
{ 
    int row = 0, column = 0, g = 0; // row, column, and counter control
    double h = 0;

    double matrix[ 5 ][ 5 ];       // matrix
    double matrixTwo[ 5 ][ 5 ];    // matrix
    double outing[ 5 ][ 5 ];       // matrix

    string userTextFile;
    string userOutput;

    for ( int j = 0; j < 5; j++ )  
    {
        for ( int i = 0; i < 5; i++ )
        {
            matrix[j][i] = 0;
            matrixTwo[j][i] = 0;
            outing[j][i] = 0;
        }
    }
    
 
    cout << "Enter your first matrix file: "; // ask for matrix file
    cin >> userTextFile;

    cout << "Output File? "; // ask for file for answer to be outputted to
    cin >> userOutput;

    ifstream userTextfile( userTextFile ); // input file
    ofstream outfile( userOutput ); // output file

    //read in matrix dimension
    userTextfile >> row;
    userTextfile >> column;

    //read in matrix values into the arrays
    while ( !userTextfile.eof() )
    {
        for ( int i = 0; i < row; i++ )
        {
            for ( int j = 0; j < column; j++ )
            {
                if ( userTextfile >> g ) // gg
                {
                    matrix[ j ][ i ] = g;
                    matrixTwo[ j ][ i ] = g;
                }
            }
        }
    }
    
    userTextfile.close();

    for ( int l = 1; l <= 5; l++ ) // outputs powers
    {
        outfile << "Matrices power: " << l << endl;
        
        if ( l == 1 )
        
        {
            
            for (int j = 0; j < row; j++)
        
            {
            
                for (int i = 0; i < column; i++)
                
                {
                
                    outfile << setw(4) << matrix[j][i];
                }
                
                outfile << endl;
            }
            
        }
        
        else
        {
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j < column; j++)
                {
                    for (int k = 0; k < column; k++)
                    {
                        h += matrixTwo[j][k] * matrix[k][i];
                        outing[j][i] = h;
                    }
                    
                    outfile << setw(4) << outing[j][i];
                    h = 0;
                }
                outfile << endl;
            }
            
            for (int j = 0; j < row; j++)
            {
                for (int i = 0; i < column; i++)
                {
                    matrixTwo[j][i] = outing[j][i];
                }
            }
            
            outfile << endl;
        }
        
        outfile << endl;
    }
    
    outfile.close();
    cout << "Output:  " << userOutput << endl;
    
   
    return 0;
}
