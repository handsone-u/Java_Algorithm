package hashPractice;

import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * HashMap
 * Comparator
 */
public class Baek11652 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        Num[] nums = map.entrySet().stream()
                .map(e -> new Num(e.getKey(), e.getValue()))
                .sorted(Comparator.comparing(Num::getCount, Comparator.reverseOrder())
                        .thenComparingLong(nx -> Long.parseLong(nx.getNum())))
                .toArray(Num[]::new);

        writer.write(nums[0].getNum());
        writer.flush();
        writer.close();
    }

    static class Num{
        String num;
        int count;

        public String getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }

        public Num(String num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
