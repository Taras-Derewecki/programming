/***********************************************************************************************************************

    idea behind this approach:

    We separate the problem into two halves.
    First, we check if the backbone vertices form a connected component.
    i.e, we run the DFS algorithm to retrieve the number of components in the graph.
    If the components are more than one, this means the graph is disconnected.
    If the graph is disconnected, this means that the backbone vertices are not fully connected.
    Thus, it is not a valid backbone.
    Secondly, we input the phone vertices and check if at any point they are connected to a backbone vertex.
    If they are then we add it to the validPhones vector.
    Finally, if the number of phones is the same as the number of valid phones, the graph is valid.

  Time Complexity:

    The time complexity in this case is the same case as the time complexity for DFS.
    O(n + m)

    Where,
      n: Number of vertices
      m: Number of edges

***********************************************************************************************************************/





#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
#include <map>
using namespace std;

void DFS(string vertex, map <string, vector<string> > m, map<string,bool> &visited){
    visited[vertex] = true;
    for(int i=0;i<m[vertex].size();i++){
        if(visited[m[vertex][i]] == false){
            DFS(m[vertex][i],m,visited);
        }
    }
}

int DFSComponents(vector<string> vertices, map <string, vector<string> > m) {
    map<string,bool> visited;
    int components = 0;
    for(int i = 0; i<vertices.size();i++){
        if(!visited[vertices[i]]){
            DFS(vertices[i],m,visited);
            components++;
        }
    }
    return components;
}

bool find(vector<string> backboneVertices, string s){
    if(find(backboneVertices.begin(), backboneVertices.end(), s) != backboneVertices.end())
        return true;
    else
        return false;
}

int main() {
    int k,n;
    bool result = true;
    cin >> k >> n;
    map <string, vector<string> > m;
    vector<string> backboneVertices;
    vector<string> phones;
    vector<string> validPhones;
    for(int i=0; i<k; i++){
        string s1, s2;
        cin >> s1 >> s2;
        m[s1].insert(m[s1].end(),s2);
        m[s2].insert(m[s2].end(),s1);
        if(!find(backboneVertices,s1)){
            backboneVertices.insert(backboneVertices.end(),s1);
        }
        if(!find(backboneVertices,s2)){
            backboneVertices.insert(backboneVertices.end(),s2);
        }
    }
    if( DFSComponents(backboneVertices,m) > 1){
        result = false;
    }
    for(int i=0;i<n;i++){
        string s1, s2;
        cin >> s1 >> s2;
        if(!find(backboneVertices,s1) && !find(backboneVertices,s2)){
            result = false;
        }
        if(!find(phones,s1) && !find(backboneVertices,s1)){
            phones.insert(phones.end(),s1);
        }
        if(!find(phones,s2) && !find(backboneVertices,s2)){
            phones.insert(phones.end(),s2);
        }
        if(find(backboneVertices,s2) && !find(backboneVertices,s1) && !find(validPhones,s1)){
            validPhones.insert(validPhones.end(),s1);
        }
        if(find(backboneVertices,s1) && !find(backboneVertices,s2) && !find(validPhones,s2)){
            validPhones.insert(validPhones.end(),s2);
        }
    }
    if(phones.size()!=validPhones.size())
        result = false;
    if(result)
        cout << "valid" << endl;
    else
        cout << "invalid" << endl;
    return 0;
}