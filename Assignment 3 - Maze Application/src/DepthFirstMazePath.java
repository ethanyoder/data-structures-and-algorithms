/**
 * Created by Ethan on 10/17/2016.
 * This class contains methods that find a path from start to finish,
 * using the depth-first algorithm that involves a Stack.
 */

import java.awt.Point;
import java.util.*;

public class DepthFirstMazePath {

    //declares members
    Stack<Point> stk;
    Maze maze;

    //overloaded constructor that accepts a maze object
    public DepthFirstMazePath(Maze m) {
        maze = m;
        stk = new Stack<Point>();
    }

    //this method is the "controller" of the algorithm
    public void findFinishStack() {
        //the start point is first pushed onto the stack and sent for its surroundings to be checked
        stk.push(maze.start);
        checkSurroundings(maze.start);
        //this loop continues to send points to the checkSurroundings method until the finish is found
        while (!stk.isEmpty()) {
            if (stk.peek().getX() == maze.finish.getX() && stk.peek().getY() == maze.finish.getY()) {
                System.out.println("Path Found!");
                break;
            }
            else {
                Point tp = stk.peek();
                checkSurroundings(tp);
            }
        }
        if (stk.isEmpty()) {
            System.out.println("No Path Found");
        }
        else
            putPathOnMaze();
    }

    //this method will look for a valid direction to make a new point in
    public void checkSurroundings(Point p) {
        if (!maze.visitedPoints[(int)p.getY() - 1][(int)p.getX()]) {
            stk.push(new Point((int)p.getX(), (int)p.getY() - 1));
            maze.visitedPoints[(int)p.getY() - 1][(int)p.getX()] = true;
        }
        else if (!maze.visitedPoints[(int)p.getY()][(int)p.getX() - 1]) {
            stk.push(new Point((int)p.getX() - 1, (int)p.getY()));
            maze.visitedPoints[(int)p.getY()][(int)p.getX() - 1] = true;
        }
        else if (!maze.visitedPoints[(int)p.getY() + 1][(int)p.getX()]) {
            stk.push(new Point((int)p.getX(), (int)p.getY() + 1));
            maze.visitedPoints[(int)p.getY() + 1][(int)p.getX()] = true;
        }
        else if (!maze.visitedPoints[(int)p.getY()][(int)p.getX() + 1]) {
            stk.push(new Point((int)p.getX() + 1, (int)p.getY()));
            maze.visitedPoints[(int)p.getY()][(int)p.getX() + 1] = true;
        }
        //if there is no where to go, the pop method will backtrack the path
        else
            stk.pop();
    }

    //this method takes the points in the final stack and puts a P for path on each point
    public void putPathOnMaze() {
        while (!stk.isEmpty()) {
            Point tp = stk.pop();
            maze.printedMazePath[(int)tp.getY()][(int)tp.getX()] = "P"/*Integer.toString(count)*/;
        }
        maze.printedMazePath[(int)maze.finish.getY()][(int)maze.finish.getX()] = "F";
        maze.printedMazePath[(int)maze.start.getY()][(int)maze.start.getX()] = "S";
    }
}
