package cheat_sheets;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LCA {
    static int n;
    static int[] parent;
    static int[] level;
    static boolean[] isRoot;
    static ArrayList<Integer>[] arr;

    static int lca(int a, int b) {
        if(a==b) return a;

        if (level[a] == level[b]) {
            if(parent[a]==parent[b]) return parent[a];
            else return lca(parent[a], parent[b]);
        } else if (level[a] < level[b]) {
            return lca(a, parent[b]);
        } else {
            return lca(parent[a], b);
        }
    }

    static void dfs(int current, int depth) {
        level[current] = depth;

        for (Integer nodeIndex : arr[current]) {
            parent[nodeIndex] = current;
            dfs(nodeIndex, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            input(reader);

            for (int i = 1; i <= n; i++) {
                if(isRoot[i]) continue;
                parent[i] = 0;
                dfs(i, 0);
                break;
            }

            int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            writer.write(String.valueOf(lca(tmp[0], tmp[1])));
            writer.write('\n');
        }
        writer.flush();
        writer.close();
    }

    private static void input(BufferedReader reader) throws IOException {
        n = Integer.parseInt(reader.readLine());
        parent = new int[n + 1];
        level = new int[n + 1];
        arr = new ArrayList[n + 1];
        isRoot = new boolean[n + 1];

        for (int i = 1; i <= n; i++)
            arr[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arr[tmp[0]].add(tmp[1]);
            isRoot[tmp[1]] = true;
        }
    }
}
