package bin_search;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * - LIS.
 * O(N*log(N)) -> DP 보다 빠름
 * Binary Search, LowerBound
 * Lis 에 들어있는 요소들은 실제 LIS 와 무관
 */
public class LIS3 {
    static int n, ans;
    static int[] arr;
    static final ArrayList<Integer> lis = new ArrayList<>();

    static void solution() {
        lis.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > lis.get(lis.size() - 1)) {
                lis.add(arr[i]);
            } else{
                int index = lowerBound(arr[i]);
                lis.set(index + 1, arr[i]);
            }
        }

        ans = lis.size();
    }

    static int lowerBound(int value) {
        int index = Collections.binarySearch(lis, value);
        if (index >= 0) {
            return index;
        } else {
            return -1 - index;
        }
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
