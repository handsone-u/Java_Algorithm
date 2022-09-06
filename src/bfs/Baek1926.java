package bfs;

import java.util.*;
import java.io.*;

public class Baek1926 {
    static int n,m;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] v;
    static int num, width;

    static boolean negative(int x, int y) {
        if(x<0||y<0||x>=n||y>=m) return true;
        return map[x][y] == 0 || v[x][y];
    }

    private static void bfs(int x,int y) {
        int size = 0;
        Queue<Point> q = new LinkedList<>();

        v[x][y] = true;
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                size++;
                Point p = q.poll();
                for (int k = 0; k < 4; k++) {
                    assert p != null;
                    int nx = p.x + dx[k];
                    int ny = p.y + dy[k];
                    if(negative(nx, ny)) continue;

                    v[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }
        width = Integer.max(width, size);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] tmp;
        tmp = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = tmp[0];
        m = tmp[1];
        map = new int[n][m];
        v = new boolean[n][m];
        num = width = 0;
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(negative(i, j)) continue;
                ++num;
                bfs(i, j);
            }
        }

        System.out.println(num);
        System.out.println(width);
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
