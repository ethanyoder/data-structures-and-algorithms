/**
 * Created by Ethan on 11/2/2016.
 * This is an implementation of a Graph that has weights and specific directions
 */
import java.util.ArrayList;

public class WeightedDirectedGraph {
    private double[][] adjacencyMatrix;
    private static int size = 10;

    public WeightedDirectedGraph(int size) {
        this.size = size;
        adjacencyMatrix = new double[size][size];
    }

    public WeightedDirectedGraph() {
        this(size);
    }

    public void addEdge(int from, int to, double weight) {
        if (!checkBounds(from, to))
            throw new IllegalArgumentException("Invalid vertice");
        if (weight < 0)
            throw new IllegalArgumentException("Weight is negative");
        else
            adjacencyMatrix[from][to] = weight;
    }

    //weight of 1 will be assigned by default if weight is not given
    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public boolean existsEdge(int from, int to) {
        if (!checkBounds(from, to))
            throw new IllegalArgumentException("Invalid vertice");
        return adjacencyMatrix[from][to] != 0;
    }

    public boolean isConnected() {
        return numDisconnectedGraphs() == 1;
    }

    private boolean checkBounds(int from, int to) {
        return !(from < 0 || from > size - 1 || to < 0 || to > size - 1);
    }

    public double getEdgeWeight(int from, int to) {
        if (existsEdge(from, to))
            return adjacencyMatrix[from][to];
        else if (checkBounds(from, to))
            throw new IllegalArgumentException("Invalid vertice");
        else
            throw new IllegalArgumentException("Edge does not exist");
    }

    public ArrayList<Integer> getNeighbors(int vertice) {
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        for (int i = 0; i < size; i++)
            if (adjacencyMatrix[vertice][i] != 0)
                neighbors.add(i);
        return neighbors;
    }

    public ArrayList<Integer> breadthFirstSearchVisit(int start) {
        ArrayList<Integer> visitedVertices = new ArrayList<Integer>();
        boolean[] visited = new boolean[size];
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
        int tempVertex;
        visited[start] = true;
        queue.enqueue(start);
        while (!queue.isEmpty()) {
            tempVertex = queue.dequeue();
            visitedVertices.add(tempVertex);
            for (int i : getNeighbors(tempVertex))
                if (!visited[i]) {
                    visited[i] = true;
                    queue.enqueue(i);
                }
        }
        return visitedVertices;
    }

    public ArrayList<Integer> depthFirstSearchVisit(int start) {
        ArrayList<Integer> visitedVertices = new ArrayList<Integer>();
        return visitedVertices;
    }

    public int numDisconnectedGraphs() {
        boolean[] visited = new boolean[size];
        int count = 0;
        boolean done = false;
        ArrayList<Integer> vertices;
        while (true) {
            int vertex = firstUnvisited(visited);
            if (vertex == -1)
                break;
            else {
                vertices = breadthFirstSearchVisit(vertex);
                for (int i : vertices)
                    visited[i] = true;
            }
            count++;
        }


        return count;
    }

    public int firstUnvisited(boolean[] visited) {
        for (int i = 0; i < visited.length; i++)
            if (!visited[i])
                return i;
        return -1;
    }

    public boolean existPath(int from, int to) {
        return breadthFirstSearchVisit(from).contains(to);
    }

    public int[] singleSourceShortestPath(int from) {
        int[] paths = new int[size];
        boolean[] visited = new boolean[size];
        double[] distance = new double[size];
        for (int i = 0; i < size; i++)
            distance[i] = Double.POSITIVE_INFINITY;
        distance[from] = 0;
        for (int i = 0; i < size; i++) {
            int next = minVertex(distance, visited);
            visited[next] = true;
            ArrayList<Integer> n = getNeighbors(next);
            for (int j = 0; j < n.size(); j++) {
                int v = n.get(j);
                double d = distance[next] + adjacencyMatrix[v][next];
                if (d < distance[v]){
                    distance[v] = d;
                    paths[v] = next;
                }
            }
        }
        return paths;
    }

    private int minVertex(double[] distance, boolean[] visited) {
        double x = Double.MAX_VALUE;
        int y = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < x) {
                y = i;
                x = distance[i];
            }
        }
        return y;
    }
}
