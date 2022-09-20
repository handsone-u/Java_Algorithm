package kakao2022_blind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Solution1 {
    HashMap<String, HashSet<String>> reported = new HashMap<>();
    HashMap<String, HashSet<String>> reportHistory = new HashMap<>();
    ArrayList<String> users = new ArrayList<>();
    int userLength, reportLength;

    public int[] solution(String[] id_list, String[] report, int k) {
        init(id_list, report);
        return solve(k);
    }

    int[] solve(int k) {
        int[] answer = new int[userLength];

        for (int i = 0; i < userLength; i++) {
            int count = 0;
            String reporter = users.get(i);
            HashSet<String> history = reportHistory.get(reporter);
            for (String reportedId : history) {
                if(reported.get(reportedId).size()>=k) count++;
            }
            answer[i] = count;
        }

        return answer;
    }

    void init(String[] idList, String[] report) {
        userLength = idList.length;
        reportLength = report.length;

        for (String id : idList) {
            users.add(id);
            reportHistory.put(id, new HashSet<>());
            reported.put(id, new HashSet<>());
        }
        for (String r : report) {
            String[] ids = r.split(" ");
            reportHistory.get(ids[0]).add(ids[1]);
            reported.get(ids[1]).add(ids[0]);
        }
    }
}
