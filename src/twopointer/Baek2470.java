package twopointer;

import java.io.*;
import java.util.Arrays;

/**
 * two-pointer
 * sort & shift(i,j)
 */
public class Baek2470 {
    static int n;
    static long ansMin, ansMax, ans;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        arr = new long[n];
        String[] s = reader.readLine().split(" ");
        reader.close();

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);
        Arrays.sort(arr);
        ansMax = arr[n - 1];
        ansMin = arr[0];
        ans = Math.abs(ansMax+ansMin);

        int i = 0, j = n - 1;
        while (i < j) {
            long val = arr[j] + arr[i];
            if (Math.abs(val) < ans) {
                ans = Math.abs(val);
                ansMin = arr[i];
                ansMax = arr[j];
            }
            if (val < 0) i++;
            else j--;
        }

        writer.write(Long.toString(ansMin)+" "+Long.toString(ansMax));
        writer.flush();
        writer.close();
    }
}
