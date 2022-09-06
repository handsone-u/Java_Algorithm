package dataStructure;

import java.util.*;

/**
 * Priority Queue ... time complexity
 */
public class PriorityQueuePrac {
    public int solution(int[] food_times, long k) {
        int answer = 0, len = food_times.length, time = 0, passed = 0;
        PriorityQueue<Food> pq = new PriorityQueue<>(Comparator.comparing(Food::getRemain));
        for (int i = 0; i < len; i++) pq.add(new Food(i + 1, food_times[i]));
        while (!pq.isEmpty()) {
            int size = pq.size();
            Food peek = pq.peek();
            int min = peek.getRemain() - passed;
            long cycle = (long) size * min;
            if (k >= cycle) {
                k -= cycle;
                passed += min;
            } else {
                int mod = (int) (k % size);
                int[] ints = pq.stream().mapToInt(Food::getIndex).sorted().toArray();
                return ints[mod];
            }
            pq.poll();
        }
        return -1;
    }

    static class Food{
        public int index;
        public int remain;

        public Food(int index, int remain) {
            this.index = index;
            this.remain = remain;
        }

        public int getIndex() {
            return index;
        }

        public int getRemain() {
            return remain;
        }

        @Override
        public String toString() {
            return Integer.valueOf(index).toString() + " " + Integer.valueOf(remain).toString();
        }
    }
}
