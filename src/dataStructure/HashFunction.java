package dataStructure;

import java.io.*;

public class HashFunction {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long r = 31, m = 1234567891, ans = 0;
        int len = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        char[] chars = str.toCharArray();
        reader.close();

        long ri = 1;
        for (int i = 0; i < len; i++) {
            ans = (ans + getHash(ri, m, chars[i])) % m;
            ri *= r;
            ri %= m;
        }

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }

    private static long getHash(long ri, long m, char c) {
        long val = c - 'a' + 1;
        return (val * ri) % m;
    }
}
