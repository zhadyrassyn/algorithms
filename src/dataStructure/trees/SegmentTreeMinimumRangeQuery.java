package dataStructure.trees;

import bits.NextPowerOf2;

public class SegmentTreeMinimumRangeQuery {

    public int[] createSegmentTree(int[] input) {
        NextPowerOf2 np2 = new NextPowerOf2();

        int nextPowOfTwo = np2.nextPowerOf2(input.length);
        int[] segmentTree = new int[nextPowOfTwo * 2 - 1];

        for(int i = 0; i < segmentTree.length; i++) {
            segmentTree[i] = Integer.MAX_VALUE;
        }

        constructMinSegmentTree(segmentTree, input, 0, input.length - 1, 0);
        return segmentTree;
    }

    public int rangeMinimumQuery(int[] segmentTree, int qlow, int qhigh, int len) {
        return rangeMinimumQuery(segmentTree, 0, len-1, qlow, qhigh, 0);
    }

    private int rangeMinimumQuery(int[] segmentTree, int low, int high, int qlow, int qhigh, int pos) {
        if (qlow <= low && qhigh >= high) {
            return segmentTree[pos];
        }


        if (qlow > high || qhigh < low) {
            return Integer.MAX_VALUE;
        }

        int mid = (low + high) / 2;
        return Math.min(
                rangeMinimumQuery(segmentTree, low, mid, qlow, qhigh, 2 * pos + 1),
                rangeMinimumQuery(segmentTree, mid + 1, high, qlow, qhigh, 2 * pos + 2)
                );
    }


    private void constructMinSegmentTree(int[] segmentTree, int[] input, int low, int high, int pos) {
        if (low == high) {
            segmentTree[pos] = input[low];
            return;
        }

        int mid = (low + high) / 2;
        constructMinSegmentTree(segmentTree, input, low, mid, 2 * pos + 1);
        constructMinSegmentTree(segmentTree, input, mid + 1, high, 2 * pos + 2);
        segmentTree[pos] = Math.min(segmentTree[2 * pos + 1], segmentTree[2 * pos + 2]);
    }


    public static void main(String[] args) {
        SegmentTreeMinimumRangeQuery st = new SegmentTreeMinimumRangeQuery();

        int[] input = {0, 10, 3, -1};
        int[] segmentTree = st.createSegmentTree(input);

        System.out.println(st.rangeMinimumQuery(segmentTree, 1, 3, input.length));
    }
}
