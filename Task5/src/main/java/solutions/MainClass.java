package solutions;

import graph.Graph;
import graph.GraphIncedence;
import graph.Vertex;

import java.util.*;

public class MainClass {

    static class Node {
        int x;
        int y;
        int z;

        Node(int num1, int num2, int num3) {
            x = num1;
            y = num2;
            z = num3;
        }

        public int getIndex() {
            return x * 101 * 101 + y * 101 + z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y && z == node.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, z);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner("0 0\n" +
                "1 1 1\n" +
                "2 2 2");
        Graph<Node, String> graph = new GraphImplementation();

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    graph.addVertex(new Node(i, j, k));
                }
            }
        }

        int buildingsAmount = scan.nextInt(), energyAmount = scan.nextInt();
        int xStart = scan.nextInt(), yStart = scan.nextInt(), zStart = scan.nextInt();
        int xEnd = scan.nextInt(), yEnd = scan.nextInt(), zEnd = scan.nextInt();

        for (int i = 0; i < buildingsAmount; i++) {
            int x = scan.nextInt(), y = scan.nextInt(), z = scan.nextInt();
            int hight = scan.nextInt();
            for (int j = 0; j < hight; j++) {
                if (j + z <= 100) graph.removeVertex(new Node(x, y, z + j));
            }
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    graph.addEdge(new Node(i, j, k), new Node(i, j, k + 1));
                    graph.addEdge(new Node(i, j, k), new Node(i, j, k - 1));
                    graph.addEdge(new Node(i, j, k), new Node(i, j + 1, k));
                    graph.addEdge(new Node(i, j, k), new Node(i, j - 1, k));
                    graph.addEdge(new Node(i, j, k), new Node(i + 1, j, k));
                    graph.addEdge(new Node(i, j, k), new Node(i - 1, j, k));
                }
            }
        }

        BFS<Node> bfs = new BFS<>();
        bfs.search(graph, new Node(xStart, yStart, zStart));
        int neededEnergy = bfs.getDistance(new Node(xEnd, yEnd, zEnd));
        if (neededEnergy > energyAmount) {
            System.out.println(-1);
        } else {
            System.out.println(neededEnergy);
        }
    }

    static class BFS<V> {

        private static final int vertAmount = 101 * 101 * 101;
        private final Deque<V> deque = new ArrayDeque<>();
        private final Map<V, Byte> colours;
        private final Map<V, Integer> distance;
        private static final byte WHITE = 0;
        private static final byte GRAY = 1;
        private static final byte BLACK = 2;

        BFS() {
            colours = new HashMap<>();
            distance = new HashMap<>();
        }

        public void search(Graph<V, ?> graph, V startVert) {
            colours.put(startVert, GRAY);
            deque.push(startVert);
            distance.put(startVert, 0);
            while (!deque.isEmpty()) {
                V nextVert = deque.removeLast();
                for (Vertex<V> v : graph.adjacencyVertices(nextVert)) {
                    if (colours.get(v.getValue()) == null) {
                        deque.push(v.getValue());
                        colours.put(v.getValue(), GRAY);
                        distance.put(v.getValue(), distance.get(nextVert) + 1);
                    }
                }
                colours.put(nextVert, BLACK);
            }

        }

        public int getDistance(V vert) {
            var res = distance.get(vert);
            return res == null ? -1 : res;
        }
    }

    public static class GraphImplementation extends GraphIncedence<Node, String> {

        public GraphImplementation() {
            super();
        }

        private static class VertexImplementation implements Vertex<Node> {
            private final Node node;

            public VertexImplementation(Node node) {
                this.node = node;
            }

            @Override
            public Node getValue() {
                return node;
            }
        }

        @Override
        public Vertex<Node> addVertex(Node object) {
            var tmp = new VertexImplementation(object);
            addVertex(tmp);
            return tmp;
        }

        @Override
        public boolean removeVertex(Node node) {
            return false;
        }
    }
}
