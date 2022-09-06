package stack_queue;

import java.io.*;
import java.util.Stack;

public class Stack3015 {
    static int n;
    static long ans;
    static int[] arr;

    static void solution() {
        Stack<Pair> stack = new Stack<>();
        stack.add(new Pair(arr[0], 1));
        for (int i = 1; i < n; i++) {
            Pair now = new Pair(arr[i], 1);

            while (!stack.isEmpty() && stack.peek().height <= now.height) {
                Pair pop = stack.pop();
                ans += pop.count;
                if (pop.height == now.height)
                    now.count += pop.count;
            }

            if (!stack.isEmpty()) {
                ans++;
            }

            stack.add(now);
        }
    }

    static class Pair {
        public int height;
        public int count;

        public Pair(int height, int count) {
            this.height = height;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        solution();

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }
}
