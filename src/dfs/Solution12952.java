package dfs;

public class Solution12952 {
    int[] arr;

    private int dfs(int n, int index) {
        // 재귀 종료 조건!
        if (index > n) return 1;

        int result = 0;

        for (int i = 1; i <= n; i++) {
            if(!possible(n,index, i)) continue;
            arr[index] = i;
            result += dfs(n, index + 1);
        }

        return result;
    }

    private boolean possible(int n, int index, int pos) {
        if (index == 1) return true;
        // 1. COLUMN
        for (int i = 1; i < index; i++) {
            if(arr[i]==pos) return false;
        }

        // 2. I+J (index+pos)
        int v1 = index + pos;
        for (int i = 1; i < index; i++) {
            if(i+arr[i]==v1) return false;
        }

        // 3. I-J
        int v2 = index - pos;
        for (int i = 1; i < index; i++) {
            if(i-arr[i]==v2) return false;
        }
        return true;
    }

    public int solution(int n) {
        int answer = 0;
        arr = new int[n + 1];

        answer += dfs(n, 1);

        return answer;
    }
}
