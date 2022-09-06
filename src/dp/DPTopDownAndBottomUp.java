package dp;

import java.io.*;

/**
 * DP의 결과를 탑다운/버텀업 두 가지 방법으로 구하는 함수.
 * 탑다운 : Recursion 이용.
 * 버텀업 : For-Loop 이용.
 */
public class DPTopDownAndBottomUp {
    static int n;
    static int[] dp = new int[1000001];
    static int mod = 15746;

    public static void bottomUpDP() {
        for (int i = 3; i <= n; i++)
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
    }

    public static int topDownDP(int x) {
        if(dp[x]>0) return dp[x];
        return dp[x] = (topDownDP(x - 1) + topDownDP(x - 2)) % mod;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        reader.close();
        dp[1] = 1;
        dp[2] = 2;

        bottomUpDP();
//        topDownDP(n);

        writer.write(String.valueOf(dp[n] % mod));
        writer.flush();
        writer.close();
    }
}
