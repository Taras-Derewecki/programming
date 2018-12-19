#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <sstream>
using namespace std;

struct question{
    int qtype;
    int i;
    char c;
};

struct ques_type {
    int qtype;
    int op;
    question ques[25];
    int i;
    char c;
    int ans;
    int count;
};

int answer[10][3];
vector<ques_type> questions(30);

bool check_total(char c, int i, int d, int s, int g){
    if(c == 'd'){
        return i == d;
    }
    else if(c == 's'){
        return i == s;
    }
    else if(c == 'g'){
        return i == g;
    }
    return 0;
}

bool check_bird(char c, char sequence_char){
    return c == sequence_char;
}

void check_right_answer(vector<char> &sequence,vector<ques_type> &questions, int n, int q){
    int d=0,s=0,g=0;
    for(int i=0;i<sequence.size();i++){
        if(sequence[i]=='d')
            d++;
        else if (sequence[i]=='g')
            g++;
        else if (sequence[i]=='s')
            s++;
    }
    int truth = 0;
    for(int i=0;i<q;i++){
        //cout<<"questions number = "<<i<<endl;
        if(questions[i].qtype==1){
            truth += check_total(questions[i].c, questions[i].i, d, s, g) == questions[i].ans;
        }
        else if(questions[i].qtype==2){
            truth += check_bird(questions[i].c, sequence[questions[i].i - 1]) == questions[i].ans;
        }
        else {
            if (questions[i].op == 1){
                //cout<<"AND type question"<<endl;
                bool add = 1;
                for(int j=0; j< questions[i].count;j++){
                    if (questions[i].ques[j].qtype == 1)
                        add = add && check_total(questions[i].ques[j].c, questions[i].ques[j].i, d, s, g);
                    else
                        add = add && check_bird(questions[i].ques[j].c, sequence[questions[i].ques[j].i - 1]);
                }
                //cout<<add <<" "<<questions[i].ans<<endl;
                truth += add == questions[i].ans;
            }
            else{
                //cout<<"OR type question"<<endl;
                bool add = 0;
                //cout<<"question count = "<<questions[i].count<<endl;
                for(int j=0; j< questions[i].count;j++){
                    if (questions[i].ques[j].qtype == 1)
                        add = add || check_total(questions[i].ques[j].c, questions[i].ques[j].i, d, s, g);
                    else
                        add = add || check_bird(questions[i].ques[j].c, sequence[questions[i].ques[j].i - 1]);
                    //cout<<"add = "<<add<<endl;
                }
                //cout<<add <<" "<<questions[i].ans<<endl;
                truth += add == questions[i].ans;
            }
        }
    }
    if (truth == n){
        for(int i=0;i<sequence.size();i++){
            if(sequence[i]=='d')
                answer[i][0] = 1;
            else if (sequence[i]=='g')
                answer[i][1] = 1;
            else if (sequence[i]=='s')
                answer[i][2] = 1;
        }
    }
}
void rec(int index, vector<char> &sequence,vector<ques_type> &questions, int n, int q){
    if(index == 10){
        check_right_answer(sequence, questions, n, q);
        return;
    }
    sequence[index] = 'd';
    rec(index+1, sequence, questions, n, q);

    sequence[index] = 's';
    rec(index+1, sequence, questions, n, q);

    sequence[index] = 'g';
    rec(index+1, sequence, questions, n, q);
}

int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    int i,j,k,n,m,q,g,x;
    string line;
    getline(cin, line);
    stringstream  linestream(line);
    linestream >> g;
    while(g--){
        for(i=0;i<10;i++){
            answer[i][0] = 0;
            answer[i][1] = 0;
            answer[i][2] = 0;
        }
        getline(cin, line);
        getline(cin, line);
        stringstream  linestream(line);
        linestream >> q >> n;
        n = q - n;
        //cout<<n<<endl;
        //cout<< q << "  "<< n << endl;

        for(i=0;i<q;i++){
            string line;
            getline(cin, line);
            if(line.find("and") != string::npos){
                questions[i].qtype = 3;
                questions[i].op = 1;
                k = 0;
                stringstream  linestream(line);
                string in;
                while(linestream >> in){
                    if (in == "total") {
                        questions[i].ques[k].qtype = 1;
                        linestream >> questions[i].ques[k].c;
                        linestream >> questions[i].ques[k].i;
                        //cout<<"total "<<questions[i].ques[k].c<<" "<<questions[i].ques[k].i<<" ";
                    }
                    else{
                        questions[i].ques[k].qtype = 2;
                        linestream >> questions[i].ques[k].i;
                        linestream >> questions[i].ques[k].c;
                        //cout<<"bird "<<questions[i].ques[k].i<<" "<<questions[i].ques[k].c<<" ";
                    }
                    linestream >> in;
                    k++;
                }
                questions[i].count = k;
                //cout<<endl;
            }
            else if(line.find("or") != string::npos){
                questions[i].qtype = 3;
                questions[i].op = 2;
                k = 0;
                stringstream  linestream(line);
                string in;
                while(linestream >> in){
                    if (in == "total") {
                        questions[i].ques[k].qtype = 1;
                        linestream >> questions[i].ques[k].c;
                        linestream >> questions[i].ques[k].i;
                        //cout<<"total "<<questions[i].ques[k].c<<" "<<questions[i].ques[k].i<<" ";
                    }
                    else{
                        questions[i].ques[k].qtype = 2;
                        linestream >> questions[i].ques[k].i;
                        linestream >> questions[i].ques[k].c;
                        //cout<<"bird "<<questions[i].ques[k].i<<" "<<questions[i].ques[k].c<<" ";
                    }
                    linestream >> in;
                    k++;
                }
                questions[i].count = k;
                //cout<<endl;
            }
            else{
                stringstream  linestream(line);
                string in;
                linestream >> in;
                if(in == "total"){
                    questions[i].qtype = 1;
                    linestream >> questions[i].c;
                    linestream >> questions[i].i;
                    //cout<<"total "<<questions[i].ques[k].i<<" "<<questions[i].ques[k].c<<endl;
                }
                else {
                    questions[i].qtype = 2;
                    linestream >> questions[i].i;
                    linestream >> questions[i].c;
                    //cout<<"bird "<<questions[i].i<<" "<<questions[i].c<<endl;
                }
            }

            getline(cin, line);
            if(line == "yes"){
                questions[i].ans = 1;
                //cout<<"yes"<<endl;
            }
            else{
                questions[i].ans = 0;
                //cout<<"no"<<endl;
            }
        }
        vector<char> sequence(10);
        rec(0,sequence, questions, n, q);

        // sequence[0] = 's';
        // sequence[1] = 'd';
        // sequence[2] = 's';
        // sequence[3] = 'g';
        // sequence[4] = 'd';
        // sequence[5] = 's';
        // sequence[6] = 's';
        // sequence[7] = 'd';
        // sequence[8] = 's';
        // sequence[9] = 's';
        // check_right_answer(sequence, questions, n);
        for(i=0;i<10;i++){
            if(answer[i][0] == 1){
                cout<<"d";
            }
            if(answer[i][1] == 1){
                cout<<"g";
            }
            if(answer[i][2] == 1){
                cout<<"s";
            }
            cout<<" ";
        }
        cout<<endl;
    }
    return 0;
}