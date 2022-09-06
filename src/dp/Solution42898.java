package dp;

public class Solution42898 {
    int[][] dp;

    private boolean no(int[][] p, int x, int y) {
        for (int[] xy : p) {
            if(x+1==xy[1]&&y+1==xy[0]) return true;
        }
        return false;
    }

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        dp = new int[n][m];

        for (int i = 1; i < n; i++) {
            if(no(puddles,i,0)) break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            if(no(puddles,0,i)) break;
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(no(puddles,i,j)) continue;
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }

        return dp[n-1][m-1];
    }
}
