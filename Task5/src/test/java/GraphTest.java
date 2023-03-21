import graph.Graph;
import graph.GraphIncedence;
import graph.Vertex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GraphTest {



    @Test
    void Tester(){

        class VertexImplementation implements Vertex<Integer> {
            private final Integer node;

            public VertexImplementation(Integer node) {
                this.node = node;
            }

            @Override
            public Integer getValue() {
                return node;
            }
        }

        Graph<Integer, String> graph = new GraphIncedence<Integer, String>() {



            @Override
            public Vertex<Integer> addVertex(Integer object) {
                var tmp = new VertexImplementation(object);
                addVertex(tmp);
                return tmp;
            }

            @Override
            public boolean removeVertex(Integer integer) {
                return false;
            }
        };

        graph.addVertex(new VertexImplementation(2));
        graph.addVertex(new VertexImplementation(1));
        graph.addVertex(new VertexImplementation(3));
        graph.addEdge(2,3);
        graph.addEdge(2,1);
        graph.addEdge(1,2);


        Assertions.assertTrue(graph.containsVertex(2));
        //Assertions.assertTrue(graph.containsEdge(2,3));
    }
}
