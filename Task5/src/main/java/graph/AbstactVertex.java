package graph;

import java.util.Collection;
import java.util.List;

abstract class AbstractVertex<T> implements Vertex<T> {
    private final T value;

    public AbstractVertex(T object) {
        this.value = object;
    }

    @Override
    public T getValue() {
        return value;
    }

}

