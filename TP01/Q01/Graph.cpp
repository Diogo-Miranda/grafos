#include "Graph.h"
#include <stdlib.h>
#include <stdarg.h>
#include <iostream>

#define NUM_MAX_VERTEX 10

using namespace std;

void Graph::insert(int labelVertexOne, int labelVertexTwo) {
    if(labelVertexOne > NUM_MAX_VERTEX || labelVertexOne <= 0 || labelVertexTwo > NUM_MAX_VERTEX || labelVertexTwo <= 0) {
        printf("These vertex do not exists (%i, %i)\n", labelVertexOne, labelVertexTwo);
    } else {
        if(matrizAdjacencia[labelVertexOne][labelVertexTwo] == 1) {
            printf("There are edges between %i and %i", labelVertexOne, labelVertexTwo);
        } else {
            matrizAdjacencia[labelVertexOne][labelVertexTwo] = 1;
        }
    }
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
