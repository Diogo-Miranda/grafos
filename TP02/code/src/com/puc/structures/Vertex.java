package com.puc.structures;

import java.util.*;

/*
    This class define one vertex in the graph
    One vertex has one adjacent list
    This adjacent list defines the reference between two vertexes (edge)
 */
public class Vertex<T> {
    private T label;
    /*
        Weights are always integers
     */
    private List<Map<Vertex<T>, Integer>> adjList;

    public Vertex(T label) {
        this.label = label;
        /*
            When a vertex exists, his adjacent list is null
        */
        this.adjList = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if(adjList.isEmpty()) {
            builder.append("This vertex is a final vertex");
        } else {
            for (Map<Vertex<T>, Integer> edge : adjList) {
                Optional<Map.Entry<Vertex<T>, Integer>> vertexInMap = edge
                        .entrySet().stream()
                        .findFirst();

                if (vertexInMap.isPresent()) {
                    Map.Entry<Vertex<T>, Integer> vertexEntry = vertexInMap.get();
                    Vertex<T> vertex = vertexEntry.getKey();
                    Integer weight = vertexEntry.getValue();

                    builder.append(vertex.getLabel()).append(":").append(weight).append(" ");
                }
            }
        }

        return builder.toString();
    }

    public boolean addEdgeBetweenTwoVertex(Vertex<T> vertexIn, Integer weight) {
        // Create Edge
        Map<Vertex<T>, Integer> edge = new HashMap<>();
        edge.put(vertexIn, weight);
        // Adding in his adjacent list
        return adjList.add(edge);
    }

    public T getLabel() {
        return this.label;
    }

    public void setLabel(T label) {
        this.label = label;
    }

    public List<Map<Vertex<T>, Integer>> getAdjList() {
        return this.adjList;
    }
}
