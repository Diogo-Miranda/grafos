package com.puc;

import com.puc.structures.Graph;
import com.puc.structures.Vertex;

public class Main {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B")  ;
        Vertex<String> vertex3 = new Vertex<>("C");

        graph.addVertice(vertex1);
        graph.addVertice(vertex2);
        graph.addVertice(vertex3);

        vertex1.addEdgeBetweenTwoVertex(vertex2, 1);
        vertex1.addEdgeBetweenTwoVertex(vertex3, 2);

        System.out.println(vertex1.toString());



    }
}
