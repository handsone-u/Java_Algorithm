package sort;

import java.util.Arrays;
import java.util.Comparator;

public class Sort70130 {
    Node[] nodes;

    private int sub(int len, int common,int[] a) {
        int result = 0;
        boolean[] check = new boolean[len];

        for (int i = 0; i < len; i++) {
            if(a[i]!=common||check[i]) continue;
            boolean v = false;
            if (i - 1 >= 0&& !check[i-1]) {
                if (a[i - 1] != common) {
                    check[i - 1] = check[i] = true;
                    v = true;
                    result += 2;
                }
            }
            if (i + 1 < len && !v) {
                if (a[i + 1] != common&&!check[i+1]) {
                    check[i + 1] = check[i] = true;
                    result += 2;
                }
            }
        }

        return result;
    }

    public int solution(int[] a) {
        int answer = 0;
        int len = a.length;
        nodes = new Node[len];
        for (int i = 0; i < len; i++) nodes[i] = new Node(i, 0);
        for (int i = 0; i < len; i++) nodes[a[i]].cnt++;
        Arrays.sort(nodes, Comparator.comparing(Node::getCnt, Comparator.reverseOrder()));

        for (int i = 0; i < len; i++) {
            if(nodes[i].cnt*2<=answer) continue;
            answer = Integer.max(answer, sub(len, nodes[i].num, a));
        }

        return answer;
    }

    static class Node{
        int num;
        int cnt;

        public Node(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        public int getNum() {
            return num;
        }

        public int getCnt() {
            return cnt;
        }
    }
}
