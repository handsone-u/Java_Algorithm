package bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baek2146 {
    static int n, continents;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    private static void getContinent() {
        continents = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]!=1) continue;
                dfs(++continents, i, j);
            }
        }

    }

    private static void dfs(int name, int x,int y) {
        map[x][y] = name;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx<0||ny<0||nx>=n||ny>=n||map[nx][ny]!=1) continue;
            dfs(name, nx, ny);
        }
    }

    private static int bfs(int name, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(v[i], false);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        v[x][y] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair poll = q.poll();
                if(map[poll.getX()][poll.getY()]!=0
                        && map[poll.getX()][poll.getY()]!=name){
                    return cnt-1;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + poll.getX();
                    int ny = dy[j] + poll.getY();
                    if(nx<0||ny<0||nx>=n||ny>=n) continue;
                    if(map[nx][ny]==name||v[nx][ny]) continue;
                    q.add(new Pair(nx, ny));
                    v[nx][ny] = true;
                }
            }
            cnt++;
        }

        return Integer.MAX_VALUE;
    }

    private static int getDistance() {
        int result = n * 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j]==0) continue;
                result = Integer.min(result, bfs(map[i][j], i, j));
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reading(reader);
        getContinent();

        writer.write(String.valueOf(getDistance()));
        writer.flush();
        writer.close();
    }

    private static void reading(BufferedReader reader) throws IOException {
        n = Integer.parseInt(reader.readLine());
        map = new int[n][];
        v = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        reader.close();
    }

    static class Pair{
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
