package dp;

import java.io.*;
import java.util.Arrays;

/**
 * - LIS 응용
 * 전깃줄 문제
 * BaekJoon 2565
 */
public class LIS2 {
    static int n, ans;
    static int[] con = new int[501];
    static int[] dp = new int[501];

    static void solution() {
        for (int i = 1; i <= 500 ; i++) {
            if(con[i]==0) continue;
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if(con[i]<=con[j]) continue;
                dp[i] = Integer.max(dp[i], dp[j] + 1);
            }
        }

        ans = n - Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            con[input[0]] = input[1];
        }
        reader.close();

        solution();

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }
}
