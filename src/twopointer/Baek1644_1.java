package twopointer;

import java.io.*;
import java.util.ArrayList;

public class Baek1644_1 {
    static int n;
    static int answer;
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        reader.close();
        addPrimes(n);

        int size = primes.size();
        for (int i = 0; i < size; i++) {
            int prefixSum = 0;
            int j = i;
            while (j<size&&prefixSum<n) prefixSum += primes.get(j++);
            if(prefixSum==n) answer++;
        }

        writer.write(String.valueOf(answer));
        writer.flush();
        writer.close();
    }

    private static void addPrimes(int n) {
        for (int i = 2; i <= n; i++) {
            if(isPrime(i)) primes.add(i);
        }
    }

    private static boolean isPrime(int x) {
        for (int i = 2; i <= Math.sqrt(x) ; i++) {
            if(x%i==0) return false;
        }
        return true;
    }
}
