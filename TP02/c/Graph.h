#ifndef GRAPH_H
#define GRAPH_H

#define NUM_MAX_VERTEX 3

// Matriz de Adjacencia
// Define um grafo direcionado não ponderado, implementado por matriz de adjacencia
class Graph 
{
    public: 
        int matrizAdjacencia[NUM_MAX_VERTEX][NUM_MAX_VERTEX];
        Graph();
        void insert(int labelVertexOne, int labelVertexTwo);
        int findDisjointPaths(int graph[NUM_MAX_VERTEX][NUM_MAX_VERTEX], int s, int t);
        void print();
};

#endif