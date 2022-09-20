package kakao2022_blind;

import java.util.Arrays;

class Solution4 {
    int max = -100;
    int[] ryan = new int[11];
    int[] fail = {-1};

    public int[] solution(int n, int[] info) {
        dfs(info, ryan, 0, n);

        if(max<=0) return fail;
        return ryan;
    }

    void dfs(int[] a, int[] r, int from, int remain) {
        if (remain <= 0 || from >= 11) {
            cmp(a, r);
            return;
        }

        for (int i = from; i < 11; i++) {
            if (i == 10) {
                r[i] = remain;
                dfs(a, r, 11, 0);
                r[i] = 0;
                continue;
            }
            if (a[i] >= remain) continue;
            r[i] = a[i] + 1;
            dfs(a, r, i + 1, remain - r[i]);
            r[i] = 0;
        }
    }

    void cmp(int[] a, int[] r) {
        int result = 0;
        for (int i = 0; i < 11; i++) {
            if(a[i]==0&&r[i]==0) continue;
            if(a[i]>=r[i]) result -= (10 - i);
            else result += 10 - i;
        }
        if (result > max) {
            max = result;
            ryan = Arrays.copyOf(r, r.length);
        } else if (result == max) {
            if (less(r)) {
                ryan = Arrays.copyOf(r, r.length);
            }
        }
    }

    boolean less(int[] r) {
        for (int i = 10; i >= 0; i--) {
            if(ryan[i]<r[i]) return true;
            else if (ryan[i]>r[i]) return false;
        }
        return false;
    }
}