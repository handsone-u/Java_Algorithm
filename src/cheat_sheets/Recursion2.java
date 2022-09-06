package cheat_sheets;

import java.io.*;

public class Recursion2 {
    static int n;
    static char[][] ans;

    static void solution() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nextX = i * n / 3;
                int nextY = j * n / 3;
                recurse(i, j, nextX, nextY, n / 3);
            }
        }
    }

    static void recurse(int indexX, int indexY, int x, int y, int value) {
        if (indexX == 1 && indexY == 1) {
            for (int i = x; i < x+value; i++)
                for (int j = y; j < y + value; j++)
                    ans[i][j] = ' ';
            return;
        }
        if (value == 1) {
            ans[x][y] = '*';
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int nextX = x + i * value / 3;
                int nextY = y + j * value / 3;
                recurse(i, j, nextX, nextY, value / 3);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        ans = new char[n][n];
        reader.close();

        solution();

        printResult(writer);
        writer.flush();
        writer.close();
    }

    static void printResult(BufferedWriter writer) throws IOException {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                writer.write(ans[i][j]);
            }
            writer.write('\n');
        }
    }
}
