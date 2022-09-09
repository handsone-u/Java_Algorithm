package twopointer;

import java.io.*;
import java.util.Arrays;

public class Baek1806 {
    static int n, s, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reading(reader);

        int i = 0, j = 1;
        int sum = arr[i];

        for (i = 0; i < j; i++) {
            while (sum < s && j < n) sum += arr[j++];
            if(sum>=s) ans = Integer.min(ans, j - i);
            sum -= arr[i];
        }

        String answer = String.valueOf(ans > n ? 0 : ans);
        writer.write(answer);
        writer.flush();
        writer.close();
    }

    private static void reading(BufferedReader reader) throws IOException {
        int[] tmp = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = tmp[0];
        s = tmp[1];
        ans = n + 1;

        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        reader.close();
    }
}
