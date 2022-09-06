package string;

import java.util.HashSet;

public class Sol64064 {
    public int solution(String[] userId, String[] bannedId) {
        int answer = 0, userLen = userId.length, banLen = bannedId.length;
        HashSet<String> set = new HashSet<>();
        boolean[] v = new boolean[banLen];

        for (int i = 0; i < userLen; i++) {
            for (int j = 0; j < banLen; j++) {
                if(v[j]) continue;
                if(set.contains(userId[i])) continue;
                if(userId[i].length()!=bannedId[j].length()) continue;
                char[] uArr = userId[i].toCharArray();
                char[] bArr = bannedId[j].toCharArray();
                if(isOk(uArr, bArr)) {
                    set.add(String.valueOf(uArr));
                    v[j] = true;
                    answer++;
                }
            }
        }

        return answer;
    }

    boolean isOk(char[] u, char[] b) {
        for (int i = 0; i < u.length; i++) {
            if(b[i]=='*') continue;
            if(u[i]!=b[i]) return false;
        }
        return true;
    }
}
