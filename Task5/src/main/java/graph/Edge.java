package graph;

class Edge<T, E> {

    private final Vertex<T> sourceVertex;
    private final Vertex<T> targetVertex;
    private Double weight;
    private E object;

    public Edge(Vertex<T> sourceVertex, Vertex<T> targetVertex, Double weight) {
        this(sourceVertex, targetVertex, weight, null);
    }

    public Edge(Vertex<T> sourceVertex, Vertex<T> targetVertex, E object) {
        this(sourceVertex, targetVertex, 1.0, object);
    }

    public Edge(Vertex<T> sourceVertex, Vertex<T> targetVertex) {
        this(sourceVertex, targetVertex, 1.0, null);
    }

    public Edge(Vertex<T> sourceVertex, Vertex<T> targetVertex, Double weight, E object) {
        this.sourceVertex = sourceVertex;
        this.targetVertex = targetVertex;
        this.weight = weight;
        this.object = object;
    }

    public Vertex<T> getSourceVertex() {
        return sourceVertex;
    }

    public Vertex<T> getTargetVertex() {
        return targetVertex;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }
}
