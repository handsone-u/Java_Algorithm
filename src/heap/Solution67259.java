package heap;

import java.util.PriorityQueue;

public class Solution67259 {
    int[][][] values;
    int[] vx = {1, -1};
    int[] hy = {1, -1};

    public int solution(int[][] board) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int len = board.length;
        values = new int[len][len][2];
        values[len - 1][len - 1][0] = values[len - 1][len - 1][1] = Integer.MAX_VALUE;
        pq.add(new Node(0, 0, 0, true, true));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int x = current.x;
            int y = current.y;
            int value = current.value;

            if (current.isHorizontal) {
                if(values[x][y][0]!=0&&values[x][y][0]<value) continue;
                else values[x][y][0] = value;
            }
            if (current.isVertical) {
                if(values[x][y][1]!=0&&values[x][y][1]<value) continue;
                else values[x][y][1] = value;
            }

            int hValue=value, vValue=value;
            if (current.isHorizontal) hValue += 100;
            else hValue += 600;
            if (current.isVertical) vValue += 100;
            else vValue += 600;

            for (int i = 0; i < 2; i++) {
                int nx = x + vx[i];
                int ny = y;
                if(!isIn(nx,ny,len)) continue;
                if(board[nx][ny]==1) continue;
                Node next = new Node(nx, ny, vValue, false, true);
                pq.add(next);
            }
            for (int i = 0; i < 2; i++) {
                int nx = x;
                int ny = y + hy[i];
                if(!isIn(nx,ny,len)) continue;
                if(board[nx][ny]==1) continue;
                Node next = new Node(nx, ny, hValue, true, false);
                pq.add(next);
            }
        }

        return Integer.min(values[len - 1][len - 1][0], values[len - 1][len - 1][1]);
    }

    boolean isIn(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int value;
        boolean isHorizontal;
        boolean isVertical;

        public Node(int x, int y, int value, boolean isHorizontal, boolean isVertical) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.isHorizontal = isHorizontal;
            this.isVertical = isVertical;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}
