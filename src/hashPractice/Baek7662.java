package hashPractice;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Priority Queue
 * index Map
 */
public class Baek7662 {
    static int t, k;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            PriorityQueue<Pair> maxQ = new PriorityQueue<>(Comparator.comparing(Pair::getValue, Comparator.reverseOrder())
                    .thenComparing(Pair::getIndex));
            PriorityQueue<Pair> minQ = new PriorityQueue<>(Comparator.comparing(Pair::getValue)
                    .thenComparing(Pair::getIndex));
            k = Integer.parseInt(reader.readLine());
            int[] visited = new int[k];

            for (int i = 0; i < k; i++) {
                String[] s = reader.readLine().split(" ");
                char d = s[0].charAt(0);
                int n = Integer.parseInt(s[1]);
                if (d == 'I') {
                    maxQ.add(new Pair(n, i));
                    minQ.add(new Pair(n, i));
                    visited[i]++;
                } else if (n == 1) {
                    while (!maxQ.isEmpty() && visited[maxQ.peek().getIndex()] == 0) maxQ.poll();
                    if(maxQ.isEmpty()) continue;
                    visited[maxQ.poll().index]--;
                } else {
                    while (!minQ.isEmpty() && visited[minQ.peek().getIndex()] == 0) minQ.poll();
                    if (minQ.isEmpty()) continue;
                    visited[minQ.poll().index]--;
                }
            }
            while (!maxQ.isEmpty() && visited[maxQ.peek().getIndex()] == 0) maxQ.poll();
            while (!minQ.isEmpty() && visited[minQ.peek().getIndex()] == 0) minQ.poll();

            if(minQ.isEmpty()||maxQ.isEmpty()) writer.write("EMPTY\n");
            else writer.write(Integer.toString(maxQ.poll().value) +
                    " " + Integer.toString(minQ.poll().value) + "\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    static class Pair{
        int value;
        int index;

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
