package dataStructure;

import java.io.*;
import java.util.Arrays;

/**
 * Parametric Search
 */
public class ParametricSearch {
    static int n, c, ans;
    static int min, max;
    static int[] x;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        input(reader);

        int left = 1;
        int right = x[n - 1] - x[0];
        while (left <= right) {
            int gap = (left + right) / 2;
            int start = x[0];
            int cnt = 1;

            for (int i = 1; i < n; i++) {
                if (x[i] - start >= gap) {
                    start = x[i];
                    cnt++;
                }
            }
            if (cnt >= c) {
                if(ans<gap)
                    ans = gap;
                left = gap + 1;
            } else {
                right = gap - 1;
            }
        }

        output(writer);
    }

    private static void output(BufferedWriter writer) throws IOException {
        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }

    private static void input(BufferedReader reader) throws IOException {
        String[] s = reader.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        c = Integer.parseInt(s[1]);
        x = new int[n];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(reader.readLine());
            if(x[i]<min) min = x[i];
            if(x[i]>max) max = x[i];
        }
        Arrays.sort(x);
        reader.close();
    }
}
