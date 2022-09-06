package string;

public class Sol60057 {
    public int solution(String s) {
        int len = s.length();
        int answer = len;

        for (int i = 1; i <= len / 2; i++)
            answer = Integer.min(answer, solve(s, i));

        return answer;
    }

    private int solve(String s, int k) {
        int len = s.length();
        int size = len / k;
        String[] split = new String[size];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            int offSet = i * k;
            split[i] = s.substring(offSet, offSet + k);
        }
        int i = 0;
        while (i < size) {
            int count = 1;
            int j;

            for (j = i+1; j < size; j++) {
                if(!split[i].equals(split[j])) break;
                count++;
            }

            if(count>1) sb.append(count);
            sb.append(split[i]);
            i = j;
        }

        sb.append(s.substring(size * k));
        return sb.length();
    }
}
