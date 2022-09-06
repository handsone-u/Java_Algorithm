package stack_queue;
import java.util.*;

public class Sol42583 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer, currentWeight, done, todo, next;
        answer = currentWeight = done = next = 0;

        todo = truck_weights.length;

        Queue<Integer> q = new LinkedList<>();
        while (done < todo) {
            answer++;
            if (q.size() >= bridge_length) {
                Integer poll = q.poll();
                currentWeight -= poll;
                if(poll>0) done++;
            }
            int nextWeight = truck_weights[next];
            if (nextWeight + currentWeight <= weight) {
                currentWeight += nextWeight;
                q.add(nextWeight);
                if(next<todo-1) next++;
            } else q.add(0);
        }
        return answer;
    }
}
