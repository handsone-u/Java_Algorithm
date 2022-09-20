package kakao2022_blind;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution5 {
    int n;
    int max = 1;
    Node[] nodes;

    public int solution(int[] info, int[][] edges) {
        n = info.length;
        nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(i, info[i] == 0);
        for (int[] edge : edges) nodes[edge[0]].next.add(nodes[edge[1]]);

        Set<Node> head = new HashSet<>();
        head.add(nodes[0]);

        dfs(head, 1, 0);

        return max;
    }

    void dfs(Set<Node> visited, int sheep, int wolf) {
        if (sheep <= wolf) return;

        Set<Node> toAdd = new HashSet<>();
        for (Node node : visited) {
            ArrayList<Node> next = node.next;
            for (Node child : next) {
                if(visited.contains(child)) continue;
                if (child.isSheep) {
                    sheep++;
                    toAdd.add(child);
                }
            }
        }
        visited.addAll(toAdd);
        if (sheep > max) {
            max = sheep;
        }

        for (Node node : visited) {
            ArrayList<Node> next = node.next;
            for (Node child : next) {
                if(visited.contains(child)) continue;
                if (!child.isSheep) {
                    HashSet<Node> nextVisited = new HashSet<>(visited);
                    nextVisited.add(child);
                    dfs(nextVisited, sheep, wolf + 1);
                }
            }
        }
    }

    static class Node {
        int index;
        boolean isSheep;
        ArrayList<Node> next = new ArrayList<>();

        public Node(int index, boolean isSheep) {
            this.index = index;
            this.isSheep = isSheep;
        }
    }
}
