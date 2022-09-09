package twopointer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class TwoPointer {
    public int[] solution(String[] gems) {
        int minLength = gems.length + 1;
        int[] answer = new int[2];

        HashSet<String> all = new HashSet<>(Arrays.asList(gems));

        HashMap<String, Integer> now = new HashMap<>();
        now.put(gems[0], 1);
        int i, j;
        i = 0;
        j = 1;
        while (i < j && j <= gems.length) {
            while (j < gems.length && now.keySet().size() < all.size()) {
                now.put(gems[j], now.getOrDefault(gems[j], 0) + 1);
                j++;
            }
            if (now.keySet().size() >= all.size() && minLength > j - i) {
                minLength = j - i;
                answer[0] = i + 1;
                answer[1] = j;
            }
            int value = now.get(gems[i]) - 1;
            if (value == 0) now.remove(gems[i]);
            else now.put(gems[i], value);
            i++;
        }

        return answer;
    }
}