package greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek13904 {
    static int n;
    static Assign[] assigns;
    static int[] sch = new int[1001];

    private static int solution() {
        for (int i = 0; i < n; i++) {
            int due = assigns[i].getDue();
            int weight = assigns[i].getWeight();
            int index = getIndex(due);
            if(index==-1) continue;

            sch[index] = weight;
        }

        return Arrays.stream(sch).parallel().sum();
    }

    private static int getIndex(int from) {
        for (int i = from; i > 0 ; i--) {
            if(sch[i]==0) return i;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        assigns = new Assign[n];
        for (int i = 0; i < n; i++) {
            int[] tmp = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt)
                    .toArray();
            assigns[i] = new Assign(tmp[0], tmp[1]);
        }
        reader.close();

        Arrays.sort(assigns, Comparator.comparing(Assign::getWeight, Comparator.reverseOrder()));

        writer.write(String.valueOf(solution()));
        writer.flush();
        writer.close();
    }

    static class Assign{
        int due;
        int weight;

        public Assign(int due, int weight) {
            this.due = due;
            this.weight = weight;
        }

        public int getDue() {
            return due;
        }

        public int getWeight() {
            return weight;
        }
    }
}
