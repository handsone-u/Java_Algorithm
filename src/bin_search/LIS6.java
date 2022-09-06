package bin_search;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LIS6 {
    static int n,ans;
    static int[] arr, track;
    final static ArrayList<Integer> lis = new ArrayList<>();

    static void solution() {
        lis.add(arr[0]);
        track[0] = ++ans;
        for (int i = 1; i < n; i++) {
            if(arr[i]>lis.get(lis.size()-1)) {
                lis.add(arr[i]);
                track[i] = ++ans;
            }
            else{
                int index = lowerBound(arr[i]);
                track[i] = index+1;
                lis.set(index, arr[i]);
            }
        }
    }

    static int lowerBound(int value) {
        int left = 0;
        int right = lis.size() - 1;

        return binSearch(left, right, value);
    }

    static int binSearch(int left, int right, int value) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (lis.get(mid) >= value)
                right = mid;
            else
                left = mid + 1;
        }

        return right;
    }

    static void printResult(BufferedWriter writer) throws IOException {
        int i = n - 1;
        Stack<Integer> stack = new Stack<>();
        while (i >= 0) {
            if (track[i] == ans) {
                stack.add(arr[i]);
                ans--;
            }
            if(ans<1) break;
            i--;
        }

        while (!stack.isEmpty()) {
            writer.write(String.valueOf(stack.pop()));
            writer.write(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        track = new int[n + 1];

        solution();

        writer.write(String.valueOf(ans) + "\n");
        printResult(writer);
        writer.flush();
        writer.close();
    }
}
