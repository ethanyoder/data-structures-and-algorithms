/**
 * Created by Ethan on 9/14/2016.
 * Tests the searching and sorting algorithm classes
 */

public class Driver {

    public static void main(String[] args) {
        int[] array = {9,9,8,7,6,5,5,4,3,2,1,1,1,2,2,1};
        BubbleSort.bubbleSortArray(array);
        for (int i : array)
            System.out.print(i);
    }

}
