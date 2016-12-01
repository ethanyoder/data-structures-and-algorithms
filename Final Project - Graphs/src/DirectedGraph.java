/**
 * Created by Ethan on 11/14/2016.
 * This is a directed graph implementation (no unique weights)
 */
public class DirectedGraph extends WeightedDirectedGraph {

    public DirectedGraph(int size) {
        super(size);
    }

    public DirectedGraph() {
        super();
    }

    //weight of 1 is assigned by default - no weights in this graph
    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

}
