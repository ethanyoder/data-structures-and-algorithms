/**
 * Created by Ethan on 10/5/2016.
 * This class contains methods that find the paths from start to finish,
 * using the breadth-first algorithm that involves a Queue.
 */

import java.awt.*;

public class BreadthFirstMazePath {

    //declares members - this includes a maze, foundQueue flag, current point,
    //and distance from the current point to the start
    Maze maze;
    LinkedQueue<Point> queueStartFinish = new LinkedQueue<Point>();
    boolean foundQueue = false;
    Point currentPoint = new Point();
    int distance = 1;

    //overloaded constructor that accepts a maze object
    public BreadthFirstMazePath(Maze m) {
        maze = m;
        createPrintedMazePath();
        //the starting point is defined here as the current location
        //and is the first point to go into the queue
        currentPoint.setLocation(maze.start.getX(), maze.start.getY());
        queueStartFinish.enqueue(new Point((int)maze.start.getX(), (int)maze.start.getY()));
    }

    //this method takes the logical maze and puts it into a more user friendly
    //maze that involves characters instead of numbers
    private void createPrintedMazePath() {
        for (int i = 0; i < maze.maze.length; i++)
            for (int j = 0; j < maze.maze[i].length; j++) {
                switch (maze.maze[i][j]) {
                    case -1 :
                        maze.printedMazePath[i][j] = "W";
                        maze.originalMaze[i][j] = "W";
                        break;
                    case 0 :
                        maze.printedMazePath[i][j] = "O";
                        maze.originalMaze[i][j] = "O";
                        break;
                    case 1 :
                        maze.printedMazePath[i][j] = "S";
                        maze.originalMaze[i][j] = "S";
                        break;
                    case 99 :
                        maze.printedMazePath[i][j] = "F";
                        maze.originalMaze[i][j] = "F";
                        break;
                    default :
                        maze.printedMazePath[i][j] = Integer.toString(maze.maze[i][j]);
                        maze.originalMaze[i][j] = Integer.toString(maze.maze[i][j]);
                }
            }
    }

    //this is the controller method for the breadth-first search
    public void findFinishQueue() {
        //this loop takes all points of the same distance from start and sets their surroundings to the number above
        while (!foundQueue && distance < maze.maze.length * maze.maze[0].length) {
            while (maze.maze[(int)queueStartFinish.first().getY()][(int)queueStartFinish.first().getX()] == distance)
            {
                checkAndMarkSurroundings(queueStartFinish.dequeue());
            }
            distance ++;
        }
        if (foundQueue) {
            System.out.println("Path Found!");
        }
        else
            System.out.println("No Path Found");
    }

    //this method only will mark valid points - no walls are given numbers
    private void checkAndMarkSurroundings(Point currentPoint) {
        if (maze.finish.getX() == currentPoint.getX() && maze.finish.getY() == currentPoint.getY()) {
            foundQueue = true;
            return;
        }
        //checks maze point north of current point
        if (maze.maze[(int)currentPoint.getY() - 1][(int)currentPoint.getX()] == 0) {
            maze.maze[(int)currentPoint.getY() - 1][(int)currentPoint.getX()] = distance + 1;
            queueStartFinish.enqueue(new Point((int)currentPoint.getX(), (int)currentPoint.getY() - 1));
        }
        else if (maze.finish.getX() == currentPoint.getX() && maze.finish.getY() - 1 == currentPoint.getY()) {
            foundQueue = true;
            return;
        }
        //checks maze point south of current point
        if (maze.maze[(int)currentPoint.getY() + 1][(int)currentPoint.getX()] == 0) {
            maze.maze[(int)currentPoint.getY() + 1][(int)currentPoint.getX()] = distance + 1;
            queueStartFinish.enqueue(new Point((int)currentPoint.getX(), (int)currentPoint.getY() + 1));
        }
        else if (maze.finish.getX() == currentPoint.getX() && maze.finish.getY() + 1 == currentPoint.getY()) {
            foundQueue = true;
            return;
        }
        //checks maze point east of current point
        if (maze.maze[(int)currentPoint.getY()][(int)currentPoint.getX() + 1] == 0) {
            maze.maze[(int)currentPoint.getY()][(int)currentPoint.getX() + 1] = distance + 1;
            queueStartFinish.enqueue(new Point((int)currentPoint.getX() + 1, (int)currentPoint.getY()));
        }
        else if (maze.finish.getX() == currentPoint.getX() + 1 && maze.finish.getY() == currentPoint.getY()) {
            foundQueue = true;
            return;
        }
        //checks maze point west of current point
        if (maze.maze[(int)currentPoint.getY()][(int)currentPoint.getX() - 1] == 0) {
            maze.maze[(int)currentPoint.getY()][(int)currentPoint.getX() - 1] = distance + 1;
            queueStartFinish.enqueue(new Point((int)currentPoint.getX() - 1, (int)currentPoint.getY()));
        }
        else if (maze.finish.getX() == currentPoint.getX() - 1 && maze.finish.getY() == currentPoint.getY()) {
            foundQueue = true;
            return;
        }
    }

    //this method starts at the finish and finds its way to the start, marking its path on the maze
    public void getMazePath() {
        Point currentPoint = new Point((int)maze.finish.getX(), (int)maze.finish.getY());
        int distanceDecliner = 1;
        while (currentPoint.getX() != maze.start.getX() || currentPoint.getY() != maze.start.getY()) {
            //checks north for way back
            if (maze.maze[(int)currentPoint.getY() - 1][(int)currentPoint.getX()] == distance - distanceDecliner) {
                currentPoint.setLocation((int)currentPoint.getX(), (int)currentPoint.getY() - 1);
                maze.printedMazePath[(int)currentPoint.getY()][(int)currentPoint.getX()] = "P";
            }
            //checks south for way back
            else if (maze.maze[(int)currentPoint.getY() + 1][(int)currentPoint.getX()] == distance - distanceDecliner) {
                currentPoint.setLocation((int)currentPoint.getX(), (int)currentPoint.getY() + 1);
                maze.printedMazePath[(int)currentPoint.getY()][(int)currentPoint.getX()] = "P";
            }
            //checks east for way back
            else if (maze.maze[(int)currentPoint.getY()][(int)currentPoint.getX() + 1] == distance - distanceDecliner) {
                currentPoint.setLocation((int)currentPoint.getX() + 1, (int)currentPoint.getY());
                maze.printedMazePath[(int)currentPoint.getY()][(int)currentPoint.getX()] = "P";
            }
            //checks west for way back
            else if (maze.maze[(int)currentPoint.getY()][(int)currentPoint.getX() - 1] == distance - distanceDecliner) {
                currentPoint.setLocation((int) currentPoint.getX() - 1, (int) currentPoint.getY());
                maze.printedMazePath[(int) currentPoint.getY()][(int) currentPoint.getX()] = "P";
            }
            distanceDecliner ++;
        }
        maze.printedMazePath[(int)maze.start.getY()][(int)maze.start.getX()] = "S";
    }

}
