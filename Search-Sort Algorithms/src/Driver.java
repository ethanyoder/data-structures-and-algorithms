/**
 * Created by Ethan on 9/14/2016.
 * Tests the searching and sorting algorithm classes
 */

public class Driver {

    public static void main(String[] args) {
        //test array to use
        int[] array = {13,12,11,10,9,8,7,6,5,4,3,2,1,0};
        //test value to search
        int value = 6;

        //tests bubble sort
        BubbleSort.bubbleSortArray(array);
        System.out.println("Sorted array (bubble sort): ");
        for (int i : array)
            System.out.print(i + ",");
        System.out.println();

        //tests linear search
        System.out.println("Index of target value (linear search): " + LinearSearch.linearSearchArray(array, value));

        //tests binary search
        System.out.println("Index of target value (binary search): " + BinarySearch.binarySearchArray(array, value));

    }

}
