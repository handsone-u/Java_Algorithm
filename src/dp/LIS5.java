package dp;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class LIS5 {
    static int n,ans;
    static int[] arr,dp,track;

    static void solution() {
        int maxIndex = 0;
        dp[0] = 1;
        track[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            track[i] = i;
            for (int j = 0; j < i; j++) {
                if (arr[i] <= arr[j]) continue;
                if (dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    track[i] = j;
                }
            }
            if(dp[maxIndex]<dp[i])
                maxIndex = i;
        }

        ans = maxIndex;
    }

    static void printResult(int index, BufferedWriter writer) throws IOException {
        Stack<Integer> stack = new Stack<>();
        while (index != track[index]) {
            stack.add(arr[index]);
            index = track[index];
        }
        stack.add(arr[index]);

        while (!stack.isEmpty()) {
            writer.write(String.valueOf(stack.pop()));
            writer.write(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        dp = new int[n + 1];
        track = new int[n + 1];

        solution();

        writer.write(String.valueOf(Arrays.stream(dp).max().getAsInt()) + "\n");
        printResult(ans, writer);
        writer.flush();
        writer.close();
    }
}
