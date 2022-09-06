package divideAndConquer;

import java.io.*;
import java.util.*;

public class Baek2263 {
    static int n, count;
    static int[] in, post, position;

    private static void parse(int left, int right) {
        if (left > right) return;

        int head = getIndex(left, right);
        System.out.printf("%d ", in[head]);
        parse(left, head - 1);
        parse(head + 1, right);
    }

    private static int getIndex(int left,int right) {
        if(left==right) return left;

        int index = left;
        int value = 0;
        for (int i = left; i <= right; i++) {
            if (value < position[in[i]]) {
                value = position[in[i]];
                index = i;
            }
        }

        return index;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        count = 0;
        position = new int[n + 1];
        in = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        post = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        reader.close();

        for (int i = 0; i < n; i++) {
            position[post[i]] = i;
        }

        parse(0, n - 1);
    }
}
