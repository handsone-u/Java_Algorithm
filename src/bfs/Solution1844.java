package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1844 {
    private boolean[][] v;
    int m, n;
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    private boolean isOut(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= m;
    }

    public int solution(int[][] maps) {
        int answer = -1;
        n = maps.length;
        m = maps[0].length;
        v = new boolean[n][m];

        Queue<Point> q = new LinkedList<>();
        v[0][0] = true;
        q.add(new Point(0, 0));
        int count = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Point poll = q.poll();
                if (poll.x == n-1 && poll.y == m-1) {
                    answer = count;
                    q.clear();
                    break;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = poll.x + dx[j];
                    int ny = poll.y + dy[j];
                    if(isOut(nx,ny)) continue;
                    if(v[nx][ny]) continue;
                    if(maps[nx][ny]==0) continue;
                    v[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
            count++;
        }

        return answer;
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
