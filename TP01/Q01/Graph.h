#ifndef GRAPH_H
#define GRAPH_H

#define NUM_MAX_VERTEX 10

// Matriz de Adjacencia
// Define um grafo direcionado não ponderado, implementado por matriz de adjacencia
class Graph 
{
    public: 
        bool matrizAdjacencia[NUM_MAX_VERTEX][NUM_MAX_VERTEX];
        Graph();
        void insert(int labelVertexOne, int labelVertexTwo);
        void print();
};

#endif