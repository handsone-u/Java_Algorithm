package kakao2022_intern;

import java.util.HashMap;

public class Solution1 {
    HashMap<Character, Integer> p = new HashMap<>();
    char R = 'R';
    char T = 'T';
    char C = 'C';
    char F = 'F';
    char J = 'J';
    char M = 'M';
    char A = 'A';
    char N = 'N';

    public String solution(String[] survey, int[] choices) {
        String answer = "";
        init();

        int len = survey.length;
        for (int i = 0; i < len; i++) {
            toPoint(survey[i], choices[i]);
        }

        answer = getAnswer();

        return answer;
    }

    private String getAnswer() {
        StringBuilder sb = new StringBuilder();
        if(p.get(R)>=p.get(T)) sb.append(R);
        else sb.append(T);
        if(p.get(C)>=p.get(F)) sb.append(C);
        else sb.append(F);
        if(p.get(J)>=p.get(M)) sb.append(J);
        else sb.append(M);
        if(p.get(A)>=p.get(N)) sb.append(A);
        else sb.append(N);

        return sb.toString();
    }

    private void toPoint(String str, int c) {
        if (c == 4) return;
        char target;

        if (c <= 3) {
            target = str.charAt(0);
        } else {
            target = str.charAt(1);
        }

        Integer point = p.get(target) + value(c);
        p.put(target, point);
    }

    private int value(int index) {
        if(index==1||index==7) return 3;
        else if(index==2||index==6) return 2;
        else return 1;
    }

    private void init() {
        p.put(R, 0);
        p.put(T, 0);
        p.put(C, 0);
        p.put(F, 0);
        p.put(J, 0);
        p.put(M, 0);
        p.put(A, 0);
        p.put(N, 0);
    }
}
