package string;

import java.util.*;

class Solution72411 {
    HashMap<String, Integer> map = new HashMap<>();
    int[] maxValue = new int[11];

    public String[] solution(String[] orders, int[] course) {
        for (String order : orders) {
            int len = order.length();
            char[] arr = order.toCharArray();
            Arrays.sort(arr);

            for (int i : course) {
                if(len>=i) comb(arr, new char[i], -1, 0, i);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue()<=1 || maxValue[entry.getKey().length()] > entry.getValue()) continue;
            maxValue[entry.getKey().length()] = entry.getValue();
        }

        ArrayList<String> result = new ArrayList<>();
        for (int len : course) {
            int value = maxValue[len];

            for (Map.Entry<String, Integer> entry : map.entrySet())
                if (entry.getKey().length() == len && entry.getValue() == value) result.add(entry.getKey());
        }
        Collections.sort(result);
        return result.stream()
                .toArray(s -> new String[result.size()]);
    }

    private void comb(char[] arr, char[] result, int prev, int count, int target) {
        if (count >= target) {
            String key = String.valueOf(result);
            map.put(key, map.getOrDefault(key, 0) + 1);
            return;
        }
        for (int i = prev + 1; i < arr.length; i++) {
            result[count] = arr[i];
            comb(arr, result, i, count + 1, target);
            result[count] = 0;
        }
    }
}