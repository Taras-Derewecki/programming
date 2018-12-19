/***********************************************************************************************************************

  Idea behind this approach:

    Similar to the previous problem, we separate the problem into two halves.
    First we check if the courses graph ends up having a cycle.
    We do this by keeping track of the visited vertices along with the back-edges,
    such that if a back-edge is visited, this would mean that a cycle is observed in the graph.
    Secondly, we count the minimum number of semesters required to complete the courses if the graph is acyclic.
    We do this by a simple DFS call by recording the maximum path traversed in the graph at any instance.

  Time Complexity:

    The time complexity in this case, is O(n * m)

    Where,
      n: Number of vertices
      m: Number of edges

    As in the count recursion we can end up with a single chain
    which would iterate over all the vertices and the edges corresponding to them.

***********************************************************************************************************************/





#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
#include <limits.h>
using namespace std;

bool cycle(vector<string> courses, map <string, vector<string> > m, string course, map<string,bool> visited, map<string,bool> backedge)
{
    if(visited[course] == false)
    {
        visited[course] = true;
        backedge[course] = true;
        for(int j=0;j<m[course].size();j++)
        {
            if ( !visited[m[course][j]] && cycle(courses, m, m[course][j], visited, backedge) )
                return true;
            else if (backedge[m[course][j]])
                return true;
        }
    }
    backedge[course] = false;
    return false;
}

bool checkCycle(int n, vector<string> courses, map <string, vector<string> > m)
{
    map<string,bool> visited;
    map<string,bool> backedge;
    for(int i = 0; i < n; i++)
    {
        visited[courses[i]] = false;
        backedge[courses[i]] = false;
    }
    for(int i = 0; i < n; i++)
        if (cycle(courses, m, courses[i], visited, backedge))
            return true;
    return false;
}

void count(string course, vector<string> courses, map <string, vector<string> > m, int &steps, map<string,bool> &visited, int i){
    visited[course] = true;
    if( steps < i )
        steps = i;
    for(int j=0;j<m[course].size();j++){
        if(!visited[m[course][j]]){
            count(m[course][j],courses,m,steps,visited,i+1);
        }
    }
    visited[course] = false;
}

void minSemesters(int n, vector<string> courses, map <string, vector<string> > m, int &steps){
    map<string,bool> visited;
    for(int i = 0; i < n; i++)
    {
        visited[courses[i]] = false;
    }
    for(int i=0;i<n;i++){
        count(courses[i],courses,m,steps,visited,1);
    }
}

int main() {
    int n,p;
    bool result = true;
    int steps = 0;
    cin >> n;
    vector<string> courses;
    for(int i=0;i<n;i++){
        string s;
        cin >> s;
        courses.insert(courses.end(),s);
    }
    map <string, vector<string> > m;
    cin >> p;
    for(int i=0; i<p; i++){
        string s1, s2;
        cin >> s1 >> s2;
        m[s1].insert(m[s1].end(),s2);
    }
    if(checkCycle(n,courses,m))
        result = false;

    if(result){
        minSemesters(n,courses,m,steps);
        cout << steps << endl;
    }
    else
        cout << "never" << endl;

    return 0;
}