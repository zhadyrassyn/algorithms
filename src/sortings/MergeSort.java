package sortings;

import java.util.Arrays;

public class MergeSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = l + ((r-l)/2);
        sort(arr, l, m);
        sort(arr, m + 1, r);
        merge(arr, l, m, r);

    }

    private static void merge(int[] arr, int l, int m, int r) {
        int[] L = new int[m-l+2];
        int[] R = new int[r-m+1];

        for(int i = 0; i < L.length - 1; i++) {
            L[i] = arr[l + i];
        }

        for(int i = 0; i < R.length - 1; i++) {
            R[i] = arr[m + i + 1];
        }

        L[L.length-1] = Integer.MAX_VALUE;
        R[R.length-1] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = l; k <= r; k++) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                ++i;
            } else {
                arr[k] = R[j];
                j++;
            }
        }
    }

    public static void sortDesc(int[] arr) {
        sortDesc(arr, 0, arr.length-1);
    }

    private static void sortDesc(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = l + ((r-l)/2);
        sortDesc(arr, l, m);
        sortDesc(arr, m+1, r);
        mergeDesc(arr, l, m, r);
    }

    private static void mergeDesc(int[] arr, int l, int m, int r) {
        int[] L = new int[m-l+2];
        int[] R = new int[r-m+1];

        for(int i = 0; i < L.length - 1; i++) {
            L[i] = arr[l + i];
        }

        for(int i = 0; i < R.length - 1; i++) {
            R[i] = arr[m + i + 1];
        }

        L[L.length-1] = Integer.MIN_VALUE;
        R[R.length-1] = Integer.MIN_VALUE;

        int i = 0, j = 0;
        for (int k = l; k <= r; k++) {
            if (L[i] > R[j]) {
                arr[k] = L[i];
                ++i;
            } else {
                arr[k] = R[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2, 3, 10, -1, 33, 10, 9, 8};

//        MergeSort.sort(arr);
        MergeSort.sortDesc(arr);

        System.out.println(Arrays.toString(arr));
    }
}
