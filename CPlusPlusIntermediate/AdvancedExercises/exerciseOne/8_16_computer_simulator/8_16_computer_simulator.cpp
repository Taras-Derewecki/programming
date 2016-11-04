#include <iostream>
#include <iomanip>
#include <fstream>
#include <string>
using namespace std;

/*******************************************************************************

Programmer: Taras Derewecki
Date: 01/25/2016
Exercise One: Machine Language Simulation

(Machine language simulation) in the text 9th edition, problems 8.15 & 8.16. 
This should be a single program; do not implement parts a), b), & c) in the 
first exercise until you have done the second exercise. That is, do the second 
exercise first and test it using the sample programs given in the text. 
Then proceed to write and test the programs specified in a), b), and c) 
in the first exercise. 

This exercise is your introduction to machine-language 
programming and simulates the entry of programs into early computers 
before assembly language was even invented). You do not have to follow the 
instructions exactly as to input (see middle p. 373 in the 9th edition) or 
output (bottom of page 374 in the 9th edition). Here is an example run: 
Welcome to Simpletron! Please enter your program one instruction 
(or data word) at a time. I will type the location number and a question mark (?).
You then type the word for that location. 
Type the sentinel -99999 to stop entering your program 
0 ? 1007
1 ? 1008
2 ? 2007
3 ? 3008
4 ? 2109
5 ? 1109
6 ? 4300 
7 ? 0
8 ? 0
9 ? 0
10 ? -99999 
Program loading completed Program execution begins
 ? 4 ? -5 -1 
Execution halted normally
REGISTERS: accumulator  -1 
instructionCounter   6
instructionRegister  4300
opcode  43
operand 00
MEMORY: 0          1          2          3         4          5          6          7          8         9
	   1007       1008       2007      3008      2109        1109      4300         4         -5        -1  
	   10           0          0         0         0           0         0          0          0         0 
       0            90         0         0         0           0         0          0          0         0
       0         0
*******************************************************************************/

	/* INPUT/OUTPUT OPS */
	const int READ = 10;   		// Read a word from the keyboard into a specific location in memory
	const int WRITE = 11;  		// Write a word from a specific location from a specific location in memory to the screen.
	/* INPUT/OUTPUT OPS */

	/* LOAD AND STORE OPS */
	const int LOAD = 20;   		// Load a word from a specific location in memory into the accumulator.
	const int STORE = 21;  		// Store a word from the accumulator into a specific location in memory.
	/* LOAD AND STORE OPS */

	/* ARITHMETIC OPS */
	const int ADD = 30;    		// Add a word from a specific location in memory to the word in the accumulator (leave result in accumulator).
	const int SUBTRACT = 31; 	// Subtract a word from a specific location in memory from the word in the accumulator (leave result in accumulator).
	const int DIVIDE = 32; 		// Divide a word from a specific location in memory into the word in the accumulator (leave result in accumulator).
	const int MULTIPLY = 33; 	// Multiply a word from a specific location in memory into the word in the accumulator (leave result in accumulator).
	/* ARITHMETIC OPS */

	/* TRANSFER-OF-CONTROL OPS */
	const int BRANCH = 40; 		// Branch to a specific location in memory.
	const int BRANCHNEG = 41; 	// Branch to a specific location in memory if the accumulator is negative.
	const int BRANCHZERO = 42;  // Branch to a specific location in memory if the accumulator is zero. 
	const int HALT = 43; 		// Halt- The program has completed its task.
	/* TRANSFER-OF-CONTROL OPS */

int main()
{
	int memory[100] = {0}; 		// Array of 100 elements set to 0

	int instructionCounter = 0, instructionRegister = 0, operand = 0, operationCode = 0, accumulator = 0;

	string fileName;   // string for user to enter file

	ifstream input;	   // file variable meant to read in things.
	int n = 0; 		   // counter variable for array of memory to keep incrementing to 99 elements
	int userInput = 0; // keeps track of user inputs
	int temporaryInput;// temporary variable for user inputs to be controlled in a while loop
	int value = 0;



	cout << "Welcome to Simpletron!" << endl << endl <<
	"Please enter your program one instruction" << endl <<
	"(or data word) at a time. I will type the" << endl <<
	"location number and a question mark (?)." << endl <<
	"You then type the word for that location." << endl <<
	"Type the sentinel -99999 to stop entering your program." << endl;

/*
	cout << "Enter filename: ";
	cin >> fileName;
	input.open( fileName.c_str() );
	input >> value;
	cout << "outside read "<< input << endl;
	//accumulator += memory[ operand ];
	//cout << "Hi Taras, the error isn't here" << endl; (SUCCESS)
	

	//instructionCounter = 0;

		while( !input.eof() )
	{
		//cout << "Hi Taras, the error isn't here" << endl; (SUCCESS)

		//value = 0;
		input >> value;
		cout << "Top read " << input << endl;
		//cout << "Hi Taras, the error isn't here" << endl; (SUCCESS)


		while( value != -99999 )
		{
			//value -= 1;
			//cout << "Hi Taras, the error isn't here" << endl; (SUCCESS x100)
			memory[n] = value;
			//value++;
			//cout << "Hi Taras, the error isn't here" << endl; (SUCCESS x100)
			n++;
			//value++;
			//cout << "Hi Taras, the error isn't here" << endl; (SUCCESS x100)
			input >> value;
			cout << "inside read " << input << endl;

			//value++;

		}

		//cout << "Hi Taras, the error isn't here" << endl; (FAILED) - Successful


		//input >> value;
		//value++;
	}
	*/
	//cout << "Hi Taras, the error isn't here" << endl; (FAILED) - Successful

        cout << "Enter filename: ";
        cin >> fileName;
        input.open( fileName.c_str() );
        input >> value;
        memory[n] = value;
        n++;
        //cout << "outside read " << value << endl;

        while( value != -99999 )
        {
                input >> value;

                if( value == -99999 )
                {
                	break;
                }

                memory[n] = value;
                n++;  
        }
        
        /*

        cout << "n = " << n << endl;
        for (int i = 0; i < n; ++i)
        {
                cout << memory[i] << endl;
        } 

		*/

	while( operationCode != HALT )
	{

		instructionRegister = memory[instructionCounter];

		operationCode = instructionRegister / 100; // Used in order to gain the first 2 digis of the 4 digit number

		operand = instructionRegister % 100; // used in order to gain the last 2 digits of the 4 digit number

		//instructionCounter = operand;
		//cout << operationCode << " " << operand << endl;

		//cout << "Register: " << instructionRegister << endl;
		//cout << "OP CODE: " << operationCode << endl;
		//cout << " OPERAND: " << operand << endl;

		switch (operationCode)
		{
			case READ:
				cout << "? ";
				//cout << "Hi Taras, the error isn't here" << endl; (SUCCESS)
				cin >> memory[ operand ];
				instructionCounter++;
				break;
				

			case WRITE:
				cout << "Result: " << memory[operand] << endl;
				//cout << "Hi Taras, the error isn't here" << endl; (FAILED)
				instructionCounter++;
				break;

			case LOAD:
				accumulator = memory[operand];
				instructionCounter++;
				break;

			case STORE:
				memory[operand] = accumulator;
				instructionCounter++;
				break;

			case ADD:
				accumulator += memory[operand];
				instructionCounter++;
				break;

			case SUBTRACT:
				accumulator -= memory[operand];
				instructionCounter++;
				break;

			case DIVIDE:
				if (memory[ operand ] == 0)
				{
					cout << "ERROR CODE 0504: Divison by zero is not permitted!";
					return 1;
				}

				accumulator /= memory[operand];
				instructionCounter++;
				break;

			case MULTIPLY:
				accumulator *= memory[operand];
				instructionCounter++;
				break;

			case BRANCH:
				instructionCounter = operand;
				break;

			case BRANCHNEG:
				if (accumulator < 0)
				{
					instructionCounter = operand;
				}

				else
				{
					instructionCounter++;
				}
				break;

			case BRANCHZERO:
				if (accumulator == 0)
				{
					instructionCounter = operand;
				}

				else
				{
					instructionCounter++;
				}

				break;

			case HALT:

				cout << "Program Halt initiated: Simpletron execution terminated." <<
					endl;
				//cout << setfill('0') << internal;
				cout << "REGISTERS: " << endl;
				cout << "accumulator: " << accumulator << endl;
				cout << "instructionCounter: " << instructionCounter << endl;
				cout << "instructionRegister: " << instructionRegister << endl;
				cout << "operationCode: " << operationCode << endl;
				cout << "operand: " << operand << endl << endl;

				cout << "MEMORY: " << endl;

				for (int i = 0; i < 10; ++i)
				{
					cout << setw(7) << i;
				}

				for (int j = 0; j < 100; ++j)
				{
					if (j %10 == 0)
					{
						cout << endl << setw(7) << j;
					
					}
					cout << setw(7) << memory[j];
				}
				cout << endl;

				if (accumulator < memory[ operand ])
				{
					accumulator = memory[ operand ];
					break;
				}
				//break;

			default:
				cout << "Illegal Operation Code" << endl;
				return 1;
				
		}

	}



	input.close();
	return 0;
}