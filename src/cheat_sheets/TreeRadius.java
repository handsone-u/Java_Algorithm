package cheat_sheets;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TreeRadius {
    static int n, rMax, rNum;
    static ArrayList<Node>[] vertex;
    static boolean[] visited;

    static void dfs(int index, int value) {
        visited[index] = true;
        if (rMax < value) {
            rMax = value;
            rNum = index;
        }
        for (Node node : vertex[index]) {
            if (visited[node.index]) continue;
            dfs(node.index, value + node.distance);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        vertex = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++)
            vertex[i] = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int v = tmp[0];
            int len = tmp.length;
            int j = 1;
            while (j+1 < len) {
                int to = tmp[j];
                int d = tmp[j + 1];
                vertex[v].add(new Node(to, d));
                j += 2;
            }
        }
        dfs(1, 0);
        Arrays.fill(visited, false);
        dfs(rNum, 0);

        writer.write(String.valueOf(rMax));
        writer.flush();
        writer.close();
    }

    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}
