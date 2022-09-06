package cheat_sheets;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {
    static int v, e, k;
    static int[] result; // 최댓값 초기화
    static ArrayList<Node>[] edges;

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getWeight, Comparator.naturalOrder()));
        result[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int nowIndex = now.getIndex();
            int nowWeight = now.getWeight();

            // 이미 최단거리가 구해졌기 때문에 넘어간다. (GREEDY)
            if(result[nowIndex]<nowWeight) continue;

            ArrayList<Node> nowEdge = edges[nowIndex];
            for (Node next : nowEdge) {
                int nextIndex = next.getIndex();
                int nextWeight = next.getWeight();
                int nextResult = nowWeight + nextWeight;
                if (nextResult < result[nextIndex]) {
                    result[nextIndex] = nextResult;
                    pq.offer(new Node(nextIndex, result[nextIndex]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        inPut(reader);

        dijkstra(k);

        printResult(writer);
    }

    private static void inPut(BufferedReader reader) throws IOException {
        int[] array = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        v = array[0];
        e = array[1];
        k = Integer.parseInt(reader.readLine());
        result = new int[v + 1];
        edges = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++) {
            result[i] = Integer.MAX_VALUE;
            edges[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            array = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            edges[array[0]].add(new Node(array[1], array[2]));
        }
        reader.close();
    }

    private static void printResult(BufferedWriter writer) throws IOException {
        for (int i = 1; i <= v; i++) {
            if(result[i]==Integer.MAX_VALUE)
                writer.write("INF");
            else
                writer.write(String.valueOf(result[i]));
            writer.write("\n");
        }
        writer.flush();
        writer.close();
    }

    static class Node{
        private final int index;
        private final int weight;

        public int getIndex() {
            return index;
        }

        public int getWeight() {
            return weight;
        }

        public Node(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }
}
