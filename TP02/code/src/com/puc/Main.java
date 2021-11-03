package com.puc;

import com.puc.structures.Graph;
import com.puc.structures.ResidualGraph;
import com.puc.structures.ResidualVertex;
import com.puc.structures.Vertex;
import com.puc.structures.interfaces.IGraph;
import com.puc.structures.interfaces.IVertex;

public class Main {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        Vertex<String> vertex1 = new Vertex<>("A");
        Vertex<String> vertex2 = new Vertex<>("B");
        Vertex<String> vertex3 = new Vertex<>("C");
        Vertex<String> vertex4 = new Vertex<>("D");

//        graph.addNVertices(vertex1, vertex2, vertex3);
//
//        graph.addEdgeBetweenTwoVertex(vertex1, vertex2);
//        graph.addEdgeBetweenTwoVertex(vertex1, vertex4);
//        graph.addEdgeBetweenTwoVertex(vertex1, vertex3);
//
//        System.out.println(graph.toString());
//
//        graph.DFS();

        IGraph<String> graphResidual = new ResidualGraph<>();
        IVertex<String> vertexResidual1 = new ResidualVertex<>("A");
        IVertex<String> vertexResidual2 = new ResidualVertex<>("B");
        IVertex<String> vertexResidual3 = new ResidualVertex<>("C");
        IVertex<String> vertexResidual4 = new ResidualVertex<>("D");

        graphResidual.addVertice(vertexResidual1);
        graphResidual.addVertice(vertexResidual2);
        graphResidual.addVertice(vertexResidual3);
        graphResidual.addVertice(vertexResidual4);

        graphResidual.addEdgeBetweenTwoVertex(vertexResidual1, vertexResidual2);
        graphResidual.addEdgeBetweenTwoVertex(vertexResidual1, vertexResidual3);
        graphResidual.addEdgeBetweenTwoVertex(vertexResidual3, vertexResidual2);
        graphResidual.addEdgeBetweenTwoVertex(vertexResidual3, vertexResidual4);

        graphResidual.DFS();

        //System.out.println(graphResidual.toString());
    }
}
