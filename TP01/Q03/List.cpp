#include "List.h"
#include "stdio.h"
#include "stdlib.h"

List::List() {

}

List::List(Cell *vertex) {
    this->head = vertex;
}

List::List(int vertex, int weight) {
    this->head = new Cell(vertex, 0);
}
