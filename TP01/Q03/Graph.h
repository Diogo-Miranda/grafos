#ifndef GRAPH_H
#include "List.h"
#define GRAPH_H

#define NUM_MAX_VERTEX 4

// Matriz de Adjacencia
// Define um grafo não direcionado não ponderado, implementado por lista de adjacência
class Graph 
{
    public: 
        List *listaAdjacencia[NUM_MAX_VERTEX];
        Graph();
        void insertVertex(int label);
        void insertEdge(int labelVertexOut, int labelVertexIn, int weight);
        void print();

    private:
        void insert(Cell *vertex);
        
};

#endif