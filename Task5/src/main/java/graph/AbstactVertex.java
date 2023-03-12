package graph;

import java.util.Collection;
import java.util.List;

interface Vertex<T> {
    T getValue();
}

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

interface Graph<V, E> {
    List<Edge<V, E>> outgoingEdges(Vertex<V> vertex);

    List<Edge<V, E>> ingoingEdges(Vertex<V> vertex);

    List<Vertex<V>> adjacencyVertices(Vertex<V> vertex);

    List<Edge<V, E>> getEdges(Vertex<V> sourceVertex, Vertex<V> targetVertex);

    Edge<V, E> getFirstEdge(Vertex<V> sourceVertex, Vertex<V> targetVertex);

    default Edge<V, E> addEdge(Vertex<V> sourceVertex, Vertex<V> targetVertex) {
        return addEdge(sourceVertex, targetVertex, 1.0);
    }

    default Edge<V, E> addEdge(Vertex<V> sourceVertex, Vertex<V> targetVertex, E object) {
        return addEdge(sourceVertex, targetVertex, 1.0, object);
    }

    default Edge<V, E> addEdge(Vertex<V> sourceVertex, Vertex<V> targetVertex, Double weight) {
        return addEdge(sourceVertex, targetVertex, weight, null);
    }

    Edge<V, E> addEdge(Vertex<V> sourceVertex, Vertex<V> targetVertex, Double weight, E object);

    Edge<V, E> addEdge(Edge<V, E> edge);

    boolean addVertex(Vertex<V> vertex);

    default Vertex<V> addVertex(V object, Integer index) {
        throw new UnsupportedOperationException();
    }

    Vertex<V> addVertex(V object);

    boolean containsEdge(V sourceVertex, V targetVertex);

    boolean containsEdge(Vertex<V> sourceVertex, Vertex<V> targetVertex);

    boolean containsEdge(Edge<V, E> e);

    boolean containsVertex(V v);

    boolean containsVertex(Vertex<V> v);

    Collection<Edge<V, E>> getAllEdges();

    Collection<Vertex<V>> getAllVertices();

    default int inDegreeOf(Vertex<V> vertex) {
        if (!containsVertex(vertex)) {
            return -1;
        }
        return ingoingEdges(vertex).size();
    }

    default int outDegreeOf(Vertex<V> vertex) {
        if (!containsVertex(vertex)) {
            return -1;
        }
        return outgoingEdges(vertex).size();
    }

    default boolean removeAllEdges(Collection<? extends Edge<V, E>> edges) {
        if (edges == null) {
            return false;
        }
        boolean flag = false;
        for (Edge<V, E> edge : edges) {
            flag |= removeEdge(edge);
        }
        return flag;
    }


    default boolean removeAllVertices(Collection<Vertex<V>> vertices) {
        if (vertices == null) {
            return false;
        }
        boolean flag = false;
        for (Vertex<V> vertex : vertices) {
            flag |= removeVertex(vertex);
        }
        return flag;
    }

    default Edge<V, E> removeEdge(V sourceVertex, V targetVertex) {
        throw new UnsupportedOperationException();
    }

    Edge<V, E> removeEdge(Vertex<V> sourceVertex, Vertex<V> targetVertex);

    default boolean removeEdges(Vertex<V> sourceVertex, Vertex<V> targetVertex) {
        List<Edge<V, E>> edges = getEdges(sourceVertex, targetVertex);
        if (edges == null) {
            return false;
        }
        boolean flag = false;
        for (Edge<V, E> edge : edges) {
            flag = removeEdge(edge) | flag;
        }
        return flag;
    }

    boolean removeEdge(Edge<V, E> e);

    boolean removeVertex(V v);

    boolean removeVertex(Vertex<V> v);
}