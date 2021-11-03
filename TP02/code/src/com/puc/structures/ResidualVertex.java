package com.puc.structures;

import com.puc.structures.interfaces.IVertex;

import java.util.*;


public class ResidualVertex<T> implements IVertex<T> {

    private List<Map<IVertex<T>, Integer>> flowAdjList;
    private T label;

    public ResidualVertex(T label) {
        this.label = label;
        this.flowAdjList = new ArrayList<>();
    }

    @Override
    public T getLabel() {
        return this.label;
    }

    @Override
    public List<IVertex<T>> getAdjList() {
        List<IVertex<T>> vertices = new ArrayList<>();

        for(Map<IVertex<T>, Integer> mapEdge : flowAdjList) {
            mapEdge.forEach((key, value) -> vertices.add(key));
        }

        return vertices;
    }

    public List<Map<IVertex<T>, Integer>> getFlowAdjList() {
        return this.flowAdjList;
    }

    public void setAdjList(IVertex<T> vertex) {
        Map<IVertex<T>, Integer> map = new HashMap<>();
        map.put(vertex, 1);
        this.flowAdjList.add(map);
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();

        if(flowAdjList.isEmpty()) {
            builder.append(this.label).append(" -> ");
        } else {
            builder.append(this.getLabel()).append(" -> ");

            for (Map<IVertex<T>, Integer> mapEdge : flowAdjList) {
                mapEdge.forEach((key, value) -> builder.append(key.getLabel()).append(" "));
            }
        }

        return builder.toString();
    }
}
