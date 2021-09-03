#ifndef CELL_H
#define CELL_H

// Define uma estrutura de lista
class Cell
{
    public: 
        int vertex;
        int weight;
        Cell *next;
        Cell(int vertex, int weight, Cell *next);
        Cell(int vertex, int weight);
        Cell();
        void print();
};

#endif