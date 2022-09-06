package bin_search;

import java.io.*;
import java.util.Arrays;

/**
 * Bin-Search
 * parameter search
 */
public class Baek1654 {
    static long n, k;
    static long ans;
    static int[] arr;
    static int[] sorted;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = reader.readLine().split(" ");
        k = Long.parseLong(nk[0]);
        n = Long.parseLong(nk[1]);
        arr = new int[(int) k];
        for (int i = 0; i < k; i++) arr[i] = Integer.parseInt(reader.readLine());
        reader.close();

        sorted = Arrays.stream(arr).sorted().toArray();
        long min = 0;
        long max = sorted[(int) (k - 1)];

        while (min <= max) {
            long middle = (min + max) / 2;
            long tmpN = getTotal(middle);
            if (tmpN < n) {
                max = middle-1;
            } else {
                if(ans<middle) ans = middle;
                min = middle+1;
            }
        }

        writer.write(Long.toString(ans));
        writer.flush();
        writer.close();
    }

    public static long getTotal(long value) {
        long result = 0;
        if(value==0) value++;

        for (int i = 0; i < k; i++) result += sorted[i] / value;

        return result;
    }
}
