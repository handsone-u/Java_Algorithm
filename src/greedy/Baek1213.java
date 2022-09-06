package greedy;

import java.io.*;

public class Baek1213 {
    static final String WRONG = "I'm Sorry Hansoo\n";
    static String input;
    static String answer = "";

    private static boolean solution() {
        int len = input.length();
        int[] count = new int[26];
        char[] arr = input.toCharArray();
        char[] tmp = new char[len];

        for (int i = 0; i < len; i++)
            count[arr[i] - 'A']++;
        if(impossible(count))
            return false;

        int done = 0;
        if (len % 2 > 0) {
            int oddIndex = getOddIndex(count);
            tmp[len / 2] = (char) ('A' + oddIndex);
            count[oddIndex]--;
        }
        for (int i = 0; i < 26; i++) {
            if(count[i]==0) continue;
            for (int j = 0; j < count[i] / 2; j++) {
                tmp[done + j] = tmp[len - 1 - done - j] = (char) ('A' + i);
            }
            done += count[i] / 2;
        }

        answer = new String(tmp);
        return true;
    }

    private static int getOddIndex(int[] count) {
        for (int i = 0; i < 26; i++) {
            if(count[i]%2!=0) return i;
        }
        return -1;
    }

    private static boolean impossible(int[] count) {
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if(count[i]%2==0) continue;
            if(++odd>1) return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        input = reader.readLine();
        reader.close();
        writer.write(solution() ? answer : WRONG);
        writer.flush();
        writer.close();
    }
}
