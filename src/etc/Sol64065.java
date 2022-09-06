package etc;

import java.util.*;

public class Sol64065 {
    public int[] solution(String str) {
        int[] answer;
        ArrayList<int[]> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        String[] split = str.split("\\},\\{");

        for (String s : split) {
            s = s.replace("{", "")
                    .replace("}", "");

            String[] line = s.split(",");
            int[] tmp = Arrays.stream(line)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            arr.add(tmp);
        }
        Collections.sort(arr, Comparator.comparingInt(i -> i.length));

        int size = arr.size();
        answer = new int[size];

        for (int i = 0; i < size; i++) {
            int[] tmp = arr.get(i);
            for (int k : tmp) {
                if (set.contains(k)) continue;
                else {
                    set.add(k);
                    answer[i] = k;
                }
            }
        }

        return answer;
    }
}
