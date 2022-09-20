package kakao2022_blind;

public class Solution6 {
    int n, m, s;
    int[][] sum;
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        n = board.length;
        m = board[0].length;
        s = skill.length;
        sum = new int[n + 1][m + 1];

        for (int[] sk : skill) {
            int value;
            if(sk[0]==1) value = -sk[5];
            else value = sk[5];
            int r1 = sk[1], r2 = sk[3];
            int c1 = sk[2], c2 = sk[4];

            sum[r1][c1] += value;
            sum[r1][c2 + 1] -= value;
            sum[r2 + 1][c1] -= value;
            sum[r2 + 1][c2 + 1] += value;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i][j + 1] += sum[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[j + 1][i] += sum[j][i];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] + sum[i][j] > 0)
                    answer++;
            }
        }


        return answer;
    }
}
