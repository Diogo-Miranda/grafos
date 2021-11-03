package com.puc.structures.interfaces;

import java.util.List;

public interface IVertex<T> {

    T getLabel();

    List<IVertex<T>> getAdjList();

    void setAdjList(IVertex<T> adjList);
}
