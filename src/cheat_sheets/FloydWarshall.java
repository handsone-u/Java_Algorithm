package cheat_sheets;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FloydWarshall {
    static int n, m;
    static int[][] dp;
    static ArrayList<Integer>[] v;

    static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(dp[i][k]==0||dp[k][j]==0) continue;
                    if(dp[i][j]==0)
                        dp[i][j] = dp[i][k] + dp[k][j];
                    else
                        dp[i][j] = Integer.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
    }

    static int getAns() {
        int min = Integer.MAX_VALUE;
        int ans = 1;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if(i==j) continue;
                count += dp[i][j];
            }
            if(count<min){
                min = count;
                ans = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        input(reader);

        floydWarshall();
        int ans = getAns();

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }

    private static void input(BufferedReader reader) throws IOException {
        int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = tmp[0];
        m = tmp[1];
        v = new ArrayList[n + 1];
        dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) v[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            v[tmp[0]].add(tmp[1]);
            v[tmp[1]].add(tmp[0]);
            dp[tmp[0]][tmp[1]] = dp[tmp[1]][tmp[0]] = 1;
        }
    }
}
