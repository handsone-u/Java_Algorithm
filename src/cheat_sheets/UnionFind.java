package cheat_sheets;

public class UnionFind {
    int[] parent;

    int findParent(int x) {
        if(x==parent[x]) return x;
        else return parent[x] = findParent(parent[x]);
    }

    void union(int x, int y) {
        int px = findParent(x);
        int py = findParent(y);
        if(px==py) return;

        if (px < py) {
            parent[y] = px;
        } else {
            parent[x] = py;
        }
    }
}
