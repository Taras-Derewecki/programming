/*****************************************************************************************************
Programmer: Taras Derewecki
Date: 11/10/2015
Project Three: Sorter

This program uses the algorithm of bubble sorting
*****************************************************************************************************/

#include <iostream>
#include <fstream>
#include <string>
#include <iomanip>
#include <cstdlib>
#include <vector>
using namespace std;

void sortBubbles(int arr[]);

int main(){
    string file; // input
    const int a = 100, b = 10, c = 10; // assigned constant integers
    int count = 0, count1 = 0, d = 0, swap = 0; // counter control variables
    int clam[a] = { 0 }, ray[b][c] = { 0 }; // arrays
    cout << "Please enter the name of the file: " << endl;
    cin >> file;
    ifstream data; // input that will go here in this file
    data.open(file); // open the inputted file name
    int number; // used for inputting the file into this variable
    while (data >> number) { //read the following input
        count++;
        d = count;
        clam[count];
    }
    data.close();
    data.open(file);
    while (data.good()){ //counter
        int i;
        for (i = 0; i<d; i++){
            data >> clam[i];
            cout << clam[i] << " ";
            count1++;
        }
    }
    cout << endl << "There are " << d << " integers in the " << '"' << file << '"' << " file." << endl; // produces the number of integers in the file
    data.close();
    ofstream newfile("newfile.txt");
    data.open(file);
    for (int k = 0; k <= count - 1; k++){
        for (int j = k + 1; j <= count - 1; j++){
            int tpry = 0;
            if (clam[k]>clam[j]){
                tpry = clam[k];
                clam[k] = clam[j];
                clam[j] = tpry;
                swap++; // number of swaps
            }
        }
        newfile << clam[k] << " ";
    }

    cout << endl << "Performed " << swap << " swaps" << endl;
    cout << "File will be saved as: " << '"' << "taras.txt" << '"' << endl;
    data.close();
    cout << endl;

    ofstream finalfile("taras.txt");
    finalfile << "The file " << file << " was sorted using the bubble sort" << endl 
			  << "The amount of swaps performed: " << swap << endl;

    finalfile << "The amount of integers: " << count << endl << endl 
			  << "Sorted list: " << endl << endl;

    for (int y = 0; y<count; y++){
        for (int z = 0; z <= 9; z++){
            if (y != count){
                cout << right << setw(4) << clam[y];
                finalfile << right << setw(4) << clam[y];
                y++;
            }
            else {
                cout << endl;
                finalfile << endl;
                system("pause");
                return 0;
            }
        }
        y -= 1;
        cout << endl;
        finalfile << endl;
    }
    system("pause");
    return 0;
    
}