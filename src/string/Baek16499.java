package string;

import java.io.*;
import java.util.*;

public class Baek16499 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String result = align(reader.readLine());
            map.put(result, 1);
        }

        writer.write(String.valueOf(map.size()));
        writer.flush();
        writer.close();
    }

    private static String align(String original) {
        char[] chars = original.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }
        list.sort(Comparator.naturalOrder());
        String s = Arrays.toString(list.stream().toArray(Character[]::new));
        return s;
    }
}
