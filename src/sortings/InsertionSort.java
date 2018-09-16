package sortings;

import java.util.Arrays;

public class InsertionSort {

    public static void sortAsc(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int num = arr[i];

            int j = i - 1;
            while (j >= 0 && arr[j] > num) {
                arr[j+1] = arr[j];
                --j;
            }
            arr[j+1] = num;
        }
    }

    public static void sortDesc(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];

            int j = i-1;
            while (j >= 0 && arr[j] < num) {
                arr[j+1] = arr[j];
                --j;
            }

            arr[j+1] = num;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 10, 1};

        InsertionSort.sortAsc(arr);
        InsertionSort.sortDesc(arr);

        System.out.println(Arrays.toString(arr));
    }
}
