package week3.mergeSort;

/**
 * Created by scher on 10.08.2019.
 */
public class Helper {
    public int permutations(int[] arr) {
        int rez = 0;

        for (int j = 0; j<arr.length; j++) {
            for (int i=0; i < j; i++) {
                if(arr[i] > arr[j]) rez++;
            }
        }

        return rez;
    }
}
