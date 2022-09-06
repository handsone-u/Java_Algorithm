package dataStructure;

import java.io.*;
import java.util.Arrays;

public class SegmentTreeLazy {
    static long[] arr;
    static long[] segmentTree;
    static long[] lazy;

    static long initSegmentTree(int start, int end, int index) {
        if (start == end) {
            return segmentTree[index] = arr[start];
        }
        int mid = (start + end) / 2;
        return segmentTree[index] = initSegmentTree(start, mid, index * 2)
                + initSegmentTree(mid + 1, end, index * 2 + 1);
    }

    static void updateLazy(int start, int end, int index, int targetStart, int targetEnd, long value) {
        propagate(start, end, index);
        if(targetStart>end||targetEnd<start) return;
        if (targetStart <= start && end <= targetEnd) {
            lazy[index] = value;
            propagate(start, end, index);
            return;
        }
        int mid = (start + end) / 2;
        updateLazy(start, mid, index * 2, targetStart, targetEnd, value);
        updateLazy(mid + 1, end, index * 2 + 1, targetStart, targetEnd, value);
        segmentTree[index] = segmentTree[index * 2] + segmentTree[index * 2 + 1];
    }

    static void propagate(int start, int end, int index) {
        if (lazy[index] == 0) {
            return;
        }
        if(hasChild(start, end)) {
            lazy[index * 2] += lazy[index];
            lazy[index * 2 + 1] += lazy[index];
        }
        segmentTree[index] += lazy[index] * (end - start + 1);
        lazy[index] = 0;
    }

    private static boolean hasChild(int start, int end) {
        return start != end;
    }

    static long rangeLazy(int start, int end, int index, int from, int to) {
        propagate(start,end, index);
        if(end<from||start>to) return 0;
        if(start==end) return segmentTree[index];
        if(from<=start&&end<=to) return segmentTree[index];

        int mid = (start + end) / 2;
        return rangeLazy(start, mid, index * 2, from, to)
                + rangeLazy(mid + 1, end, index * 2 + 1, from, to);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nmk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = nmk[0];
        int m = nmk[1];
        int k = nmk[2];
        arr = new long[n];
        segmentTree = new long[4 * n + 1];
        lazy = new long[4 * n + 1];

        for (int i = 0; i < n; i++) arr[i] = Long.parseLong(reader.readLine());
        initSegmentTree(0, n - 1, 1);

        for (int i = 0; i < m + k; i++) {
            String[] abcd = reader.readLine().split(" ");
            int a = Integer.parseInt(abcd[0]);
            int b = Integer.parseInt(abcd[1])-1;
            int c = Integer.parseInt(abcd[2])-1;

            if (a == 1) {
                long d = Long.parseLong(abcd[3]);
                updateLazy(0, n - 1, 1, b, c, d);
            } else {
                writer.write(Long.toString(rangeLazy(0, n - 1, 1, b, c)));
                writer.write('\n');
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }
}
