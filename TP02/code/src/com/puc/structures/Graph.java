package com.puc.structures;

import java.util.ArrayList;
import java.util.List;

/*
    Implementation directed graph
    A Graph is a set of vertex and edges when G = (V, E)
    This representation utilizes the adjacent list implementation
 */
public class Graph<T> {
    private List<Vertex<T>> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public List<Vertex<T>> getVertices() {
        return this.getVertices();
    }

    public Boolean addVertice(Vertex<T> vertex) {
        return vertices.add(vertex);
    }
}
