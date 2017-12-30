/******************************************************************************
Programmer: Taras Derewecki
Date: 02/13/2016
Assignment 5: Pig Latin

This program will prompt the user for an English word, phrase, or sentence and 
then translate the words into Pig Latin, as follows: the initial consonants 
are moved from the front of the word to the end and the letters “ay” are then
added to the end. Thus “meal” becomes “eal-may”, “scram” becomes “am-scray”, 
and “java” becomes “ava-jay”. If the word begins with a vowel, then just add 
“ay” to the end.
*******************************************************************************/

#include <iostream>
#include <string>
using namespace std;


string pig_latin(string); // prototype

int main()
{
    cout << "input a word or phrase for pig latin to occur: ";
    string sentence;
    
    getline(cin, sentence);
    sentence = pig_latin(sentence);
    cout << sentence << endl;
    
    return 0;
}

string pig_latin(string word)
{
    
    string pig_latin_word, pig_latin_sentence = ""; //pig_latin_word holds word translated in pig latin.
                                                    //pig_latin_sentence holds the whole sentence.
    int length = 0, i = 0;
    
    while (word[i] != '\0')
    {

        if (word.find(' ', i) != -1)
        {
            length = word.find(' ', i);
            length -= i; // # of characters in the word
            pig_latin_word = word.substr(i, length);
            pig_latin_word.insert(length, "ay");
            pig_latin_word.insert(length, 1, word[i]); // insert first letter at end of string
            pig_latin_word.erase(0, 1); // erases first letter
            i += length + 1; //moves things around
        }
        else
        {
            pig_latin_word = word.substr(i);
            length = pig_latin_word.length();
            pig_latin_word.insert(length, "ay");
            pig_latin_word.insert(length, 1, word[i]);
            pig_latin_word.erase(0, 1);
            i = word.length();
        }
        
        pig_latin_sentence += (pig_latin_word + " ");
    }
    return pig_latin_sentence;
}
