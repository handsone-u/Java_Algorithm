package bin_search;

import java.io.*;
import java.util.*;

/**
 * LIS
 */
public class Baek10815 {
    static int n, m;
    static int[] arr,query;
    static boolean[] v = new boolean[20000003];

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i : arr) {
            if(i>=0)
                v[i] = true;
            else
                v[10000000 - i] = true;
        }

        m = Integer.parseInt(reader.readLine());
        query = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int q : query) {
            if(q>=0)
                writer.write(v[q] ? '1' : '0');
            else
                writer.write(v[10000000 - q] ? '1' : '0');
            writer.write(' ');
        }
        writer.flush();
        writer.close();
    }
}
