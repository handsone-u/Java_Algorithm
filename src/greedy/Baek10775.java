package greedy;

import java.io.*;

public class Baek10775 {
    static int G,P,ans;
    static int[] parent;

    private static int getIndex(int from) {
        if(from==0)
            return 0;
        if (parent[from] == from) {
            parent[from]--;
            return from;
        }

        return parent[from] = getIndex(parent[from]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        G = Integer.parseInt(reader.readLine());
        P = Integer.parseInt(reader.readLine());
        parent = new int[G + 1];
        ans = 0;

        for (int i = 0; i < G; i++) {
            parent[i + 1] = i + 1;
        }
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(reader.readLine());
            int index = getIndex(g);

            if (index == 0) break;
            ans++;
        }

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }
}
