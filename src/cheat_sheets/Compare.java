package cheat_sheets;

import java.util.Arrays;
import java.util.Random;

public class Compare {
    public static void main(String[] args) {
        Point[] arr = new Point[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            arr[i] = new Point(random.nextInt(20), random.nextInt(20));
        }
        Arrays.sort(arr);

        for (int i = 0; i < 20; i++) {
            System.out.printf("(%d, %d)\n", arr[i].x, arr[i].y);
        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            // Y 내림차순, 같을 경우 x 오름차순
            if(this.y==o.y) return this.x - o.x;
            else return -(this.y - o.y);
        }
    }
}
