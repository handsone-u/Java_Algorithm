package dfs;

import java.util.*;

/**
 * dfs
 */
public class Sol86971 {
    int[] nodes;
    boolean[] v;

    public int solution(int n, int[][] wires) {
        int answer = n;
        nodes = new int[n+1];
        v = new boolean[n + 1];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }

        dfs(list, 1);

        for (int i = 2; i <= n; i++) {
            int gap = Math.abs((n - nodes[i]) - nodes[i]);
            if(answer>gap) answer = gap;
        }

        return answer;
    }

    private int dfs(List<List<Integer>> list, int index) {
        v[index] = true;
        if(nodes[index]!=0) return nodes[index];
        List<Integer> now = list.get(index);
        int cnt = 1;
        for (Integer integer : now){
            if(v[integer]) continue;
            cnt += dfs(list, integer);
        }

        return nodes[index] = cnt;
    }
}
