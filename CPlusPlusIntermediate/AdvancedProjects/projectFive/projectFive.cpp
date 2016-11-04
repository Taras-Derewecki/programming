/********************************************************************
Programmers: Taras Derewecki and Izac Diaz
Date: 04/22/2016
Project Five: Turing Machines
Program Description:
	Write a Turing machine to accomplish each of the following 
	exercises. Use your project 5 executable to simulate the Turing 
	machine's behavior. You must submit a sample text file for 
	each exercise containing a sample input string for the tape, 
	and a set of state machine transitions appropriate to that 
	exercise. 

	As the Turing machine tape cannot be of infinite 
	length, it is suggested that you limit the tape to 100 
	characters.
*********************************************************************/

#include <iostream>
#include <iomanip>
#include <cctype>
#include <fstream>
#include <string>

using namespace std;

const char BLANK = 'B'; //global variable to evaluate the end instruction (B)
const char ZERO = '0'; //global variable to evaluate the state, writing, or reading (0)
const char ONE = '1'; //global variable to evaluate the state, writing, or reading (1)
const char STAR = '*'; //global variable to express a halt
const char LEFT = 'L'; //global variable to express the movement step of LEFT
const char RIGHT = 'R'; //global variable to express the movement step of RIGHT
const int MAXTAPE = 100; //maximum number of cells
const int MAXSTATES = 25; //maximum states allowed to be stored
const short STARTPOS = 40; //cell that the program starts at
const char START_STATE = ZERO; //initializes the starting state to 0

struct stateTrans //structure to allocate the different characters referring to the instructions
{
    char state; //character referencing the state
    char readchar; //character referencing the character read in
    char nextState; //character referening the next state being entered
    char writechar; //character referencing the character written
    char move; //instruction to move a certain direction
};

bool valTC(char); //boolean function that takes the character being read in, and checks if it is a valid tape character
void pTape(char[], int, int); //function that prints the tape after reading the tape's character array, position, and length
int fTape(ifstream&, char[]); //fill the tape full of the characters using the input file given and storing it in the character array
int bMach(ifstream&, stateTrans[]); //function that builds the machine based on the array of structures storing the data, and the input file
void pMach(stateTrans[], int); //function that prints the machines instructions from the structure and amount of operations
void rMach(char[], int, stateTrans[], int); //function that runs the machine using the character array of the tape,
//the length of the tape, the structures stored, and the amount of operations

int main()
{
    int posi = 0; //the position of the tape
    string infile; //string to store user input file
    
    int operCnt = 0; //declaring the count of operations and setting its value to 0
    char tp[MAXTAPE]; //character array that stores the tape of the predetermined max length
    int tapeL = 0;  //declaration of integer for the length of the tape
    
    ifstream inp; //declaration for the input file
    ofstream outp; //declaration for the output file
    cout << "Enter the tapename(in .txt format): \n"; //ask for the user's input file
    cin >> infile; //get the user's input file
    inp.open(infile); //open the user's input file
    outp.open("output.txt"); //open the predetermined output file
    if (inp.fail()) //if the input file doesn't exist or is incorrect
    {
        cout << "File doesn't exist. \n"; //inform the user it is incorrect
        return 0; //close the program
    }
    tapeL = fTape(inp, tp); //the tape length is equal to the return value of fill tape which takes the input file and the tape
    if (tapeL == 0) //if the tape length is 0 (the tape doesn't exist)
    {
        return 1; //return 1 (stating there was a malfunction of some sort)
    }
    stateTrans operations[MAXSTATES]; //declaring the structure of operation array that has a max size of the predetermined max states variable
    operCnt = bMach(inp, operations); //sets the operation count equal to the build machine function's
    
    //return value which takes the input file and the structure of operations
    pTape(tp, posi, tapeL); //function call to printing the tape that takes the tape character array, position, and tape length
    rMach(tp, tapeL, operations, operCnt); //function call to actually running the machine, takes tape's character array, tape length,
    //the operation structure, and the operation count
    inp.close(); //close the input file
    outp.close(); //close the output file
    return 0; //exit the program
}
bool valTC(char val) //boolean function to return true only if the instruction (input) is zero, one, blank (B), left, right, or a star.
{
    return val == ZERO || //return true if character value is equal to zero
    val == ONE || //return true if character value is equal to one
    val == BLANK || //return true if character value is equal to blank
    val == LEFT || //return true if character value is equal to left
    val == RIGHT || //return true if character value is equal to right
    val == STAR; //return true if character value is equal to star
}
void pTape(char tp[], int posi, int tapeL) //void function to print the tape as it is processed using the character array tape,  //the cell position, and the length
{
    if (posi == -1) //if the postion is -1
    {
        cout << "|B| "; //put the pipes around B
    }
    else //otherwise the position isn't -1
    {
        cout << " B "; //don't place pipes around B
    }
    for (int cnt = 0; cnt < tapeL; ++cnt) //for loop to run from variable count to the length of the tape
    {
        if (cnt == posi) //if the count is equal to the position
        {
            cout << '|' << tp[STARTPOS + cnt] << "| "; //output pipes around the input character array's tape at the start location plus the count
        }
        else //otherwise
        {
            cout << ' ' << tp[STARTPOS + cnt] << " "; //output the input normally if the count does not equal the position
        }
    }
    if (posi == tapeL) //if position is equal to the total length of the tape
    {
        cout << "|B| \n"; //output pipes around B
    }
    else //otherwise the current position is not equal to the tape length
    {
        cout << " B \n"; //output B without pipes
    }
}
int fTape(ifstream& inp, char tp[]) //function for filling the tape, takes the input file and the array of characters for the tape
{
    for (int cnt = 0; cnt < MAXTAPE; ++cnt) //for loop to increment from a count to the maximum tape size
    {
        tp[cnt] = 'B'; //set the entire tape to B
    }
    string tStr; //string to store the entire tape
    int tapeL = 0; //declaration for the tape length
    char val = ' '; //input character is a space to start
    getline(inp, tStr);  //get the entire line from the input file and store it in the tapeString string
    for (unsigned cnt = 0; cnt < tStr.length(); ++cnt) //for loop to increment to the length of the string
    {
        val = tStr[cnt]; //the input is equal to the string at each interval
        if (!isspace(val)) //if the input is not a space
        {
            if (valTC(val)) //if the return from the validation function is true
            {
                tp[STARTPOS + tapeL++] = val; //tape at the start position plus the tapelength is equal to input character
            }
            else //otherwise it isnt a proper character
            {
                cout << "Improper character at" <<
                tStr[tapeL] << ". Closing program. \n"; // //inform the user it isn't correct
                return 0; //exit
            }
        }
    }
    return tapeL; //return the tape length
}
int bMach(ifstream& inp, stateTrans operations[]) //function for building the machine using the input file and the structure for operations
{
    short offset = 0; //declared integer to explain the offset
    unsigned operCnt = 0; //the count of the operation
    for (char val; inp >> val; ++offset) //for loop that declares an input variable that is then gotten from the input file  //and then you increment the offset to move along the read position
    {
        switch (offset) //switch statement to go from the the different inputs and values
        {
            case 0: //case 0
                operations[operCnt] = stateTrans(); //run the structure at the first operation count location
												    //and set it equal to the declared elements in the structure
                operations[operCnt].state = val; //set the current state equal to the value that was input from the file
                break; //break the case
            case 1: //case 1
                operations[operCnt].readchar = val; //set the read character equal to the value that was input from the file
                break;//break the case
            case 2:
                operations[operCnt].nextState = val; //set the read character equal to the next state that was input from the file
                break;//break the case
            case 3:
                operations[operCnt].writechar = val; //set the read character equal to the written character that was input from the file
                break;//break the case
            case 4:
                operations[operCnt].move = val; //set the read character equal to the movement instruction that was input from the file
                ++operCnt; //increment the count of the operation being run
                offset = -1; //set the offset back to -1
                break;//break the case
        }
    }
    return operCnt; //return the total number of operations run
}
void pMach(stateTrans operations[], int operCnt) //function that prints the machine using the operation structure array and the count of operations
{
    cout << left; //left align the output
    cout << setw(10) << "State" << setw(10) << "Read" << setw(10) << //header for the state and the read inputs
    "New State" << setw(10) << "Write" << setw(10) << "Move" << endl; //header for the new state, write, and move inputs
    for (int cnt = 0; cnt < operCnt; ++cnt) //for loop to run from zero to the total count operation
    {
        cout << left; //left align the output
        cout << setw(10) << operations[cnt].state << setw(10) <<
        operations[cnt].readchar << setw(10) << //output the instructions
        operations[cnt].nextState << setw(10) <<
        operations[cnt].writechar << setw(10) <<
        operations[cnt].move << "\n"; //output the instructions
    }
    cout << "\n"; //output new line for formatting
}
void rMach(char tp[], int tapeL, stateTrans operations[], int operCnt) //function to the run the machine using character array tape, tape length,  //the structure operations, and the operation count
{
    int mOffset = 0; //the movement offset is declared and set to 0
    bool h = false; //declare boolean value and set it to false for halt
    char st; //declare state character and set to ' '
    st = START_STATE; //set state equal to the starting state
    string mString; //declared movement string  //declare tape character and set it to null
    cout << "Tape starts at cell " << STARTPOS << " length = " << tapeL << " and tape = \n"; //explain the output to the user at the cell position // and the length
    cout << "\t"; //tab over for formatting
    //pTape(tp, cnt, tapeL); //print the table at each iteration
    cout << "\n"; //output a new line for spacing
    pMach(operations, operCnt); //print the machine tape that is output
    for (int tapePos = 0; !h; tapePos += mOffset) //for loop to adjust tape position
    {
        char tChar = tp[STARTPOS + tapePos]; //the tape char is set equal to the tape at the starting position plus the tape position
        pTape(tp, tapePos, tapeL); //call the print tape function passing the tape, the tape position, and the tape length
        bool m = false; //declare a boolean value for if it is matched and set it to false to start
        for (int cnt = 0; !m && cnt < operCnt; ++cnt) //for loop to run from count to the total count if they are not matched
        {
            stateTrans& oper = operations[cnt]; //declare a new structure to reference and set it equal to the operations at the current count
            if (oper.state == st && oper.readchar == tChar) //if the new structure's state is equal to the state and  //the new structure's read character is equal to the tape character
            {
                m = true; //set matched equal to true
                tp[STARTPOS + tapePos] = oper.writechar; //tape at the state position plus the tape position is equal to the written character
                st = oper.nextState; //state is equal to the next state in the structure
                if (oper.move == LEFT) //if the operation's movement is left
                {
                    mOffset = -1; //movement offset is equal to -1
                    mString = "left"; //movement string is equal to left
                }
                else //otherwise it is right
                {
                    mOffset = 1; //movement offset is equal to 1
                    mString = "right"; //movement string is equal to right
                }
                cout << "Cell " << STARTPOS + tapePos << ": " << "read " << tChar << ", wrote "  //output a heading for the cell, read, write, 
                << oper.writechar << "\n" << "Run state " << st << ", move " << mString << "\n\n"; //run state and movement
            }
        }
        if (!m) //if matched is not true
        {
            h = true; //halt the tape
            cout << "State stops in " << st << endl; //output the state that the program stops in
        }
    }
}
