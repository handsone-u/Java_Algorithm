package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek1766 {
    static int n, m;
    static PriorityQueue<Node> pq;
    static Node[] nodes;
    static StringBuilder stringBuilder = new StringBuilder();

    private static void solution() {
        int done = 0;

        while (done < n) {
            if (pq.isEmpty()) {
                for (int i = 1; i <= n; i++) {
                    if(nodes[i].count==0) pq.add(nodes[i]);
                }
            }
            done++;
            Node poll = pq.poll();
            ArrayList<Integer> remove = poll.remove();
            for (Integer r : remove) {
                if(nodes[r].count==0) pq.add(nodes[r]);
            }
            stringBuilder.append(poll.index);
            stringBuilder.append(' ');
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        reading(reader);
        pq = new PriorityQueue<>(Comparator.comparing(Node::getIndex));

        solution();
        writer.write(stringBuilder.toString());
        writer.flush();
        writer.close();
    }

    private static void reading(BufferedReader reader) throws IOException {
        int[] tmp = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = tmp[0];
        m = tmp[1];
        nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) nodes[i] = new Node(i);

        for (int i = 0; i < m; i++) {
            tmp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            nodes[tmp[0]].children.add(tmp[1]);
            nodes[tmp[1]].count++;
        }
        reader.close();
    }

    static class Node{
        private int index;
        private int count;
        private ArrayList<Integer> children = new ArrayList<>();

        public Node(int index) {
            this.index = index;
            this.count = 0;
        }

        public ArrayList<Integer> remove() {
            count--;
            for (Integer child : children) {
                nodes[child].count--;
            }
            return children;
        }

        public int getIndex() {
            return index;
        }

        public int getCount() {
            return count;
        }

        public ArrayList<Integer> getChildren() {
            return children;
        }
    }
}
