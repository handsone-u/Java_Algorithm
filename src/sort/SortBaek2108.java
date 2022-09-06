package sort;

import java.io.*;
import java.util.Arrays;

public class SortBaek2108 {
    static int n;
    static int[] arr, count;
    static int mostFreq, midVal, range, min, max;
    static double arithmeticAvg;

    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        arithmeticAvg = range = mostFreq = midVal = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        int mostFreqCount = 0;
        n = Integer.parseInt(reader.readLine());
        arr = new int[n];
        count = new int[8001];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
            if(arr[i]>max) max = arr[i];
            if(arr[i]<min) min = arr[i];
            count[arr[i] + 4000]++;
            if(count[arr[i]+4000]>mostFreqCount) {
                mostFreqCount = count[arr[i] + 4000];
            }
            sum += arr[i];
        }
        Arrays.sort(arr);

        arithmeticAvg = (double) sum / n;
        midVal = arr[n / 2];
        mostFreq = getSecondMostFreq(mostFreqCount);
        range = max - min;

        writeResult(writer);
    }

    static int getSecondMostFreq(int value) {
        int candy = 0;
        int tmp = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] == value) {
                candy = i - 4000;
                tmp++;
                if(tmp>=2)
                    return candy;
            }
        }

        return candy;
    }

    private static void writeResult(BufferedWriter writer) throws IOException {
        writer.write(String.valueOf((int)Math.round(arithmeticAvg)) + "\n");
        writer.write(String.valueOf(midVal) + "\n");
        writer.write(String.valueOf(mostFreq) + "\n");
        writer.write(String.valueOf(range) + "\n");
        writer.flush();
        writer.close();
    }
}
