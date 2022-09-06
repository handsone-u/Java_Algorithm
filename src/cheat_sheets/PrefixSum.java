package cheat_sheets;

import java.util.Random;

public class PrefixSum {
    static int[] arr;
    static int[] sum;

    public static void main(String[] args) {
        int arrLen = 10;
        input(arrLen);

        sum = new int[arrLen + 1];
        // 부분 합
        for (int i = 0; i < arrLen; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }

        // 구간 합
        int from = 2;
        int to = 7;
        int result = sum[to + 1] - sum[from];
    }

    private static void input(int arrLen) {
        Random random = new Random();
        arr = new int[arrLen];
        for (int i = 0; i < arrLen; i++) arr[i] = random.nextInt();
    }
}
