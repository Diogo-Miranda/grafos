#include "Graph.h"
#include "Cell.h"
#include <iostream>

using namespace std;

int main() {
    Graph *graph = new Graph();
    
    Cell *vertex = new Cell(1, 1);

    graph->insertVertex(1);
    graph->insertVertex(2);
    graph->insertVertex(3);
    graph->insertVertex(4);
    graph->insertEdge(1, 2, 2);
    graph->insertEdge(1, 3, 1);
    graph->insertEdge(1, 4, 7);
    graph->insertEdge(2, 2, 4);
    graph->print();
    
    return 0;
}