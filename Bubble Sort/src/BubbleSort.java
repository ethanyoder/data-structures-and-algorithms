/**
 * Created by Ethan on 9/14/2016.
 * This is a bubble sort implementation for arrays currently
 */

public class BubbleSort {

    public static void bubbleSortArray(int[] array) {
        int temporaryValue;
        int currentIndex;
        for (int index = 0; index < array.length; index++) {
            for (currentIndex = 0; currentIndex < array.length - index - 1; currentIndex++)
                if (array[currentIndex] > array[currentIndex + 1]) {
                    temporaryValue = array[currentIndex + 1];
                    array[currentIndex + 1] = array[currentIndex];
                    array[currentIndex] = temporaryValue;
                }
        }
    }

}
