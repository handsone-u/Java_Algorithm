package bin_search;

import java.io.*;
import java.util.Arrays;

public class Baek2805 {
    static long n, m, h;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm = reader.readLine().split(" ");
        String[] trees = reader.readLine().split(" ");
        reader.close();
        n = Long.parseLong(nm[0]);
        m = Long.parseLong(nm[1]);
        arr = new long[(int) n];
        long min = 0, max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(trees[i]);
            if(max<arr[i]) max = arr[i];
        }

        while (min <= max) {
            long middle = (min + max) / 2;
            long tmpM = getLog(middle);
            if (tmpM >= m) {
                min = middle + 1;
                if(h<middle) h = middle;
            }
            else max = middle - 1;
        }

        writer.write(Long.toString(h));
        writer.flush();
        writer.close();
    }

    public static long getLog(long height) {
        long result = 0;
        for (int i = 0; i < n; i++) {
            if(arr[i]<=height) continue;
            result += arr[i] - height;
        }
        return result;
    }
}
