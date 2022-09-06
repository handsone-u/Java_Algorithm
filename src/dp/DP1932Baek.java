package dp;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DP1932Baek {
    static int n, ans;
    static ArrayList<Integer>[] arr;
    static int[][] dp;

    private static void solution() {
        dp[1][0] = arr[1].get(0);

        for (int i = 2; i <= n ; i++) {
            for (int j = 0; j < i; j++) {
                int left = j - 1;
                int lValue, rValue;

                if(left>=0) lValue = dp[i - 1][left];
                else lValue = 0;
                if(j <=i-1) rValue = dp[i - 1][j];
                else rValue = 0;

                dp[i][j] = Integer.max(lValue, rValue) + arr[i].get(j);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        dp = new int[n + 1][n + 1];
        arr = new ArrayList[n + 1];

        for (int i = 1; i <= n ; i++) {
            arr[i] = Arrays.stream(reader.readLine().split(" "))
                    .map(Integer::valueOf)
                    .collect(Collectors.toCollection(ArrayList::new));
        }

        solution();

        ans = Arrays.stream(dp[n]).max().getAsInt();
        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }
}
