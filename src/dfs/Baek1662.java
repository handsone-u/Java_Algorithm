package dfs;

import java.io.*;
import java.util.Stack;

/**
 * dfs-stack
 */
public class Baek1662 {
    static String str;
    static char[] arr;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        str = reader.readLine();
        arr = str.toCharArray();
        v = new boolean[arr.length];
        reader.close();
        int ans = 0;

        ans = dfs(0);

        writer.write(Integer.toString(ans));
        writer.flush();
        writer.close();
    }

    private static int dfs(int index) {
        int tmp = 0;
        for (int i = index; i < arr.length; i++) {
            if(v[i]) continue;
            v[i] = true;
            if(arr[i]=='(') {
                tmp--;
                tmp += (arr[i-1] - '0') * dfs(i + 1);
            }
            else if(arr[i]!=')') tmp++;
            else break;
        }
        return tmp;
    }
}
