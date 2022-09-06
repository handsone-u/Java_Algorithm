package cheat_sheets;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MSTKruskal {
    static int n,m,ans;
    static int[] parent;
    static PriorityQueue<Connect> pq = new PriorityQueue<>(Comparator.comparing(Connect::getCost));

    static int findParent(int x) {
        if (x == parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }

    static void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if(px==py) return;

        if (px < py) {
            parent[y] = px;
        } else {
            parent[x] = py;
        }
    }

    static void solution() {
        while (!pq.isEmpty()) {
            Connect poll = pq.poll();
            int pa = findParent(poll.a);
            int pb = findParent(poll.b);
            if(pa==pb) continue;

            union(pa, pb);
            ans += poll.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int i = 0; i < m; i++) {
            int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.add(new Connect(tmp[0], tmp[1], tmp[2]));
        }

        solution();
        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }

    static class Connect{
        int a;
        int b;
        int cost;

        public int getCost() {
            return cost;
        }

        public Connect(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }
}
