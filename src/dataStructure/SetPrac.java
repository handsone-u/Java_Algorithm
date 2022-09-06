package dataStructure;

import java.util.HashSet;
import java.util.stream.IntStream;

/**
 * SET
 * Programmers 42890
 */
public class SetPrac {
    HashSet<HashSet<Integer>> cks = new HashSet<>();
    String[][] r;
    int col, row;

    public int solution(String[][] relation) {
        col = relation[0].length;
        row = relation.length;
        int[] indices = IntStream.range(0, col).toArray();
        boolean[] visited = new boolean[col];
        r = relation;

        for (int i = 1; i <= col; i++) {
            comb(indices, visited, i, 0, 0);
        }

        return cks.size();
    }

    private void comb(int[] arr, boolean[] v, int size, int begin, int current) {
        if (size == current) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < v.length; i++) if (v[i]) set.add(i);
            if(isMini(set)&&isUnique(set)) {
                System.out.println("set = " + set);
                cks.add(set);
            }
            return;
        }
        for (int i = begin; i < v.length; i++) {
            if(v[i]) continue;
            v[i] = true;
            comb(arr, v, size, i, current + 1);
            v[i] = false;
        }
    }

    private boolean isMini(HashSet<Integer> set) {
        for (HashSet<Integer> ck : cks) if (set.containsAll(ck)) return false;
        return true;
    }

    private boolean isUnique(HashSet<Integer> set) {
        HashSet<String> rows = new HashSet<>();
        for (int i = 0; i < row; i++) {
            String str = new String();
            for (Integer integer : set) str += r[i][integer];
            if(!rows.add(str)) return false;
        }
        return true;
    }
}
