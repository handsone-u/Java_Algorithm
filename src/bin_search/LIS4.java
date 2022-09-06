package bin_search;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LIS4 {
    static int n, ans;
    static int[] arr;
    static final ArrayList<Integer> lis = new ArrayList<>();

    static void solution() {
        lis.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
            } else {
                int index = upperBound(arr[i]);
                lis.set(index, arr[i]);
            }
        }

        ans = lis.size();
    }

    static int upperBound(int value) {
        int index = Collections.binarySearch(lis, value);
        return index >= 0 ?
                index : -index - 1;
    }

    static int binarySearch(int left, int right, int value) {
        while (left < right) {
            int mid = (left + right) / 2;
            if(lis.get(mid)>=value)
                right = mid;
            else
                left = mid + 1;
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution();

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }
}
