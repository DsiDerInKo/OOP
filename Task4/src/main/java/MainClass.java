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

        /*
        public void search(Graph graph, int startVert, int prevVert) {
            graph.colour[startVert] = 2;
            for (int o : graph.arr[startVert]) {
                if (graph.colour[o] == 2) {
                    if (o != prevVert) {
                        flag = true;
                    }
                }
                if (graph.colour[o] == 1) {
                    search(graph, o, startVert);
                }
            }

            graph.colour[startVert] = 3;
        }

         */
    }

    static class Graph {
        private final List<Integer>[] arr;


        Graph(int vert) {
            arr = new ArrayList[vert];

            for (int i = 0; i < vert; i++) {
                arr[i] = new ArrayList<>();
            }
        }

        public void addEdge(int v1, int v2) {
            arr[v1 - 1].add(v2 - 1);
            arr[v2 - 1].add(v1 - 1);
        }

        public List<Integer> getOutgoingVerts(int vert) {
            return new ArrayList<>(arr[vert]);
        }
    }

    public static void main(String[] args) throws IOException {
/*
* Gson gson = new Gson();
Object obj = gson.fromJson(new FileReader("C:\\Prog\\java_prod\\OOP\\Task4\\src\\main\\java\\test.json"),Object.class);
String tmp = "{'query' : 'count'}";

//Object fig = gson.fromJson(tmp,String.class);

//System.out.println(fig);
System.out.println(obj);
obj.toString();
*
* (object mapper )
* */

        Scanner scan = new Scanner(System.in);
        int vert, edg;
        vert = scan.nextInt();
        edg = scan.nextInt();

        Graph graph = new Graph(vert);
        int v1, v2;
        for (int i = 0; i < edg; i++) {
            v1 = scan.nextInt();
            v2 = scan.nextInt();
            graph.addEdge(v1, v2);
        }

        int start, end;
        start = scan.nextInt();
        end = scan.nextInt();

        BFS bfs = new BFS(vert);
        bfs.search(graph, start - 1);
        System.out.println(bfs.getDistance(end - 1));

    }

}