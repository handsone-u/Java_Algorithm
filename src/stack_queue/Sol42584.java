package stack_queue;

import java.util.Stack;

public class Sol42584 {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.empty() && prices[stack.peek()] > prices[i]) {
                Integer pop = stack.pop();
                answer[pop] = i - pop;
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            Integer pop = stack.pop();
            answer[pop] = len - 1 - pop;
        }

        return answer;
    }
}
