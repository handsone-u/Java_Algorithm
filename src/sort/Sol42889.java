package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Sol42889 {
    public int[] solution(int n, int[] stages) {
        double[] rate = new double[n];
        Arrays.sort(stages);
        int failed = 0;
        for (int i = 0; i < rate.length; i++) {
            int level = i + 1,
                    passed = 0,
                    yet = 0;
            for (int j = failed; j < stages.length; j++) {
                if (stages[j] > level) passed++;
                else if (stages[j] == level) yet++;
                else failed++;
            }
            if(passed+yet==0) rate[i] = 0;
            else rate[i] = yet / (double)(yet + passed);
        }
        Comparator<Tmp> tmpComparator = Comparator.comparing(Tmp::getRate, Comparator.reverseOrder()).thenComparing(Tmp::getIndex);
        int[] ints = IntStream.range(0, rate.length)
                .mapToObj(i -> new Tmp(i+1, rate[i]))
                .sorted(tmpComparator)
                .peek(t -> System.out.println(t.getRate()))
                .mapToInt(Tmp::getIndex)
                .toArray();
        return ints;
    }

    static class Tmp {
        int index;
        double rate;

        public Tmp(int index, double rate) {
            this.index = index;
            this.rate = rate;
        }

        public int getIndex() {
            return index;
        }

        public double getRate() {
            return rate;
        }
    }
}
