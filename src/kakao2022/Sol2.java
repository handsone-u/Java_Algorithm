package kakao2022;

import java.util.*;

public class Sol2 {
    public int solution(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.append(n % k);
            n /= k;
        }
        sb.reverse();
        String t = new String(sb);
        String[] split = t.split("0");
        int cnt = 0;

        for (String s : split) {
            System.out.println("s = " + s);
            if (s.isEmpty() || s.equals("") || s == " ") continue;
            try {
                long tmp = Long.parseLong(s);
                if (isPrime(tmp)) cnt++;
            } catch (NumberFormatException e){
                System.out.println("!s = " + s);
            }
        }

        return cnt;
    }

    boolean isPrime(long n) {
        if(n==1) return false;
        else if(n==2) return true;
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
