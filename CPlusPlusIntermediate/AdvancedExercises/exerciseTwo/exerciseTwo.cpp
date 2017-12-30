/********************************************************************************
Programmer: Taras Derewecki
Date: 02/23/2016
Exercise 2: File Matching

Program Description:

This program will match file accounts together and add values that need to be
added assuming files match with one another.
********************************************************************************/

#include <iostream>
#include <cstdlib>  
#include <fstream> 
#include <iomanip> 
#include <string>

using namespace std;

void output(ofstream&, int, const char *, const char *, double);			//prototype  

int main() 
{
	 
	int ma, ta;							    								//"ma" for master account, "ta" for trancation account, and they store account numbers to the files of master and transaction files
	double mb, tb;															// stores balances
	char masterFN[20], masterLN[20];										// stores first and last names for masters
	ifstream oldMasterAcct("oldMasterAcct.txt", ios::in | ios::binary );	// input files tream declaration
	ifstream transAcct("transAcct.txt", ios::in | ios::binary );			// input file stream declaration
	ofstream newMasterAcct("newMasterAcct.txt", ios::out | ios::binary );	// output file stream declaration
	
	
	if ( !oldMasterAcct )
	{ 
		cerr << "ERROR 0504: Failure to execute oldMasterAcct.txt " << endl;   
		exit(1); 
	}  

	if (!transAcct)
	{ 
		cerr << "ERROR 1995: Failiure to execute transAcct.txt" << endl;   
		exit(1); 
	}

	if (!newMasterAcct) 
	{ 
		cerr << "ERROR 0824: Failure to execute newMasterAcct.txt" << endl;   
		exit(1); 
	}

	transAcct >> ta >> tb;

	while ( !transAcct.eof() ) 
	{

		oldMasterAcct >> ma >> masterFN >> masterLN >> mb;

		while ( ma < ta && !oldMasterAcct.eof() ) 
		{
			output(newMasterAcct, ma, masterFN, masterLN, mb);
			oldMasterAcct >> ma >> masterFN >> masterLN >> mb;
		}

		if (ma > ta) 
		{
			cout << "ERROR 0226: File Mis-Match: " << ta << endl;
			transAcct >> ta >> tb;
		}

		if (ma == ta) 
		{
			mb += tb;    
			output(newMasterAcct, ma, masterFN, masterLN, mb);   
		}  

		transAcct >> ta >> tb;
	}

	cout << "The name of your output file is 'newMasterAcct.txt' " << endl;
	
	transAcct.close();  
	newMasterAcct.close();  
	oldMasterAcct.close();  

	return 0;

	}

void output(ofstream &reference, int my_account, const char *my_first_name, const char *my_last_name, double my_balance) // definiton 
{
	cout.setf( ios::fixed | ios::showpoint ); 

	reference.setf( ios::fixed | ios::showpoint ); 

	reference << my_account << ' ' << my_first_name << ' ' << my_last_name << 
	' ' << setprecision(2) << my_balance << endl; 

	cout << my_account << ' ' << my_first_name << ' ' << my_last_name << 
	' ' << setprecision(2) << my_balance << endl;
}