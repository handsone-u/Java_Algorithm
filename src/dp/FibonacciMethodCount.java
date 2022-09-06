package dp;

import java.io.*;

/**
 * - 피보나치 수열.
 * n번째 수열을 구할때 0,1 번째 수열을 몇번 호출하는지 구하는 문제
 * n번째 DP[n][0], DP[n][1]배열에 0,1이 각각 몇번 호출하였는지
 * DP[n-1]의 요소를 참조하여 정답을 추론
 */
public class FibonacciMethodCount {
    static int t, n;
    static boolean[] visited;
    static int[][] dp;

    static void fibonacci(int x) {
        if(visited[x]) return;
        if (x == 0) {
            dp[0][0] = 1;
            dp[0][1] = 0;
        } else if (x == 1) {
            dp[1][0] = 0;
            dp[1][1] = 1;
        } else {
            fibonacci(x - 1);
            fibonacci(x - 2);
            dp[x][0] = dp[x - 1][0] + dp[x - 2][0];
            dp[x][1] = dp[x - 1][1] + dp[x - 2][1];
        }
        visited[x] = true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(reader.readLine());
        dp = new int[41][2];
        visited = new boolean[41];

        while (t-- > 0) {
            n = Integer.parseInt(reader.readLine());

            fibonacci(n);
            writer.write(String.valueOf(dp[n][0]) + " " + String.valueOf(dp[n][1]) + "\n");
        }
        reader.close();
        writer.flush();
        writer.close();
    }

}
