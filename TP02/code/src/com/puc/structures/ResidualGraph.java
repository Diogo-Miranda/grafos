package com.puc.structures;

import com.puc.structures.interfaces.IGraph;
import com.puc.structures.interfaces.IVertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResidualGraph<T> implements IGraph<T> {

    private List<IVertex<T>> vertices;

    public ResidualGraph() {
        vertices = new ArrayList<>();
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
            vertexOut.setAdjList(vertexIn);
        } else {
            System.out.println("The vertices '" + vertexOut.getLabel() + "' '" + vertexIn.getLabel() + "' do not exist in the graph.");
            success = false;
        }

        return success;
    }

    private void DFSVisitDisjont(ResidualVertex<T> vertex, StringBuilder builder, boolean[] isVisited, int s) {

        for(Map<IVertex<T>, Integer> mapVertex : vertex.getFlowAdjList()) {
            if (existFlow(vertex.getFlowAdjList()) && !isVisited[s]) {
                isVisited[s] = true;
                for(Map.Entry<IVertex<T>, Integer> entry : mapVertex.entrySet()) {
                    if (entry.getValue() >= 1) {
                        builder.append(entry.getKey().getLabel());
                        mapVertex.replace(entry.getKey(), 0);
                        DFSVisitDisjont((ResidualVertex<T>) entry.getKey(), builder, isVisited, s++);
                    }
                }
            }
        }

        System.out.println(builder.toString());
        builder.deleteCharAt(builder.length() - 1);
    }

    @Override
    public void DFS() {
        List<IVertex<T>> verticesTemp = vertices;

        for(IVertex<T> vertex: verticesTemp) {
            ResidualVertex<T> residualVertex = (ResidualVertex<T>) vertex;

            StringBuilder builder = new StringBuilder();

            while(!residualVertex.getFlowAdjList().isEmpty() && existFlow(residualVertex.getFlowAdjList())) {
                boolean[] isVisited = new boolean[residualVertex.getFlowAdjList().size()];

                builder.append(residualVertex.getLabel());
                DFSVisitDisjont(residualVertex, builder, isVisited, 0);

                System.out.print("\n");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        vertices.forEach(v -> builder.append(v.toString()).append("\n"));

        return builder.toString();
    }

    private boolean existFlow(List<Map<IVertex<T>, Integer>> flowList) {
        return flowList.stream().anyMatch(map -> map.values().stream().anyMatch(v -> v >= 1));
    }
}

