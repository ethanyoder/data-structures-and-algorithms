/**
 * Created by Ethan on 9/16/2016.
 * This is a linear search implementation
 */
public class LinearSearch {

    public static int linearSearchArray(int[] array, int value) {
        for(int i = 0; i < array.length; i++)
            if (array[i] == value)
                return i;
        return -1;
    }

}
