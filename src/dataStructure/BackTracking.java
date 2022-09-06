package dataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * - 백트랙킹.
 * DFS 방식으로 문제 답에 접근해 감
 * 현재 방향이 유망하지 않다면(!promising) 재귀식을 종료하고
 * 새로운 방향으로 나아가도록 하는 방식
 */
public class BackTracking {
    static int[][] arr;
    static BufferedReader reader;
    static BufferedWriter writer;
    static ArrayList<Point> holes = new ArrayList<>();

    static boolean solution(int todo) throws IOException {
        if (holes.size() == todo) {
            printResult();
            return true;
        }

        Point point = holes.get(todo);
        for (int i = 1; i <= 9; i++) {
            if(!isPromising(point.x, point.y, i)) continue;

            arr[point.x][point.y] = i;
            if(solution(todo+1)) return true;
            arr[point.x][point.y] = 0;
        }

        return holes.size() == todo;
    }

    static boolean isPromising(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) return false;
            if (arr[i][col] == value) return false;
        }

        return okBox(row / 3, col / 3, value);
    }

    static boolean okBox(int boxX, int boxY, int value) {
        int baseX = boxX * 3;
        int baseY = boxY * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[baseX + i][baseY + j] == value) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new int[9][9];
        int todo = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            for (int j = 0; j < 9; j++) {
                if(arr[i][j]==0)
                    holes.add(new Point(i, j));
            }
        }

        solution(0);

        writer.flush();
        writer.close();
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void printResult() throws IOException {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                writer.write(String.valueOf(arr[i][j]));
                writer.write(' ');
            }
            writer.write('\n');
        }
    }
}
