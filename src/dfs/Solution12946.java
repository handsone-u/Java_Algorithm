package dfs;

import java.util.ArrayList;

public class Solution12946 {
    ArrayList<int[]> ans = new ArrayList<>();

    private void move(int from, int through, int to, int num) {
        if (num <= 1) {
            ans.add(new int[]{from, to});
            return;
        }
        move(from, to, through, num - 1);
        ans.add(new int[]{from, to});
        move(through, from, to, num - 1);
    }

    public int[][] solution(int n) {
        int[][] answer = {};

        move(1, 2, 3, n);
        answer = ans.toArray(new int[0][2]);

        return answer;
    }
}
