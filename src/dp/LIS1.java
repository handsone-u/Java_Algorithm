package dp;

import java.io.*;
import java.util.Arrays;

/**
 * - LIS(the Longest Increasing Subsequence)
 * BaekJoon 11053
 */
public class LIS1 {
    static int n, ans;
    static int[] arr;
    static int[] dp;

    static void solution() {
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[i]<=arr[j]) continue;
                dp[i] = Integer.max(dp[i], dp[j] + 1);
            }
        }

        ans = Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        dp = new int[n + 1];
        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        solution();

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }
}
