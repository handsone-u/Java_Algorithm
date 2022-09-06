package cheat_sheets;

import java.util.*;

class UnionFindLongIndex {
    Map<Long, Long> map = new HashMap<>();

    private long findKey(long num) {
        if (!map.containsKey(num)) {
            map.put(num, num + 1);
            return num;
        }

        Long key = map.get(num);
        long next = findKey(key);
        map.put(num, next);
        return next;
    }

    public long[] solution(long k, long[] room_number) {
        int n = room_number.length;
        long[] answer = new long[n];

        for (int i = 0; i < n; i++)
            answer[i] = findKey(room_number[i]);

        return answer;
    }
}