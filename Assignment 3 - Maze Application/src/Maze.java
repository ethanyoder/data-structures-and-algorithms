/**
 * Created by Ethan on 10/5/2016.
 * This class will hold a specific version of a randomly generated maze.
 * Start and finish points and the walls will also be included.
 */

import java.awt.Point;
import java.util.Random;

public class Maze {

    //declares members
    Point start, finish, mazeWallLocation;
    String[][] printedMazePath;
    String[][] originalMaze;
    int[][] maze;
    int numWalls;
    boolean[][] visitedPoints;
    char[] direction = {'N', 'S', 'E', 'W'};
    Random rand = new Random();

    //default constructor
    public Maze() {
        generateRandomMaze(rand.nextInt(25) + 8, rand.nextInt(25) + 8);
    }

    //generates a random maze and points
    private void generateRandomMaze(int rows, int columns) {
        maze = new int[rows][columns];
        createVisitedPoints();
        generateMazeOuterWalls();
        populateInnerMazeWalls();
        generateRandomStartFinish();
        printedMazePath = new String[maze.length][maze[0].length];
        originalMaze = new String[maze.length][maze[0].length];
    }

    private void generateRandomStartFinish() {
        int xMax = maze[0].length - 3;
        int yMax = maze.length - 3;
        boolean foundStart = false, foundFinish = true;
        int randomXStart = rand.nextInt(xMax) + 1;
        int randomYStart = rand.nextInt(yMax) + 1;
        int randomXFinish = rand.nextInt(xMax) + 1;
        int randomYFinish = rand.nextInt(yMax) + 1;
        while (!foundStart) {
            if (maze[randomYStart][randomXStart] != -1)
                foundStart = true;
            else {
                randomXStart = rand.nextInt(xMax) + 1;
                randomYStart = rand.nextInt(yMax) + 1;
            }
        }
        while (!foundFinish) {
            if (maze[randomYFinish][randomXFinish] != -1 && randomXStart != randomXFinish && randomYStart != randomYFinish)
                foundFinish = true;
            else {
                randomXFinish = rand.nextInt(xMax) + 1;
                randomYFinish = rand.nextInt(yMax) + 1;
            }
        }
        start = new Point(randomXStart, randomYStart);
        visitedPoints[randomYStart][randomXStart] = true;
        finish = new Point(randomXFinish, randomYFinish);
        //visitedPoints[randomYFinish][randomXFinish] = true;
        maze[(int)start.getY()][(int)start.getX()] = 1;
        maze[(int)finish.getY()][(int)finish.getX()] = 99;
    }

    private void generateMazeOuterWalls() {
        //makes the border be made up of all "walls", represented by 1s
        for (int i = 0; i < maze.length; i++) {
            maze[i][0] = -1;
            maze[i][maze[0].length - 1] = -1;
            visitedPoints[i][0] = true;
            visitedPoints[i][maze[0].length - 1] = true;
        }
        for (int i = 1; i < maze[0].length - 1; i++) {
            maze[0][i] = -1;
            maze[maze.length - 1][i] = -1;
            visitedPoints[0][i] = true;
            visitedPoints[maze.length - 1][i] = true;
        }
    }

    private void populateInnerMazeWalls() {
        mazeWallLocation = new Point();
        numWalls = (int)(Math.sqrt(maze.length * maze[0].length));
        char currentDirection;
        for (int i = 0; i < numWalls; i++) {
            currentDirection = direction[rand.nextInt(4)];
            switch (currentDirection) {
                case 'N':
                    createNorthWall();
                    break;
                case 'S':
                    createSouthWall();
                    break;
                case 'E':
                    createEastWall();
                    break;
                case 'W':
                    createWestWall();
                    break;
            }
        }
    }

    private void createNorthWall() {
        mazeWallLocation.setLocation(rand.nextInt(maze[0].length - 3) + 1, rand.nextInt(maze.length - 3) + 1);
        int wallLength = (int)Math.sqrt(rand.nextInt(numWalls));
        for (int i = 0; i < wallLength; i++) {
            if (mazeWallLocation.getY() > 1) {
                maze[(int) mazeWallLocation.getY()][(int) mazeWallLocation.getX()] = -1;
                visitedPoints[(int)mazeWallLocation.getY()][(int)mazeWallLocation.getX()] = true;
                mazeWallLocation.setLocation(mazeWallLocation.getX(), mazeWallLocation.getY() - 1);
            }
            else
                break;
        }
    }

    private void createSouthWall() {
        mazeWallLocation.setLocation(rand.nextInt(maze[0].length - 3) + 1, rand.nextInt(maze.length - 3) + 1);
        int wallLength = (int)Math.sqrt(rand.nextInt(numWalls));
        for (int i = 0; i < wallLength; i++) {
            if (mazeWallLocation.getY() < maze.length -1) {
                maze[(int) mazeWallLocation.getY()][(int) mazeWallLocation.getX()] = -1;
                visitedPoints[(int)mazeWallLocation.getY()][(int)mazeWallLocation.getX()] = true;
                mazeWallLocation.setLocation(mazeWallLocation.getX(), mazeWallLocation.getY() + 1);
            }
            else
                break;
        }
    }

    private void createEastWall() {
        mazeWallLocation.setLocation(rand.nextInt(maze[0].length - 3) + 1, rand.nextInt(maze.length - 3) + 1);
        int wallLength = (int)Math.sqrt(rand.nextInt(numWalls));
        for (int i = 0; i < wallLength; i++) {
            if (mazeWallLocation.getX() < maze[0].length - 1) {
                maze[(int) mazeWallLocation.getY()][(int) mazeWallLocation.getX()] = -1;
                visitedPoints[(int)mazeWallLocation.getY()][(int)mazeWallLocation.getX()] = true;
                mazeWallLocation.setLocation(mazeWallLocation.getX() + 1, mazeWallLocation.getY());
            }
            else
                break;
        }
    }

    private void createWestWall() {
        mazeWallLocation.setLocation(rand.nextInt(maze[0].length - 3) + 1, rand.nextInt(maze.length - 3) + 1);
        int wallLength = (int)Math.sqrt(rand.nextInt(numWalls));
        for (int i = 0; i < wallLength; i++) {
            if (mazeWallLocation.getX() > 1) {
                maze[(int) mazeWallLocation.getY()][(int) mazeWallLocation.getX()] = -1;
                visitedPoints[(int)mazeWallLocation.getY()][(int)mazeWallLocation.getX()] = true;
                mazeWallLocation.setLocation(mazeWallLocation.getX() - 1, mazeWallLocation.getY());
            }
            else
                break;
        }
    }

    private void createVisitedPoints() {
        visitedPoints = new boolean[maze.length][maze[0].length];
    }

    public void resetMaze() {
        for (int i = 0; i < maze.length; i++)
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] != -1 && maze[i][j] != 1 && maze[i][j] != 99)
                    maze[i][j] = 0;
                if (printedMazePath[i][j].equals("P"))
                    printedMazePath[i][j] = "O";
            }
    }

    public String printMazePath() {
        String output = "W means a wall, O means an empty space, S means start, F means finish, P means path\n";
        output += "-------------------------------------------------------------------\n";
        for (String[] i : printedMazePath) {
            for (String j : i) {
                output += j;
                output += "\t";
            }
            output += "\n";
        }
        return output;
    }

    public String printOriginalMaze() {
        String output = "W means a wall, O means an empty space, S means start, F means finish, P means path\n";
        output += "-------------------------------------------------------------------\n";
        for (String[] i : originalMaze) {
            for (String j : i) {
                output += j;
                output += "\t";
            }
            output += "\n";
        }
        return output;
    }
}
