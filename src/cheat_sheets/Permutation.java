package cheat_sheets;

public class Permutation {
    char[] member = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    int ans;

    public int solution(int n, String[] data) {
        permutation(data, new char[8], new boolean[8], 0, 8);
        return ans;
    }

    private boolean isPossible(char[] arr, String[] data) {
        for (String d : data) {
            char x = d.charAt(0);
            char y = d.charAt(2);
            char op = d.charAt(3);
            int v = d.charAt(4) - '0';

            int xi = indexOf(arr, x);
            int yi = indexOf(arr, y);
            int offset = Math.abs(xi - yi) - 1;
            if (op == '=') {
                if(offset!=v) return false;
            } else if (op == '>') {
                if(offset<=v) return false;
            } else {
                if(offset>=v) return false;
            }
        }
        return true;
    }

    private int indexOf(char[] arr, char target) {
        for (int i = 0; i < 8; i++) {
            if(arr[i]==target) return i;
        }
        return -1;
    }

    private void permutation(String[] data,char[] arr, boolean[] v, int count, int target) {
        if (count == target) {
            if(isPossible(arr, data)) ans++;
            return;
        }

        for (int i = 0; i < target; i++) {
            if(v[i]) continue;
            arr[count] = member[i];
            v[i] = true;
            permutation(data, arr, v, count + 1, target);
            v[i] = false;
            arr[count] = 0;
        }
    }
}
