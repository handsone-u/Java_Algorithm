package kakao2022_blind;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution7 {
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int n,m;

    public int solution(int[][] board, int[] aLoc, int[] bLoc) {
        n = board.length;
        m = board[0].length;

        return move(board, aLoc, bLoc, 0).count;
    }

    Result move(int[][] b, int[] aL, int[] bL, int count) {
        int[] location = new int[2];
        boolean isA = count % 2 == 0;
        if (isA) {
            location[0] = aL[0];
            location[1] = aL[1];
        } else {
            location[0] = bL[0];
            location[1] = bL[1];
        }
        if (!hasBlock(b, location[0], location[1])) {
            return new Result(count, false);
        }

        ArrayList<Result> results = new ArrayList<>();
        boolean allWin = true, allLose = true;
        for (int i = 0; i < 4; i++) {
            int nx = location[0] + dx[i];
            int ny = location[1] + dy[i];
            int[] nextLocation = {nx, ny};
            if(!hasBlock(b, nx,ny)) continue;

            Result result;
            b[location[0]][location[1]] = 0;
            if(isA) result = move(b, nextLocation, bL, count + 1);
            else result = move(b, aL, nextLocation, count + 1);
            b[location[0]][location[1]] = 1;
            results.add(result);
            allWin = allWin && !result.win;
            allLose = allLose && result.win;
        }
        if (results.isEmpty()) {
            return new Result(count, false);
        }
        if (allWin) {
            Result result = results.get(0);
            for (Result r : results) {
                if(result.count>r.count) result = r;
            }
            return new Result(result.count, true);
        } else if (allLose) {
            Result result = results.get(0);
            for (Result r : results) {
                if (result.count < r.count) result = r;
            }
            return new Result(result.count, false);
        } else {
            Result result = null;
            List<Result> collect = results.stream()
                    .filter(r -> !r.win)
                    .collect(Collectors.toList());
            for (Result r : collect) {
                if(result==null||result.count>r.count)
                    result = r;
            }
            return new Result(result.count, true);
        }
    }

    boolean hasBlock(int[][] board, int x, int y) {
        return isIn(x, y) && board[x][y] != 0;
    }

    boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static class Result {
        int count;
        boolean win;

        public Result(int count, boolean win) {
            this.count = count;
            this.win = win;
        }
    }
}
