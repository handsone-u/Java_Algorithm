package greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Greedy2812 {
    static int n,k;
    static String number;

    static void solution(BufferedWriter writer) throws IOException {
        Stack<Character> stack = new Stack<>();
        char[] arr = number.toCharArray();
        int todo = k;

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || stack.peek() >= arr[i]) {
                stack.add(arr[i]);
                continue;
            }
            while (!stack.isEmpty() && todo > 0 && stack.peek() < arr[i]) {
                stack.pop();
                todo--;
            }
            stack.add(arr[i]);
        }

        Character[] tmp = new Character[n - k];
        tmp = stack.toArray(tmp);

        int cnt = 0;
        for (Character character : tmp) {
            writer.write(character);
            cnt++;
            if (cnt >= n - k)
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        input(reader);
        solution(writer);

        writer.flush();
        writer.close();
    }

    private static void input(BufferedReader reader) throws IOException {
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = array[0];
        k = array[1];
        number = reader.readLine();
    }
}
