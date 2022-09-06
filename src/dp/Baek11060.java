package dp;

import java.io.*;
import java.util.Arrays;

public class Baek11060 {
    static int n;
    static int[] arr;
    static int[] dp;

    private static void solution(int index){
        int w = arr[index];
        for (int i = index+1; i <= index+w ; i++) {
            if(i>=n) break;
            if(dp[i]>dp[index]+1){
                dp[i] = dp[index] + 1;
                solution(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        dp = new int[n + 1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;

        solution(0);

        writer.write(String.valueOf(dp[n - 1] != 10000 ? dp[n - 1] : -1));
        writer.flush();
        writer.close();
    }

    static class Node{
        private int index;
        private int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }
}
