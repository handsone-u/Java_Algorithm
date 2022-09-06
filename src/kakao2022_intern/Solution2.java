package kakao2022_intern;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    long sum1 = 0;
    long sum2 = 0;
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int len = queue1.length;

        if (init(queue1, queue2)) {
            return -1;
        }

        while (!isDone()) {
            shift();
            answer++;
            if (answer >= len * 4) {
                answer = -1;
                break;
            }
        }

        return answer;
    }

    private boolean isDone() {
        return sum1 == sum2;
    }

    private void shift() {
        if (sum1 > sum2) {
            Integer value = q1.poll();
            sum1 -= value;
            sum2 += value;
            q2.add(value);
        } else {
            Integer value = q2.poll();
            sum2 -= value;
            sum1 += value;
            q1.add(value);
        }
    }

    private boolean init(int[] queue1, int[] queue2) {
        long total = 0;
        int max = 0;

        for (int i : queue1) {
            total += i;
            q1.add(i);
            sum1 += i;
            if(i>max)
                max = i;
        }
        for (int i : queue2) {
            total += i;
            q2.add(i);
            sum2 += i;
            if(i>max)
                max = i;
        }

        return isNotPromise(total, max);
    }

    private boolean isNotPromise(long total, int max) {
        return total % 2 != 0
                || max > total / 2;
    }
}
