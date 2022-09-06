package dp;

public class Solution12904 {
    private int len;
    private int[][] dp;
    private char[] arr;

    public int solution(String s) {
        int answer = 1;
        len = s.length();
        dp = new int[len][len];
        arr = s.toCharArray();

        // 1. SELF
        for (int i = 0; i < len; i++) dp[i][i] = 1;

        // 2. ADJACENT
        for (int i = 0; i < len - 1; i++) {
            if(arr[i]==arr[i+1]) {
                answer = 2;
                dp[i][i + 1] = 2;
            }
        }

        // 3. TRI
        for (int i = 0; i < len - 2; i++) {
            if(arr[i]==arr[i+2]) {
                answer = 3;
                dp[i][i + 2] = 3;
            }
        }

        for (int k = 3; k < len; k++) {
            for (int i = 0; i + k < len; i++) {
                if(arr[i]!=arr[i+k]) continue;
                if(dp[i+1][i+k-1]==0) continue;
                answer = k + 1;
                dp[i][i + k] = k + 1;
            }
        }

        return answer;
    }
}
