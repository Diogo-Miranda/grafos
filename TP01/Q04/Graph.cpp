#include "Graph.h"
#include "stdio.h"
#include "stdlib.h"

Graph::Graph() {
    
}

void Graph::insertVertex(int label) {
    Graph::insert(new Cell(label, 0));
}

void Graph::insert(Cell *vertex) {

    int index = (vertex->vertex)-1;
    
    if(listaAdjacencia[index] == NULL) {
        listaAdjacencia[index] = (List*)malloc(sizeof(List));
        listaAdjacencia[index] = new List(vertex);
    } else {
        printf("These vetex exists");
    }
}

void Graph::insertEdge(int labelVertexOut, int labelVertexIn, int weight) {
    int indexOut = labelVertexOut-1;
    int indexIn = labelVertexIn-1;

    if(listaAdjacencia[indexOut] != NULL && listaAdjacencia[indexIn] != NULL) {
        Cell *aux = listaAdjacencia[indexOut]->head; 
        
        // Insert reference to "vertex Out"
        while(aux->next != NULL) {
            aux = aux->next;
        }

        aux->next = new Cell(labelVertexIn, weight);

        // Insert reference to "vertex In"
        aux = listaAdjacencia[indexIn]->head;

        while(aux->next != NULL) {
            aux = aux->next;
        }

        aux->next = new Cell(labelVertexOut, weight);
    }
}

void Graph::print() {
    for(int i = 0; i < NUM_MAX_VERTEX; i++) {
        if(listaAdjacencia[i] != NULL) {
            printf("[%i]-> ", listaAdjacencia[i]->head->vertex);
            listaAdjacencia[i]->head->next->print();
        }
        printf("\n");
    }
}