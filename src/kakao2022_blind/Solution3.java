package kakao2022_blind;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution3 {
    String IN = "IN", OUT = "OUT";
    HashMap<String, Integer> history = new HashMap<>();
    Map<String, Integer> totalMinute = new LinkedHashMap<>();

    public int[] solution(int[] fees, String[] records) {
        init(fees, records);
        return totalMinute.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .mapToInt(entry -> getTotalFee(fees, entry.getValue()))
                .toArray();
    }

    int getTotalFee(int[] fees, int minute) {
        int result = fees[1];
        minute -= fees[0];

        if (minute > 0) {
            int count = minute / fees[2];
            if(minute%fees[2]!=0) count++;
            result += count * fees[3];
        }

        return result;
    }

    void init(int[] fees, String[] records) {
        for (String record : records) {
            String[] str = record.split(" ");
            String outTime = str[0];
            String car = str[1];
            if (str[2].equals(IN)) {
                history.put(car, toMinute(outTime));
            } else {
                int gap = toMinute(outTime) - history.get(car);
                history.remove(car);
                totalMinute.put(car, totalMinute.getOrDefault(car, 0) + gap);
            }
        }
        for (Map.Entry<String, Integer> entry : history.entrySet()) {
            int gap = toMinute("23:59") - entry.getValue();
            totalMinute.put(entry.getKey(), totalMinute.getOrDefault(entry.getKey(), 0) + gap);
        }
        for (Map.Entry<String, Integer> entry : totalMinute.entrySet()) {

        }
    }

    int toMinute(String time) {
        String[] str = time.split(":");
        return Integer.parseInt(str[0]) * 60
                + Integer.parseInt(str[1]);
    }
}
