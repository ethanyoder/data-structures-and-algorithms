/**
 * Created by Ethan on 10/5/2016.
 * This class will hold a specific version of a randomly generated maze.
 * Start and finish points and the walls will also be included.
 */

import java.awt.Point;
import java.util.*;

public class Maze {

    //declares members
    Point start, finish;
    int[][] maze;
    boolean[][] visitedPoints;
    double density;
    Stack<Character> stackStartFinish;
    Queue<Character> queueStartFinish;
    Random rand = new Random();

    //default constructor
    public Maze() {
        generateRandomMaze(rand.nextInt(25) + 4, rand.nextInt(25) + 4, rand.nextDouble());
    }

    //generates a random maze and points
    private void generateRandomMaze(int rows, int columns, double density) {
        maze = new int[rows][columns];
        this.density = density;
        generateMazeOuterWalls();
        generateRandomStartFinish();
        populateInnerMazeWalls();
    }

    private void generateRandomStartFinish() {
        int xMax = maze[0].length - 3;
        int yMax = maze.length - 3;
        int randomXStart = rand.nextInt(xMax) + 1;
        int randomYStart = rand.nextInt(yMax) + 1;
        int randomXFinish = rand.nextInt(xMax) + 1;
        int randomYFinish = rand.nextInt(yMax) + 1;
        start = new Point(randomXStart, randomYStart);
        finish = new Point(randomXFinish, randomYFinish);
    }

    private void generateMazeOuterWalls() {
        //makes the border be made up of all "walls", represented by 1s
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = 1;
            maze[i][maze[0].length - 1] = 1;
        }
        for (int i = 1; i < maze[0].length - 1; i++) {
            maze[0][i] = 1;
            maze[maze.length - 1][i] = 1;
        }
    }

    private void populateInnerMazeWalls() {
        for (int i = 1; i < maze.length - 1; i++)
            for (int j = 1; j < maze[0].length - 1; j++) {
                if (rand.nextDouble() < density)
                    maze[i][j] = 1;
            }

    }

    public void printMaze() {
        for (int[] i : maze) {
            for (int j : i)
                System.out.print(j);
            System.out.println();
        }
        System.out.println(start);
        System.out.println(finish);
    }



}
