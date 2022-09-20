package kakao2022_intern;

import java.util.*;

public class Solution5 {
    Deque<Deque<Integer>> home = new LinkedList<>();
    Deque<Integer> left = new LinkedList<>();
    Deque<Integer> right = new LinkedList<>();
    int r, c;

    String ROTATE = "Rotate";
    String SHIFT = "ShiftRow";

    public int[][] solution(int[][] rc, String[] operations) {
        init(rc);
        solve(operations);

        return getAnswer();
    }

    void shift(int count) {
        count = count % r;
        for (int i = 0; i < count; i++) {
            home.addFirst(home.removeLast());
            left.addFirst(left.removeLast());
            right.addFirst(right.removeLast());
        }
    }

    void rotate(int count) {
        count = count % (c * 2 + (r - 2) * 2);
        for (int i = 0; i < count; i++) {
            Deque<Integer> rowTop = home.getFirst();
            Deque<Integer> rowBot = home.getLast();

            rowTop.addFirst(left.removeFirst());
            right.addFirst(rowTop.removeLast());
            rowBot.addLast(right.removeLast());
            left.addLast(rowBot.removeFirst());
        }
    }

    void solve(String[] ops) {
        int rotateCount = 0;
        int shiftCount = 0;
        for (String op : ops) {
            if (op.equals(ROTATE)){
                if (shiftCount > 0) {
                    shift(shiftCount);
                    shiftCount = 0;
                }
                rotateCount++;
            } else {
                if (rotateCount > 0) {
                    rotate(rotateCount);
                    rotateCount = 0;
                }
                shiftCount++;
            }
        }
        shift(shiftCount);
        rotate(rotateCount);
    }

    void init(int[][] rc) {
        r = rc.length;
        c = rc[0].length;
        for (int i = 0; i < r; i++) {
            left.add(rc[i][0]);
            right.add(rc[i][c - 1]);

            LinkedList<Integer> row = new LinkedList<>();
            for (int j = 1; j < c - 1; j++) row.add(rc[i][j]);
            home.add(row);
        }
    }

    int[][] getAnswer() {
        int[][] answer = new int[r][c];
        for (int i = 0; i < r; i++) {
            Deque<Integer> row = home.removeFirst();
            row.addFirst(left.removeFirst());
            row.addLast(right.removeFirst());

            answer[i] = row.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
        return answer;
    }
}
