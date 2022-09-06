package stack_queue;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    //42586
    private boolean mod0(int x, int mod) {
        return x % mod == 0;
    }

    public int[] solution42586(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int[] todo = new int[len];
        for (int i = 0; i < len; i++) {
            int rem = (100 - progresses[i]) / speeds[i];
            todo[i] = mod0(100 - progresses[i], speeds[i]) ? rem : rem + 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        int cnt = 0, top = todo[0];
        for (int i : todo) {
            if(i<=top) cnt++;
            else{
                queue.add(cnt);
                cnt = 1;
                top = i;
            }
        }
        queue.add(cnt);

        return queue.stream().mapToInt(i -> i).toArray();
    }

    public int solution42587(int[] priorities, int location) {
        int len = priorities.length,cnt=1;
        int[] ans = new int[len];
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(IntStream.range(0, len).boxed().collect(Collectors.toList()));

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            int max = Arrays.stream(priorities).max().getAsInt();
            if(priorities[poll]>=max){
                ans[poll] = cnt++;
                priorities[poll] = -1;
            } else queue.add(poll);
        }
        return ans[location];
    }
}
