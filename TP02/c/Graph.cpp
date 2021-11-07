#include "Graph.h"
#include <stdlib.h>
#include <stdarg.h>
#include <iostream>
#include <queue>
#include <limits.h>

#define NUM_MAX_VERTEX 3

using namespace std;

void Graph::insert(int labelVertexOne, int labelVertexTwo) {
    matrizAdjacencia[labelVertexOne][labelVertexTwo] = 1;
}

void Graph::print() {
    printf("\n");
    for(int i = 0; i < NUM_MAX_VERTEX; i++) {
        for(int j = 0; j < NUM_MAX_VERTEX; j++) {
            printf("%i ", matrizAdjacencia[i][j]);
        }
        printf("\n");
    }
    printf("\n");
}

Graph::Graph() {
    // Insert null 0 on matrix
    for(int i = 0; i < NUM_MAX_VERTEX; i++) {
        for(int j = 0; j < NUM_MAX_VERTEX; j++) {
            matrizAdjacencia[i][j] = 0;
        }
    }
} 

string path = "";

bool bfs(int residualGraph[NUM_MAX_VERTEX][NUM_MAX_VERTEX], int s, int t, int nodes[]) {
    bool isVisited[NUM_MAX_VERTEX];

    for(int i = 0; i < NUM_MAX_VERTEX; i++) isVisited[i] = 0;

    queue <int> q;
    q.push(s);
    isVisited[s] = true;
    nodes[s] = -1;
    
    while(!q.empty()) {
        int u = q.front();
        q.pop();

        for(int v = 0; v < NUM_MAX_VERTEX; v++) {
            if(isVisited[v] == false && residualGraph[u][v] > 0) {
                path = path + to_string(v);  
                q.push(v);
                nodes[v] = u;
                isVisited[v] = true;
            }
        }
    }

    return (isVisited[t] == true);
}

int Graph::findDisjointPaths(int graph[NUM_MAX_VERTEX][NUM_MAX_VERTEX], int s, int t) {
    int residualGraph[NUM_MAX_VERTEX][NUM_MAX_VERTEX];

    int u, v;
    for (u = 0; u < NUM_MAX_VERTEX; u++) {
        for(v = 0; v < NUM_MAX_VERTEX; v++) {
            residualGraph[u][v] = graph[u][v];
        }
    }

    int nodes[NUM_MAX_VERTEX];

    int max_flow = 0; 

    string fonte = to_string(s);
    path = fonte;
    while(bfs(residualGraph, s, t, nodes)) {
        int path_flow = INT_MAX;

        for (v = t; v != s; v = nodes[v])
        {
            u = nodes[v];
            path_flow = min(path_flow, residualGraph[u][v]);
        }
 
        for (v = t; v != s; v = nodes[v])
        {
            u = nodes[v];
            residualGraph[u][v] -= path_flow;
        }
 
        max_flow += path_flow;
        path = path + "\n";  
        cout << path; 
        path = fonte;
    }

    return max_flow;
}
