package twopointer;

public class Sol12924 {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j <= n) {
                int sum = getSum(i-1, j);
                if(sum==n)
                    answer++;
                else if (sum > n)
                    break;
                j++;
            }
        }

        return answer;
    }

    int getSum(int from, int to) {
        int result = 0;
        result = (to) * (to + 1) / 2;
        result -= (from) * (from + 1) / 2;
        return result;
    }
}
