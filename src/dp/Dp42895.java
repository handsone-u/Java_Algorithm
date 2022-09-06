package dp;

import java.util.*;

public class Dp42895 {
    public int solution(int N, int number) {
        if (N==number)
            return 1;

        Set<Integer>[] sets = new HashSet[8 + 1];
        for (int i = 0; i < 9; i++) sets[i] = new HashSet<>();
        int m = N;
        for (int i = 1; i <= 8 ; i++) {
            sets[i].add(m);
            m = m * 10 + N;
        }

        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                int k = i - j;
                calculate(sets, j, k, i);
            }

            if(sets[i].contains(number)){
                return i;
            }
        }

        return -1;
    }

    private void calculate(Set<Integer>[] sets, int j, int k,int count) {
        for (int x : sets[j]) {
            for (int y : sets[k]) {
                sets[count].add(x + y);
                sets[count].add(x - y);
                sets[count].add(x * y);
                if (y!=0) sets[count].add(x / y);
            }
        }
    }
}
