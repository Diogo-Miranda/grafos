#include "Graph.h"
#include <iostream>

using namespace std;

int main() {
    Graph graph;

    graph.print();

    graph.insert(1, 1);

    graph.insert(20, 20);

    graph.print();

    graph.insert(2, 2);
    graph.insert(1, 2);

    graph.print();

    return 0;
}