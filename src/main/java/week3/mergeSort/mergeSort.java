package week3.mergeSort;

/**
 * Created by scher on 08.08.2019.
 */
public class mergeSort {

   public void sort(Integer[] arr) {
      sort(arr, 0, arr.length);
   }

   private void sort(Integer[] arr, int left, int right) {
      int mid = (right - left) / 2 + left;

      if (right - left > 1) {
         sort(arr, left, mid);
         sort(arr, mid, right);
      }

      Integer[] auxiliaryArr = new Integer[right - left];
      merge(auxiliaryArr, arr, left, right, mid);

      int j = 0;

      for (int i = 0; i < auxiliaryArr.length; i++) {
         arr[left + i] = auxiliaryArr[i];
      }
   }

   public void merge(Integer[] aux, Integer[] arr, Integer left, Integer right, int mid) {
      int leftIndex = left;
      int midIndex = mid;

      for (int i = 0; i < right - left; i++) {
         if (midIndex == right) {
            aux[i] = arr[leftIndex++];
         } else if (leftIndex == mid) {
            aux[i] = arr[midIndex++];
         } else if (arr[leftIndex] < arr[midIndex]) {
            aux[i] = arr[leftIndex++];
         } else {
            aux[i] = arr[midIndex++];
         }
      }
   }
}
