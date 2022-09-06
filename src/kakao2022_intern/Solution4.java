package kakao2022_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution4 {
    ArrayList<Node>[] nodes;
    HashMap<Integer, String> location = new HashMap<>();
    Node ans;

    ArrayList<Integer> summitArray = new ArrayList<>();

    String NORMAL = "NORMAL";
    String GATE = "GATE";
    String SUMMIT = "SUMMIT";

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        ans = new Node(n, Integer.MAX_VALUE);
        init(n, paths, gates, summits);

        for (int i = 1; i <= n; i++) {
            String info = location.getOrDefault(i, NORMAL);
            if(!info.equals(GATE)) continue;
            beginDijkstra(i, n);
        }

        return ans.toAnswer();
    }

    private void beginDijkstra(int index, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dijkstra = new int[n + 1];
        Arrays.fill(dijkstra, Integer.MAX_VALUE);

        dijkstra[index] = 0;
        pq.add(new Node(index, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if(current.weight>ans.weight) continue;
            if(current.weight>dijkstra[current.index]) continue;

            for (Node adj : nodes[current.index]) {
                String nextInfo = location.getOrDefault(adj.index, NORMAL);
                int nextWeight = Integer.max(current.weight, adj.weight);

                if(nextInfo.equals(GATE)) continue;
                if(nextWeight>=dijkstra[adj.index]) continue;

                dijkstra[adj.index] = nextWeight;

                if(!nextInfo.equals(SUMMIT))
                    pq.add(new Node(adj.index, nextWeight));
            }
        }

        for (Integer i : summitArray) {
            Node candidate = new Node(i, dijkstra[i]);
            ans = Node.min(ans, candidate);
        }
    }

    private void init(int n, int[][] paths, int[] gates, int[] summits) {
        nodes = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            nodes[path[0]].add(new Node(path[1], path[2]));
            nodes[path[1]].add(new Node(path[0], path[2]));
        }
        for (int gate : gates) {
            location.put(gate, GATE);
        }
        for (int summit : summits) {
            location.put(summit, SUMMIT);
            summitArray.add(summit);
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        int weight;

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        public int[] toAnswer() {
            return new int[]{index, weight};
        }

        static Node min(Node a, Node b) {
            if(a.compareTo(b)<0)
                return a;
            else
                return b;
        }

        @Override
        public int compareTo(Node o) {
            if(this.weight==o.weight)
                return this.index - o.index;
            return this.weight - o.weight;
        }
    }
}
