/**
 * Created by Ethan on 9/16/2016.
 * This is a binary search implementation
 */
public class BinarySearch {

    //declares members
    static int begin = 0;
    static int end;
    static int midpoint;

    public static int binarySearchArray(int[] array, int value) {
        //declares members
        end = array.length - 1;
        //loops until end is no longer greater than begin
        while (end > begin) {
            midpoint = (end + begin) / 2;
            if (array[midpoint] == value)
                return midpoint;
            else if (array[midpoint] > value)
                end = midpoint;
            else
                begin = midpoint;
        }
        return -1;
    }

}
