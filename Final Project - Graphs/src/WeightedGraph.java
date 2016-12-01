/**
 * Created by Ethan on 11/14/2016.
 * This is a weighted graph implementation (no specific directions for edges)
 */
public class WeightedGraph extends WeightedDirectedGraph {

    public WeightedGraph(int size) {
        super(size);
    }

    public WeightedGraph() {
        super();
    }

    public void addEdge(int from, int to, double weight) {
        super.addEdge(from, to, weight);
        super.addEdge(to, from, weight);
    }

    //weight of 1 is assigned by default if no weight is given
    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }



}
