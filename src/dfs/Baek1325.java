package dfs;

import java.io.*;
import java.util.*;

public class Baek1325 {
    static int n, m, max;
    static int[] count;
    static ArrayList<Integer>[] v;

    private static void dfs(int from, int start,int depth) {
        if(depth!=0&&from==start)
            return;
        for (int i : v[from]) {
            count[i]++;
            dfs(i, start, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] tmp = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = tmp[0];
        m = tmp[1];
        count = new int[n + 1];
        v = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) v[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            tmp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            v[tmp[0]].add(tmp[1]);
        }

        for (int i = 1; i <= n; i++)
            dfs(i,i,0);

        max = Arrays.stream(count)
                .max().getAsInt();
        for (int i = 1; i <= n; i++) {
            if(count[i]!=max) continue;
            writer.write(String.valueOf(i));
            writer.write(' ');
        }
        writer.flush();
        writer.close();
    }
}
