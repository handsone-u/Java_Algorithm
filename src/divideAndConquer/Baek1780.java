package divideAndConquer;

import java.io.*;
import java.util.*;

public class Baek1780 {
    // -1,0,1
    static int[] result;
    static int n;
    static int[][] arr;

    private static void solution(int n, int x, int y) {
        if (isSolid(n, x, y) || n == 1) {
            result[arr[x][y] + 1]++;
            return;
        }
        int dn = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                solution(dn, x + dn * i, y + dn * j);
            }
        }
    }

    private static boolean isSolid(int n, int x, int y) {
        int color = arr[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if(arr[i][j]!=color) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        arr = new int[n][n];
        result = new int[3];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        solution(n, 0, 0);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }
}
