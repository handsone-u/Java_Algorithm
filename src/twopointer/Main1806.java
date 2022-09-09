package twopointer;
import java.io.*;
import java.util.Arrays;

/**
 * 1806
 * two-pointer
 */
public class Main1806 {
    static BufferedReader br;
    static BufferedWriter bw;
    static int n, s, min, ans;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        init();
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = tmp[0];
        s = tmp[1];
        min = n + 1;
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int second = 0, sum = 0;
        for (int first = 0; first < n; first++) {
            while (second < n && sum < s) sum += arr[second++];
            if(sum>=s) min = Integer.min(min, second - first);
            sum -= arr[first];
        }

        ans = min > n ? 0 : min;
        bw.write(Integer.toString(ans));
        closing();
    }


    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void closing() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }
}
