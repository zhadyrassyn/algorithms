package dataStructure.trees;

import java.util.Arrays;

/*
 * A Fenwick tree or binary indexed tree is a data structure providing efficient methods
 * for calculation and manipulation of the prefix sums of a table of values.
 *
 * Space complexity for fenwick tree is O(n)
 * Time complexity to create fenwick tree is O(nlogn)
 * Time complexity to update value is O(logn)
 * Time complexity to get prefix sum is O(logn)
 *
 * References
 * http://www.geeksforgeeks.org/binary-indexed-tree-or-fenwick-tree-2/
 * https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
 * http://en.wikipedia.org/wiki/Fenwick_tree
 */

public class FenwickTree {

    /**
     * Creating tree is like updating Fenwick tree for every value in array
     */
    private int[] createBinaryIndexedTree(int[] arr) {
        int N = arr.length + 1;
        int[] binaryIndexedTree = new int[N];

        for(int i = 1; i < N; i++) {
            updateBinaryIndexedTree(binaryIndexedTree, i, arr[i-1]);
        }

        return binaryIndexedTree;
    }

    private void updateBinaryIndexedTree(int[] binaryIndexedTree, int index, int value) {
        while(index < binaryIndexedTree.length) {
            binaryIndexedTree[index] += value;
            index = getNext(index);
        }
    }

    /**
     * To get next
     * 1) 2's complement of get minus of index
     * 2) AND this with index
     * 3) Add it to index
     */
    private int getNext(int index) {
        return index + (index & -index);
    }

    /**
     * To get parent
     * 1) 2's complement to get minus of index
     * 2) AND this with index
     * 3) Subtract that from index
     */
    private int getParent(int index) {
        return index - (index & -index);
    }

    private int getSum(int[] binaryIndexedTree, int index) {
        int sum = 0;
        ++index;

        while(index > 0) {
            sum += binaryIndexedTree[index];
            index = getParent(index);
            System.out.println("index: " + index);
        }

        return sum;
    }

    public static void main(String[] args) {
        int [] arr = {3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};
        FenwickTree fenwickTree = new FenwickTree();
        int[] binaryIndexedTree = fenwickTree.createBinaryIndexedTree(arr);
        System.out.println(Arrays.toString(binaryIndexedTree));
        System.out.println(fenwickTree.getSum(binaryIndexedTree, 3));
    }
}
