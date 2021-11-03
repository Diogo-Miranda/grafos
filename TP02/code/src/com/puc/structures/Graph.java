package com.puc.structures;

import com.puc.structures.interfaces.IGraph;
import com.puc.structures.interfaces.IVertex;

import java.util.*;

/*
    Implementation directed graph
    A Graph is a set of vertex and edges when G = (V, E)
    This representation utilizes the adjacent list implementation
 */
public class Graph<T> implements IGraph<T> {
    private List<IVertex<T>> vertices;
    protected Integer numberVertices;

    public Graph() {
        vertices = new ArrayList<>();
        numberVertices = 0;
    }

    public List<IVertex<T>> getVertices() {
        return this.getVertices();
    }

    public void addNVertices(IVertex<T>... vertices) {
        Arrays.stream(vertices)
                .forEach(v -> {
                    this.addVertice(v);
                    this.numberVertices++;
                });
    }

    @Override
    public boolean addVertice(IVertex<T> vertex) {
        boolean isPresent = vertices.stream()
                .anyMatch(v -> v.getLabel().equals(vertex.getLabel()));

        boolean success = true;
        if(isPresent) {
            System.out.println("ERRO: Vertice is present in the graph");
            success = false;
        } else {
            vertices.add(vertex);
        }

        return success;
    }

    @Override
    public boolean addEdgeBetweenTwoVertex(IVertex<T> vertexOut, IVertex<T> vertexIn) {
        boolean success = true;

        if(this.vertices.contains(vertexOut) && this.vertices.contains(vertexIn)) {
            // Adding in his adjacent list
            vertices.stream()
                    .filter(v -> v.getLabel().equals(vertexOut.getLabel()))
                    .findFirst()
                    .get()
                    .getAdjList().add(vertexIn);
        } else {
            System.out.println("The vertices '" + vertexOut.getLabel() + "' '" + vertexIn.getLabel() + "' do not exist in the graph.");
            success = false;
        }

        return success;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        vertices.forEach(v -> builder.append(v.toString()).append("\n"));

        return builder.toString();
    }

    private void DFSVisit(IVertex<T> vertex, Map<IVertex<T>, Boolean> visited) {
        visited.put(vertex, true);
        System.out.println(vertex.getLabel() + " ");

        vertex.getAdjList().forEach(v -> {
            if(!visited.get(v)) {
                DFSVisit(v, visited);
            }
        });
    }

    @Override
    public void DFS() {
        /*
            Memory if vertex was visited
         */
        Map<IVertex<T>, Boolean> visited = new HashMap<>();

        vertices.forEach(v -> visited.put(v, false));

        vertices.stream()
                .filter(v -> !visited.get(v))
                .forEach(v -> DFSVisit(v, visited));
    }
}

