package twopointer;

import java.io.*;
import java.util.ArrayList;

public class Baek1644 {
    static int n, size, ans;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        reader.close();
        addList();

        int i, j;
        i = j = 0;
        while (i <= j&&j<size) {
            long sum = getRange(i, j);
            if(sum==n) ans++;
            if(sum>=n) i++;
            else j++;
        }
        writer.write(Integer.toString(ans));
        writer.flush();
        writer.close();
    }

    public static long getRange(int i, int j) {
        long result = 0;
        for (int k = i; k <= j; k++) result += arr.get(k);
        return result;
    }

    public static void addList() {
        for (int i = 2; i <= n; i++)
            if (isPrime(i)) arr.add(i);
        size = arr.size();
    }

    static boolean isPrime(int x) {
        for (int i = 2; i*i <= x; i++)
            if(x%i==0) return false;
        return true;
    }
}
