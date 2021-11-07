#include "Graph.h"
#include <iostream>

using namespace std;

int main() {
    Graph graph;

    graph.print();

    graph.insert(0, 1);
    graph.insert(1, 2);
    graph.insert(0, 2);

    graph.print();

    // graph.insert(2, 2);
    // graph.insert(1, 2);

    //graph.print();
    
    int max_flow = graph.findDisjointPaths(graph.matrizAdjacencia, 0, 2);

    printf("%i\n", max_flow);

    return 0;
}