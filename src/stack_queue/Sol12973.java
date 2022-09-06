package stack_queue;

import java.util.*;

//
public class Sol12973 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        final int len = s.length();

        for (int i = 0; i < len; i++) {
            if(stack.empty()||stack.peek()!=c[i]) stack.push(c[i]);
            else stack.pop();
        }

        return stack.empty() ? 1 : 0;
    }
}
