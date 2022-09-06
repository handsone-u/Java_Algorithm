package stack_queue;

import java.io.*;
import java.util.Stack;

public class Stack9012 {
    static int n;

    static boolean solution(String str) {
        char[] arr = str.toCharArray();
        int len = arr.length;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            if (arr[i] == '(') {
                stack.add('(');
            } else {
                if(stack.isEmpty()||stack.peek()==')') return false;
                else stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            if(solution(reader.readLine()))
                writer.write("YES\n");
            else
                writer.write("NO\n");
        }

        writer.flush();
        writer.close();
    }
}
