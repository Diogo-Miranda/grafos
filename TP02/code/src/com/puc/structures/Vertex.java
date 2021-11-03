package com.puc.structures;

import com.puc.structures.interfaces.IVertex;

import java.util.*;

/*
    This class define one vertex in the graph
    One vertex has one adjacent list
    This adjacent list defines the reference between two vertexes (edge)
 */
public class Vertex<T> implements IVertex<T> {
    private T label;
    /*
        Weights are always integers
     */
    private List<IVertex<T>> adjList;

    public Vertex() {

    }

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
            builder.append(this.label).append(" -> ");
        } else {
            builder.append(this.getLabel()).append(" -> ");
            for (IVertex<T> vertex : adjList) {
                builder.append(vertex.getLabel()).append(" ");
            }
        }

        return builder.toString();
    }

    public T getLabel() {
        return this.label;
    }

    public void setLabel(T label) {
        this.label = label;
    }

    public List<IVertex<T>> getAdjList() {
        return this.adjList;
    }

    @Override
    public void setAdjList(IVertex<T> adjList) {

    }
}
