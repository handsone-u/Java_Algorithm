package dp;

import java.util.*;
import java.io.*;

public class Baek2631 {
    static int n,ans;
    static int[] arr,dp,last;
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        ans = n = Integer.parseInt(reader.readLine());
        arr = new int[n];
        dp = new int[n];
        last = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(reader.readLine());

        lis();

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }

    private static void lis() {
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j]>=arr[i]) continue;
                dp[i] = Integer.max(dp[i], dp[j] + 1);
            }

            ans = Integer.min(ans, n - dp[i]);
        }
    }
}
