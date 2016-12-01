/**
 * Created by Ethan on 11/14/2016.
 * This is a basic graph implementation (no unique weights or specific directions for edges)
 */
public class Graph extends WeightedGraph {

    public Graph(int size) {
        super(size);
    }

    public Graph() {
        super();
    }

    public void addEdge(int from, int to) {
        super.addEdge(from, to, 1);
        super.addEdge(to, from, 1);
    }
}
