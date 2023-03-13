import java.io.IOException;
import java.util.*;

public class MainClass {

    static class BFS {
        private final Deque<Integer> deque = new ArrayDeque<>();
        private final byte[] colours;

        private final int[] distance;
        private static final byte WHITE = 0;
        private static final byte GRAY = 1;
        private static final byte BLACK = 2;

        BFS(int vertSize) {
            colours = new byte[vertSize];
            Arrays.fill(colours, WHITE);
            distance = new int[vertSize];
            Arrays.fill(distance, -1);
        }

        public void search(Graph graph, int startVert) {
            colours[startVert] = GRAY;
            deque.push(startVert);
            distance[startVert] = 0;
            while (!deque.isEmpty()) {
                int nextVert = deque.removeLast();
                for (int i : graph.getOutgoingVerts(nextVert)) {
                    if (colours[i] == WHITE) {
                        deque.push(i);
                        colours[i] = GRAY;
                        distance[i] = distance[nextVert] + 1;
                    }
                }
                colours[nextVert] = BLACK;
            }
        }

        public int getDistance(int vert) {
            return distance[vert];
        }
    }

    static class DFS {
        public boolean flag = false;
    public static void main(String[] args) {

    }

}
