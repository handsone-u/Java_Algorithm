package dataStructure;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SuffixArray {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = reader.readLine();
        int len = str.length();
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            String tmp = str.substring(i, len);
            ans.add(tmp);
        }

        Collections.sort(ans);
        for (String s : ans) {
            writer.write(s);
            writer.write('\n');
        }
        writer.flush();
        writer.close();
    }
}
