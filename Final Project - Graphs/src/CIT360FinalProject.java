/**
 * Created by Ethan on 11/15/2016.
 * This program has the outputs from the assignments for the final project
 */

import java.io.*;
import java.util.*;

public class CIT360FinalProject {

    //declares objects
    private static WeightedDirectedGraph wdGraphFinal;
    private static Vertice[] vertices;
    private static int[][] routes;

    public static void main(String[] args) throws IOException {

        //Step C - populates graph with edges first
        WeightedDirectedGraph wdGraph = new WeightedDirectedGraph(6);
        wdGraph.addEdge(1,0,2);
        wdGraph.addEdge(1,5,2);
        wdGraph.addEdge(1,2,3);
        wdGraph.addEdge(2,1,1);
        wdGraph.addEdge(2,5,4);
        wdGraph.addEdge(3,2,9);
        wdGraph.addEdge(3,5,2);
        wdGraph.addEdge(3,4,3);
        wdGraph.addEdge(4,3,2);
        wdGraph.addEdge(4,5,4);
        wdGraph.addEdge(5,4,4);
        //Prints out results
        sectionHeader("C");
        System.out.println("\nVertices adjacent to V2: " + wdGraph.getNeighbors(2));
        System.out.println("Vertices adjacent to V5: " + wdGraph.getNeighbors(5) + "\n");

        //Section D - populates graph with edges first
        DirectedGraph dGraph = new DirectedGraph(6);
        dGraph.addEdge(1,0);
        dGraph.addEdge(1,5);
        dGraph.addEdge(1,2);
        dGraph.addEdge(2,1);
        dGraph.addEdge(2,5);
        dGraph.addEdge(3,2);
        dGraph.addEdge(3,5);
        dGraph.addEdge(3,4);
        dGraph.addEdge(4,3);
        dGraph.addEdge(4,5);
        dGraph.addEdge(5,4);
        //prints out results
        sectionHeader("D");
        System.out.println("\nVertices adjacent to V2: " + dGraph.getNeighbors(2));
        System.out.println("Vertices adjacent to V5: " + dGraph.getNeighbors(5) + "\n");

        //Section E - populates graph with edges first
        WeightedGraph wGraph = new WeightedGraph(6);
        wGraph.addEdge(0,1,2);
        wGraph.addEdge(1,2,1);
        wGraph.addEdge(1,5,2);
        wGraph.addEdge(2,5,4);
        wGraph.addEdge(2,3,9);
        wGraph.addEdge(3,5,2);
        wGraph.addEdge(3,4,2);
        wGraph.addEdge(4,5,4);
        //prints out results
        sectionHeader("E");
        System.out.println("\nVertices adjacent to V2: " + wGraph.getNeighbors(2));
        System.out.println("Vertices adjacent to V5: " + wGraph.getNeighbors(5) + "\n");

        //Section F - populates graph with edges first
        Graph graph = new Graph(6);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,5);
        graph.addEdge(2,5);
        graph.addEdge(2,3);
        graph.addEdge(3,5);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        //prints out results
        sectionHeader("F");
        System.out.println("\nVertices adjacent to V2: " + graph.getNeighbors(2));
        System.out.println("Vertices adjacent to V5: " + graph.getNeighbors(5) + "\n");

        //Section G
        sectionHeader("G");
        System.out.println("\nShortest path from V2 to V4: " + wdGraph.shortestPathFromTo(2,4) + "\n");

        //Section H
        sectionHeader("H");
        System.out.println("\nShortest path from V2 to V4: " + dGraph.shortestPathFromTo(2,4) + "\n");

        //Section I
        sectionHeader("I");
        System.out.println("\nShortest path from V2 to V4: " + wGraph.shortestPathFromTo(2,4) + "\n");

        //Section J
        sectionHeader("J");
        System.out.println("\nShortest path from V2 to V4: " + graph.shortestPathFromTo(2,4) + "\n");

        //Sections K,L - output here shows that vertices and edges have gone from the file to a graph
        sectionHeader("K,L");
        populateGraph();
        printGlobals();

        //Section M = output consists of directions, distance, and step-by-step route between locations
        sectionHeader("M");
        fromToInformation(routes[0][0],routes[0][1]);
        fromToInformation(routes[1][0],routes[1][1]);

    }

    private static void sectionHeader(String letter) {
        System.out.println("************************************");
        System.out.println("****Program Output for Section " + letter + "****");
        System.out.println("************************************");
    }

    //transfers the data from final.data to the graph and validates through console output
    private static void populateGraph() throws IOException {
        //sets up file input
        File f = new File("Final Project - Graphs\\final.data");
        Scanner sc = new Scanner(f);
        //creates graph and parallel vertice array based on first number in file
        int size = Integer.parseInt(sc.nextLine());
        wdGraphFinal = new WeightedDirectedGraph(size);
        vertices = new Vertice[size];
        //adds the vertices
        for (int i = 0; i < vertices.length; i++) {
            String[] locationParts = sc.nextLine().split(",");
            vertices[i] = new Vertice(Double.parseDouble(locationParts[1]),Double.parseDouble(locationParts[2]),locationParts[4]);
        }
        //adds the edges
        int numberEdges = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < numberEdges; i++) {
            String[] pathParts = sc.nextLine().split(" ");
            //checks third number to see if bidirectional or not
            if(Double.parseDouble(pathParts[2]) == 1) {
                wdGraphFinal.addEdge(Integer.parseInt(pathParts[0]),Integer.parseInt(pathParts[1]),getDistance(vertices[Integer.parseInt(pathParts[0])].longtitude,vertices[Integer.parseInt(pathParts[0])].latitude,vertices[Integer.parseInt(pathParts[1])].longtitude,vertices[Integer.parseInt(pathParts[1])].latitude));
            }
            else if (Double.parseDouble(pathParts[2]) == 2) {
                wdGraphFinal.addEdge(Integer.parseInt(pathParts[0]),Integer.parseInt(pathParts[1]),getDistance(vertices[Integer.parseInt(pathParts[0])].longtitude,vertices[Integer.parseInt(pathParts[0])].latitude,vertices[Integer.parseInt(pathParts[1])].longtitude,vertices[Integer.parseInt(pathParts[1])].latitude));
                wdGraphFinal.addEdge(Integer.parseInt(pathParts[1]),Integer.parseInt(pathParts[0]),getDistance(vertices[Integer.parseInt(pathParts[0])].longtitude,vertices[Integer.parseInt(pathParts[0])].latitude,vertices[Integer.parseInt(pathParts[1])].longtitude,vertices[Integer.parseInt(pathParts[1])].latitude));
            }
        }
        //finds the routes that a shortest path must be found for
        int numberRoutes = Integer.parseInt(sc.nextLine());
        routes = new int[numberRoutes][2];
        for (int i = 0; i < numberRoutes; i++) {
            String[] verticesInPath = sc.nextLine().split(" ");
            routes[i][0] = Integer.parseInt(verticesInPath[0]);
            routes[i][1] = Integer.parseInt(verticesInPath[1]);
        }
    }

    //gets the distance between two longitude-latitude coordinates
    private static double getDistance(double long1, double lat1, double long2, double lat2) {
        double R = 3961; // Radius of the earth in miles
        double dLat = degreesToRad(lat2-lat1);
        double dLon = degreesToRad(long2-long1);
        double a =
                Math.sin(dLat/2) * Math.sin(dLat/2) +
                        Math.cos(degreesToRad(lat1)) * Math.cos(degreesToRad(lat2)) *
                                Math.sin(dLon/2) * Math.sin(dLon/2)
                ;
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c;
        return d;
    }

    //converts degrees to radians
    private static double degreesToRad(double deg) {
        return deg * (Math.PI/180);
    }

    //prints out the vertices, edges, and routes instructed to find between vertices for validation
    private static void printGlobals() {
        System.out.println();
        //prints out the routes to be found
        System.out.println("Routes:");
        for (int[] i : routes) {
            System.out.print(i[0] + ",");
            System.out.println(i[1]);
        }
        //prints out the vertices
        System.out.println();
        System.out.println("Vertices:");
        for (Vertice i : vertices)
            System.out.println(i.longtitude + ", " + i.latitude + ", " + i.name);
        //prints out the edges with their weights
        System.out.println();
        System.out.println("Edges:");
        for (int i = 0; i < wdGraphFinal.adjacencyMatrix.length; i++)
            for (int j = 0; j < wdGraphFinal.adjacencyMatrix[0].length; j++) {
                if (wdGraphFinal.adjacencyMatrix[i][j] != 0)
                    System.out.println("Edge at " + i + " " + j + ": " + wdGraphFinal.adjacencyMatrix[i][j]);
            }
        System.out.println();
    }

    //outputs the vertice-to-vertice directions with turning instructions, and total distance
    private static void fromToInformation(int from, int to) {
        //total distance and shortest path section
        System.out.println("\n-----------------------------------");
        System.out.println("Directions from " + vertices[from].name + " to " + vertices[to].name);
        ArrayList<Integer> fromToPath = wdGraphFinal.shortestPathFromTo(from,to);
        System.out.println("\nSHORTEST PATH: ");
        double distance = 0;
        for (int i = 0; i < fromToPath.size(); i++) {
            if (i < fromToPath.size() - 1) {
                System.out.print(vertices[fromToPath.get(i)].name + " to ");
                distance += wdGraphFinal.adjacencyMatrix[fromToPath.get(i)][fromToPath.get(i + 1)];
            }
            else
                System.out.println(vertices[fromToPath.get(i)].name);
        }
        System.out.println("TOTAL DISTANCE: " + Math.round(distance * 100) / 100.0 + " miles");
        //specific set of directions section
        System.out.println("ROUTE: ");
        System.out.println("1. Start at " + vertices[from].name + " and head " + getNEWSDirection(from,fromToPath.get(1)) + " towards " + vertices[fromToPath.get(1)].name);
        String nextTurn;
        for (int i = 1; i < fromToPath.size(); i++) {
            if (i < fromToPath.size() - 1) {
                nextTurn = getDirection(vertices[fromToPath.get(i-1)].longtitude,vertices[fromToPath.get(i-1)].latitude,
                        vertices[fromToPath.get(i)].longtitude,vertices[fromToPath.get(i)].latitude,
                        vertices[fromToPath.get(i+1)].longtitude,vertices[fromToPath.get(i+1)].latitude);
                System.out.println((i + 1) + ". " + nextTurn + "at " + vertices[fromToPath.get(i)].name);
            }
            else
                System.out.println((i + 1) + ". Arrive at " + vertices[fromToPath.get(i)].name);
        }
        System.out.println("----------------------------------");
    }

    // returns direction that to is in respect to from
    private static String getNEWSDirection(int from, int to) {
        double longDiff, latDiff;
        if (vertices[to].longtitude > vertices[from].longtitude) {
            longDiff = vertices[to].longtitude - vertices[from].longtitude;
            if (vertices[to].latitude > vertices[from].latitude)
                latDiff = vertices[to].latitude - vertices[from].latitude;
            else
                latDiff = vertices[from].latitude - vertices[from].latitude;
            if (latDiff > longDiff / 2)
                return "south";
            else
                return "east";
        }
        else {
            longDiff = vertices[from].longtitude - vertices[to].longtitude;
            if (vertices[to].latitude > vertices[from].latitude)
                latDiff = vertices[to].latitude - vertices[from].latitude;
            else
                latDiff = vertices[from].latitude - vertices[from].latitude;
            if (latDiff > longDiff / 2)
                return "north";
            else
                return "west";
        }
    }

    //this method takes 3 vertices and returns which way to turn based on angle change
    public static String getDirection(double long1, double lat1, double long2, double lat2, double long3, double lat3) {
        double theta1 = getAngle(long1, lat1, long2, lat2);
        double theta2 = getAngle(long2, lat2, long3, lat3);
        double delta = normalizeAngle(theta2 - theta1);
        if (delta < Math.PI / 4.0 || delta > (7 * Math.PI) / 4.0)
            return "Continue straight ahead ";
        else if (delta == Math.PI)
            return "Turn around ";
        else if (delta < Math.PI)
            return "Turn left ";
        else
            return "Turn right ";
    }

    //this method gets and angle based on two coordinate points
    private static double getAngle(double long1, double lat1, double long2, double lat2) {
        double angleFromXAxis = Math.atan((lat2 - lat1) / (long2 - long1));
        return  long2 - long1 < 0 ? angleFromXAxis + Math.PI : angleFromXAxis;
    }

    //this method ensures the angle is in range
    private static double normalizeAngle(double angle) {
        return angle < 0 ? angle + 2 * Math.PI : angle;
    }
}
