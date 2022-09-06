package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class BacktrackingDFS {
    HashMap<Character, Point> map = new HashMap<>();
    ArrayList<Character> q = new ArrayList<>();
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    char[][] boardArr;
    char HOLE = '.';
    char BLOCK = '*';

    public String solution(int n, int m, String[] board) {
        String answer = "";
        boardArr = new char[n][];
        initMap(board, n, m);

        while (!q.isEmpty()) {
            Character del = null;
            for (Character ch : q) {
                if (isPossible(n, m, ch)) {
                    del = ch;
                    break;
                }
            }

            if(del==null) return "IMPOSSIBLE";
            deleteCh(n, m, del);
            answer += del;
            q.remove(del);
        }

        return answer;
    }

    boolean isPossible(int n, int m, char c) {
        boolean result = false;
        boolean[][] v = new boolean[n][m];
        Point point = map.get(c);
        v[point.x][point.y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];
            if(!passable(v,nx,ny,n,m,c)) continue;
            v[nx][ny] = true;
            if(i==0||i==2)
                result = result || dfs(v, new Point(nx, ny), n, m, c, true, false, true);
            else
                result = result || dfs(v, new Point(nx, ny), n, m, c, false, true, false);
            v[nx][ny] = false;
        }

        return result;
    }

    boolean dfs(boolean[][] v, Point now, int n, int m, char target, boolean vertical, boolean horizontal, boolean lastV) {
        if (boardArr[now.x][now.y] == target) return true;
        boolean result = false;
        for (int i = 0; i < 4; i++) {
            int nx = now.x + dx[i];
            int ny = now.y + dy[i];
            if(!passable(v,nx,ny,n,m,target)) continue;
            v[nx][ny] = true;
            if (i == 0 || i == 2) {
                if(lastV||!vertical)
                    result = result || dfs(v, new Point(nx, ny), n, m, target, true, horizontal, true);
            } else {
                if(!lastV||!horizontal)
                    result = result || dfs(v, new Point(nx, ny), n, m, target, vertical, true, false);
            }
            v[nx][ny] = false;
        }
        return result;
    }

    boolean passable(boolean[][] v, int x, int y, int n, int m, char target) {
        if (x < 0 || x >= n || y < 0 || y >= m || v[x][y]) return false;
        return boardArr[x][y] == target || boardArr[x][y] == HOLE;
    }

    void deleteCh(int n, int m, char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(boardArr[i][j]==target) boardArr[i][j] = '.';
            }
        }
    }

    void initMap(String[] board, int n, int m) {
        boolean[] v = new boolean[26];
        for (int i = 0; i < n; i++) {
            boardArr[i] = board[i].toCharArray();
            for (int j = 0; j < m; j++) {
                if(boardArr[i][j]==HOLE||boardArr[i][j]==BLOCK) continue;
                if(v[boardArr[i][j]-'A']) continue;
                v[boardArr[i][j] - 'A'] = true;
                map.put(boardArr[i][j], new Point(i, j));
                q.add(boardArr[i][j]);
            }
        }
        Collections.sort(q);
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