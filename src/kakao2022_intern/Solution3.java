package kakao2022_intern;

import java.util.Arrays;

public class Solution3 {
    int maxAlp, maxCop;
    int[][] dp;
    public int solution(int alp, int cop, int[][] problems) {
        init(problems, alp, cop);

        for (int i = alp; i <= maxAlp; i++) {
            for (int j = cop; j <= maxCop; j++) {
                dp[i + 1][j] = Integer.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Integer.min(dp[i][j + 1], dp[i][j] + 1);
                for (int[] problem : problems) {
                    if(!isSolveAble(problem, i,j)) continue;
                    int nextA = i + problem[2];
                    int nextC = j + problem[3];
                    int nextCost = dp[i][j] + problem[4];
                    if (nextA >= maxAlp && nextC >= maxCop) {
                        dp[maxAlp][maxCop] = Integer.min(dp[maxAlp][maxCop], nextCost);
                    } else if (nextA >= maxAlp) {
                        dp[maxAlp][nextC] = Integer.min(dp[maxAlp][nextC], nextCost);
                    } else if (nextC >= maxCop) {
                        dp[nextA][maxCop] = Integer.min(dp[nextA][maxCop], nextCost);
                    } else {
                        dp[nextA][nextC] = Integer.min(dp[nextA][nextC], nextCost);
                    }
                }
            }
        }

        return dp[maxAlp][maxCop];
    }

    void init(int[][] problems, int a, int c) {
        maxAlp = a;
        maxCop = c;
        for (int[] problem : problems) {
            maxAlp = Integer.max(maxAlp, problem[0]);
            maxCop = Integer.max(maxCop, problem[1]);
        }

        dp = new int[maxAlp + 3][maxCop + 3];
        for (int i = a; i < maxAlp + 3; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[a][c] = 0;
    }

    boolean isSolveAble(int[] problem, int a, int c) {
        return a >= problem[0] && c >= problem[1];
    }
}
