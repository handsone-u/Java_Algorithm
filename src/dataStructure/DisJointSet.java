package dataStructure;

import java.io.*;
import java.util.HashMap;

/**
 * Disjoint Set
 * Union-Find
 * 루트를 가리키는 수 저장
 * https://www.acmicpc.net/problem/4195
 */
public class DisJointSet {
    // i 번째의 root
    static int[] parent = new int[200001];
    // 루트를 가리키는 수 저장
    static int[] num = new int[200001];
    static int f;
    static HashMap<String, Integer> nameToInt = new HashMap<>();

    private static void initParent(int f) {
        nameToInt.clear();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            f = Integer.parseInt(reader.readLine());
            initParent(100000);

            int k = 0;
            for (int i = 0; i < f; i++) {
                String[] name = reader.readLine().split(" ");
                Integer nameInt1, nameInt2;
                if(nameToInt.containsKey(name[0]))
                    nameInt1 = nameToInt.get(name[0]);
                else {
                    nameInt1 = ++k;
                    parent[nameInt1] = nameInt1;
                    num[nameInt1] = 1;
                    nameToInt.put(name[0], nameInt1);
                }
                if(nameToInt.containsKey(name[1]))
                    nameInt2 = nameToInt.get(name[1]);
                else {
                    nameInt2 = ++k;
                    parent[nameInt2] = nameInt2;
                    num[nameInt2] = 1;
                    nameToInt.put(name[1], nameInt2);
                }

                union(nameInt1, nameInt2);
                int count = 0;
                int p1 = findParent(nameInt1);
                int p2 = findParent(nameInt2);
                if(p1<p2)
                    count = num[p1];
                else
                    count = num[p2];

                writer.write(Integer.toString(count) + "\n");
            }
        }
        reader.close();
        writer.flush();
        writer.close();
    }

    public static int findParent(int x) {
        if(x==parent[x]) return x;
        int topParent = findParent(parent[x]);

        return parent[x] = topParent;
    }

    public static void union(int x, int y) {
        int xParent = findParent(x);
        int yParent = findParent(y);
        if(xParent==yParent)
            return;

        if(xParent<yParent) {
            num[xParent] += num[yParent];
            parent[yParent] = xParent;
        }
        else {
            num[yParent] += num[xParent];
            parent[xParent] = yParent;
        }
    }
}
