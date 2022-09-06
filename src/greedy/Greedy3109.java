package greedy;

import java.io.*;
import java.util.Arrays;

public class Greedy3109 {
    static int R,C,ans;
    static char[][] arr;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};

    static void solution() {
        for (int i = 0; i < R; i++) {
            if(connect(i,0)) ans++;
        }
    }

    static boolean connect(int x, int y) {
        v[x][y] = true;
        if(y==C-1)
            return true;

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(!possible(nx,ny)) continue;
            if(connect(nx, ny)) return true;
        }

        return false;
    }

    static boolean possible(int x, int y) {
        if(x<0||y<0||x>=R||y>=C) return false;
        if(arr[x][y]=='x'||v[x][y]) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        input(reader);
        solution();

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }

    static void input(BufferedReader reader) throws IOException {
        int[] array = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        R = array[0];
        C = array[1];
        arr = new char[R][C];
        v = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            arr[i] = reader.readLine().toCharArray();
        }
    }
}
