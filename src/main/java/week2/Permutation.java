package week2;

import week2.simpleSortings.ShellSort;

/**
 * Created by scher on 07.08.2019.
 * <p>
 * Given two integer arrays of size nn, design a subquadratic algorithm to determine whether one is a permutation of the other.
 * That is, do they contain exactly the same entries but, possibly, in a different order.
 */
public class Permutation {
    public boolean areTheSame(Integer[] arr1, Integer[] arr2) {
        if (arr1.length != arr2.length)
            return false;

        ShellSort sorter = new ShellSort();

        sorter.sort(arr1);
        sorter.sort(arr2);

        for (int i = 0; i < arr1.length; i++)
            if (arr1[i] != arr2[i])
                return false;

        return true;
    }
}
