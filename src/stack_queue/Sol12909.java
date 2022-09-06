package stack_queue;

import java.util.Stack;

public class Sol12909 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();

        for (char c : arr) {
            if(c=='(') stack.add('(');
            else if (c == ')') {
                if(stack.isEmpty()) return false;
                Character peek = stack.peek();
                if(peek==')') return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return false;

        return true;
    }
}
