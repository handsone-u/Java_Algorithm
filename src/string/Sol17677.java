package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Sol17677 {
    public int solution(String str1, String str2) {
        int answer = 0;
        int up = 0, down = 0;
        double result = 0;

        String[] c1 = chop(str1);
        String[] c2 = chop(str2);
        for (String s : c1) System.out.printf("[%s] ", s);
        System.out.println();
        for (String s : c2) System.out.printf("[%s] ", s);
        System.out.println();
        
        int c1Len = c1.length, c2Len = c2.length;
        boolean[] c1V = new boolean[c1Len], c2V = new boolean[c2Len];
        if(c1Len==0&&c2Len==0) return 65536;

        for (int i = 0; i < c1Len; i++) {
            for (int j = 0; j < c2Len; j++) {
                if(c2V[j]) continue;
                if(c1[i].equals(c2[j])){
                    c1V[i] = c2V[j] = true;
                    up++;
                    break;
                }
            }
        }

        down = c1Len + c2Len - up;

        System.out.printf("%d / %d\n", up, down);

        result = (double) up / down;
        answer = (int) (result * 65536);
        return answer;
    }

    private String[] chop(String str){
        str = str.toLowerCase();
        ArrayList<String> list = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i+1 < chars.length; i++)
            if (isChar(chars[i]) && isChar(chars[i + 1])) {
                list.add(String.valueOf(chars[i]) + chars[i + 1]);
            }
        String[] result = list.stream().toArray(String[]::new);
        Arrays.sort(result);
        return result;
    }

    private boolean isChar(char aChar) {
        return aChar>='a'&&aChar<='z';
    }
}
