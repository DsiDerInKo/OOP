package graph;

import java.util.*;
import java.util.stream.Collectors;

public abstract class GraphIncedence<V, E> implements Graph<V, E> {

    private class Node implements Iterable<Edge<V, E>> {
        private final Vertex<V> vert;
        private final List<Edge<V, E>> edgeList;

        public Node(Vertex<V> newVert) {
            vert = newVert;
            edgeList = new ArrayList<>();
        }


        /**
         * Returns an iterator over elements of type {@code T}.
         *
         * @return an Iterator.
         */
        @Override
        public Iterator<Edge<V, E>> iterator() {
            return edgeList.iterator();
        }
    }

    private final Map<V, Node> incidenceList;

    public GraphIncedence() {
        incidenceList = new HashMap<>();
    }

    @Override
    public List<Edge<V, E>> outgoingEdges(Vertex<V> vertex) {
        return incidenceList.get(vertex.getValue()).edgeList
                .stream()
                .filter((tmp) -> tmp.getSourceVertex().equals(vertex)).collect(Collectors.toList());
    }

    @Override
    public List<Edge<V, E>> ingoingEdges(Vertex<V> vertex) {
        return incidenceList.get(vertex.getValue()).edgeList
                .stream()
                .filter((tmp) -> tmp.getTargetVertex().equals(vertex)).collect(Collectors.toList());
    }

    public List<Vertex<V>> adjacencyVertices(V vertex) {
        return adjacencyVertices(incidenceList.get(vertex).vert);
    }

    @Override
    public List<Vertex<V>> adjacencyVertices(Vertex<V> vertex) {
        List<Vertex<V>> tmp = new ArrayList<>();
        for (Edge<V, E> i : incidenceList.get(vertex.getValue()).edgeList) {
            if (i.getTargetVertex().equals(vertex)) {
                tmp.add(i.getSourceVertex());
            } else {
                tmp.add(i.getTargetVertex());
            }
        }

        return tmp;
    }

    @Override
    public List<Edge<V, E>> getEdges(Vertex<V> sourceVertex, Vertex<V> targetVertex) {
        if (!containsVertex(sourceVertex) || !containsVertex(targetVertex)) return null;
        return incidenceList.get(sourceVertex.getValue()).edgeList
                .stream()
                .filter((tmp) -> tmp.getTargetVertex().equals(targetVertex))
                .collect(Collectors.toList());
    }

    @Override
    public Edge<V, E> getFirstEdge(Vertex<V> sourceVertex, Vertex<V> targetVertex) {
        var tmp = getEdges(sourceVertex, targetVertex);
        if (tmp == null || tmp.isEmpty()) {
            return null;
        }
        return tmp.get(0);
    }

    @Override
    public Edge<V, E> addEdge(Vertex<V> sourceVertex, Vertex<V> targetVertex, Double weight, E object) {
        return addEdge(new Edge<>(sourceVertex, targetVertex, weight, object));
    }

    @Override
    public Edge<V, E> addEdge(V sourceVertex, V targetVertex) {
        if (sourceVertex == null || targetVertex == null) {
            return null;
        }
        if (incidenceList.containsKey(sourceVertex) && incidenceList.containsKey(targetVertex)) {
            Node source = incidenceList.get(sourceVertex);
            Node target = incidenceList.get(targetVertex);
            Edge<V, E> edge = new Edge<>(source.vert, target.vert);

            addEdge(edge);
            return edge;
        }
        return null;
    }

    @Override
    public Edge<V, E> addEdge(Edge<V, E> edge) {
        if (containsVertex(edge.getSourceVertex()) && containsVertex(edge.getTargetVertex())) {
            incidenceList.get(edge.getSourceVertex().getValue()).edgeList.add(edge);
            incidenceList.get(edge.getTargetVertex().getValue()).edgeList.add(edge);
        }
        return edge;
    }

    @Override
    public boolean addVertex(Vertex<V> vertex) {
        incidenceList.put(vertex.getValue(), new Node(vertex));
        return true;
    }

    @Override
    public boolean containsEdge(V sourceVertex, V targetVertex) {
        if (!containsVertex(sourceVertex)) {
            return false;
        }
        for (Edge<V, E> i : incidenceList.get(sourceVertex)) {
            if (i.getTargetVertex().equals(targetVertex)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsEdge(Vertex<V> sourceVertex, Vertex<V> targetVertex) {
        if (sourceVertex == null || targetVertex == null) {
            return false;
        }
        return containsEdge(sourceVertex.getValue(), targetVertex.getValue());
    }

    @Override
    public boolean containsEdge(Edge<V, E> e) {
        if (e == null) {
            return false;
        }
        return containsEdge(e.getSourceVertex(), e.getTargetVertex());
    }

    @Override
    public boolean containsVertex(V v) {
        return incidenceList.containsKey(v);
    }

    @Override
    public boolean containsVertex(Vertex<V> v) {
        if (v == null) {
            return false;
        }
        return containsVertex(v.getValue());
    }

    @Override
    public Collection<Edge<V, E>> getAllEdges() {
        return new HashSet<>(incidenceList.values().stream()
                .map((Node tmp) -> tmp.edgeList)
                .reduce(new ArrayList<Edge<V, E>>(), (accum, elem) -> {
                            accum.addAll(elem);
                            return accum;
                        }
                ));
    }

    @Override
    public Collection<Vertex<V>> getAllVertices() {
        return incidenceList.values().stream().map((Node tmp) -> tmp.vert).collect(Collectors.toList());
    }

    @Override
    public Edge<V, E> removeEdge(Vertex<V> sourceVertex, Vertex<V> targetVertex) {
        var edge = getFirstEdge(sourceVertex, targetVertex);
        removeEdge(edge);
        return edge;
    }

    @Override
    public boolean removeEdge(Edge<V, E> e) {
        if (e == null) {
            return false;
        }
        if (containsEdge(e)) {
            incidenceList.get(e.getSourceVertex().getValue()).edgeList.remove(e);
            incidenceList.get(e.getTargetVertex().getValue()).edgeList.remove(e);
            return true;
        }

        return false;
    }

    @Override
    public boolean removeVertex(Vertex<V> v) {
        if (containsVertex(v)) {
            incidenceList.get(v.getValue()).edgeList.forEach(this::removeEdge);
            return true;
        }

        return false;
    }
}
