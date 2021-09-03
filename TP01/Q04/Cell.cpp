#include "Cell.h"
#include "stdio.h"

Cell::Cell(int vertex, int weight, Cell *next) {
    this->vertex = vertex;
    this->weight = weight;
    this->next = next;
}

Cell::Cell(int vertex, int weight) {
    this->vertex = vertex;
    this->weight = weight;
    this->next = NULL;
}

Cell::Cell() {
    this->vertex = 0;
    this->weight = 0;
}

void Cell::print() {
    Cell *aux = this; 
    while(aux != NULL) {
        printf("[%i,%i]->", aux->vertex, aux->weight);
        aux = aux->next;
    }
}