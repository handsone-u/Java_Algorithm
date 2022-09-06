package heap;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Heap, Priority-Queue
 * search for "middle-value"
 */
public class Baek1655 {
    static int n;
    static PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> minPq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(reader.readLine());
            int maxSize = maxPq.size();
            int minSize = minPq.size();
            if (maxSize == minSize) maxPq.add(k);
            else minPq.add(k);

            if (!minPq.isEmpty() && !maxPq.isEmpty()) {
                if (minPq.peek() < maxPq.peek()) {
                    int newMin = maxPq.poll();
                    int newMax = minPq.poll();
                    maxPq.add(newMax);
                    minPq.add(newMin);
                }
            }

            writer.write(Integer.toString(maxPq.peek()));
            writer.write("\n");
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}
