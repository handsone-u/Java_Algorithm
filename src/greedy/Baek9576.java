package greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Baek9576 {
    static int t;
    static BookRef[] bookRef;
    static boolean[] checked;

    private static int solution(int m) {
        int ans = 0;

        Arrays.sort(bookRef, Comparator.comparing(BookRef::getB));
        for (int i = 0; i < m; i++) {
            for (int j = bookRef[i].getA(); j <= bookRef[i].getB(); j++) {
                if(checked[j]) continue;

                checked[j] = true;
                ans++;
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m;
        t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int[] tmp = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            n = tmp[0];
            m = tmp[1];
            bookRef = new BookRef[m];
            checked = new boolean[n + 1];

            for (int j = 0; j < m; j++) {
                tmp = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                bookRef[j] = new BookRef(tmp[0], tmp[1]);
            }

            writer.write(String.valueOf(solution(m)));
            writer.write('\n');
        }

        reader.close();
        writer.flush();
        writer.close();
    }

    static class BookRef{
        private int a;
        private int b;

        public BookRef(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }
}
