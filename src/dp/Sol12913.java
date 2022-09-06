package dp;

/**
 * Dynamic Programming
 */
public class Sol12913 {
    int answer, len;
    int[][] dp;
    int solution(int[][] land) {
        len = land.length;
        dp = new int[len + 1][4];

        for (int i = 0; i < 4; i++) dp[0][i] = land[0][i];
        for (int i = 1; i < len; i++) {
            dp[i][0] = getMax(dp[i - 1][1], dp[i - 1][2], dp[i - 1][3]) + land[i][0];
            dp[i][1] = getMax(dp[i - 1][0], dp[i - 1][2], dp[i - 1][3]) + land[i][1];
            dp[i][2] = getMax(dp[i - 1][0], dp[i - 1][1], dp[i - 1][3]) + land[i][2];
            dp[i][3] = getMax(dp[i - 1][0], dp[i - 1][1], dp[i - 1][2]) + land[i][3];
        }
        answer = getMax(dp[len - 1][0], dp[len - 1][1], dp[len - 1][2], dp[len-1][3]);

        return answer;
    }

    private int getMax(int... val) {
        int length = val.length;
        int max = val[0];

        for (int i = 1; i < length; i++)
            max = Integer.max(max, val[i]);

        return max;
    }
}
