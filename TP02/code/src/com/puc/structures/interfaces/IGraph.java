package com.puc.structures.interfaces;

import java.util.List;

public interface IGraph<T> {

    boolean addVertice(IVertex<T> vertex);

    boolean addEdgeBetweenTwoVertex(IVertex<T> vertexOut, IVertex<T> vertexIn);

    void DFS();
}
