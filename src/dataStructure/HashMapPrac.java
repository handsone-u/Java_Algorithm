package dataStructure;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class HashMapPrac {
    static int n, m;
    static HashMap<String, Integer> nameToInt = new HashMap<>();
    static HashMap<Integer, String> intToName = new HashMap<>();

    static int solutionInt(String name) {
        return nameToInt.get(name);
    }

    static String solutionString(int index) {
        return intToName.get(index);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        input(reader);
        for (int i = 1; i <= m; i++) {
            String s = reader.readLine();
            char c = s.charAt(0);
            if (c >= '1' && c <= '9') {
                writer.write(solutionString(Integer.parseInt(s)));
            } else {
                writer.write(String.valueOf(solutionInt(s)));
            }
            writer.write('\n');
        }

        writer.flush();
        writer.close();
    }

    private static void input(BufferedReader reader) throws IOException {
        int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = tmp[0];
        m = tmp[1];

        for (int i = 1; i <= n ; i++) {
            String name = reader.readLine();
            nameToInt.put(name, i);
            intToName.put(i, name);
        }
    }
}
