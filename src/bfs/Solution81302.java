package bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution81302 {
    char[][] p = new char[5][5];
    boolean[][] v = new boolean[5][5];
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int len = places.length;
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 5; j++)
                p[j] = places[i][j].toCharArray();

            if(isPossible())
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }

    boolean isPossible() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(p[i][j]!='P') continue;
                if(bfs(i,j)) return false;
            }
        }
        return true;
    }

    boolean bfs(int x, int y) {
        init();
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        v[x][y] = true;

        int depth = 0;
        while (!q.isEmpty()) {
            if (depth >= 2) break;
            int qSize = q.size();

            for (int i = 0; i < qSize; i++) {
                Point poll = q.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];
                    if (!isIn(nx, ny) || p[nx][ny] == 'X' || v[nx][ny]) continue;
                    q.add(new Point(nx, ny));
                    v[nx][ny] = true;
                    if(p[nx][ny]=='P') return true;
                }
            }
            depth++;
        }
        return false;
    }

    boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < 5 && y < 5;
    }

    void init() {
        for (int i = 0; i < 5; i++) Arrays.fill(v[i], false);
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
