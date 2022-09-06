package sort;

import java.io.*;
import java.util.Arrays;

public class Baek18870 {
    static int n;
    static int[] arr;
    static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        String[] s = reader.readLine().split(" ");
        arr = new int[n];
        reader.close();

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);
        sorted = Arrays.stream(arr).sorted().distinct().toArray();

        for (int i = 0; i < n; i++) {
            writer.write(Integer.toString(getIndex(arr[i])));
            writer.write(" ");
        }

        writer.flush();
        writer.close();
    }

    private static int getIndex(int value) {
        return Arrays.binarySearch(sorted, value);
    }
}
