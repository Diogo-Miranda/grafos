#ifndef LIST_H
#include "Cell.h"
#define LIST_H


// Define uma estrutura de lista
class List
{
    public: 
        Cell *head;
        List();
        List(Cell *vertex);
        List(int vertex, int weight);
};

#endif