package sortings;

import java.util.Arrays;

public class SelectionSort {
    public static void sortAsc(int[] arr) {
        int N = arr.length;
        for (int i = 0; i < N - 1; i++) {
            int min = arr[i];
            int minIndex = i;
            for(int j = i + 1; j < N; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    public static void sortDesc(int[] arr) {
        int N = arr.length;
        for(int i = 0; i < N - 1; i++) {
            int max = arr[i];
            int maxIndex = i;
            for(int j = i + 1; j < N; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }

            swap(arr, i, maxIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 3, 10, -1, 33, 10, 9, 8};
//        SelectionSort.sortAsc(arr);
        SelectionSort.sortDesc(arr);
        System.out.println(Arrays.toString(arr));
    }
}
