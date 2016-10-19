/**
 * Created by Ethan on 10/5/2016.
 * This class will create maze objects and path objects and then use it's methods to find paths from start to finish
 */

public class MazeDriver {

    public static void main(String[] args) {
        //creates maze, breadth-first, and depth-first objects
        Maze m = new Maze();
        BreadthFirstMazePath b = new BreadthFirstMazePath(m);
        DepthFirstMazePath a = new DepthFirstMazePath(m);

        //prints out the original maze with no path
        m.resetMaze();
        System.out.println("-------ORIGINAL MAZE-------------");
        System.out.println(m.printOriginalMaze());

        //prints out the maze with the depth-first search path
        m.resetMaze();
        System.out.println("-------DEPTH-FIRST SEARCH--------");
        a.findFinishStack();
        a.putPathOnMaze();
        System.out.println(m.printMazePath());

        //prints out the maze with the breadth-first search path
        m.resetMaze();
        System.out.println("-------BREADTH-FIRST SEARCH------");
        b.findFinishQueue();
        b.getMazePath();
        System.out.println(m.printMazePath());
    }
}
