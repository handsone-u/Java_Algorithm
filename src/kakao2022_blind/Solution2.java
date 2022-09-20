package kakao2022_blind;

public class Solution2 {
    public int solution(int n, int k) {
        String converted = convert(n, k);
        return count(converted);
    }

    int count(String converted) {
        int count = 0;
        String[] nums = converted.split("0");
        for (String num : nums) {
            if(num.isEmpty()|| num.equals(" ")) continue;
            if(isPrime(Long.parseLong(num))) count++;
        }
        return count;
    }

    boolean isPrime(long n) {
        if(n<2) return false;
        for (int i = 2; (long) i * i <= n; i++) {
            if(n%i==0) return false;
        }
        return true;
    }

    String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();

        while (n / k > 0) {
            sb.append(n % k);
            n = n / k;
        }
        sb.append(n % k);

        return sb.reverse().toString();
    }
}
