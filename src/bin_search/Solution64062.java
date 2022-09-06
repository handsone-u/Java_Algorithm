package bin_search;

public class Solution64062 {
    int n,max,min;

    public int solution(int[] stones, int k) {
        int answer = 0;
        n = stones.length;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            max = Integer.max(max, stones[i]);
            min = Integer.min(min, stones[i]);
        }

        while (min <= max) {
            int m = (min + max) / 2;
            if (possible(stones, k, m)) {
                answer = m;
                min = m + 1;
            } else {
                max = m - 1;
            }
        }

        return answer;
    }

    public boolean possible(int[] stones, int k, int current) {
        int count = 0;
        int i = 0;
        while (i < n) {
            while (i < n && stones[i] >= current) i++;
            if(i>=n) break;
            int j = i+1;
            while (j < n && stones[j] < current) j++;
            count = Integer.max(count, j - i);
            i = j + 1;
        }
        return count + 1 <= k;
    }
}
