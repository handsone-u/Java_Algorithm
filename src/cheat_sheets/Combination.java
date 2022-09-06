package cheat_sheets;

/**
 * 결과를 index 의 배열(길이 = r)로 돌려줌.
 */
public class Combination {
    static int[] result;
    static int n,r;

    public static void main(String[] args) {
        n = 5;
        r = 3;
        result = new int[r];

        combination(0, 0);
    }

    private static void combination(int from, int cnt) {
        if (cnt == r) {
            // do something Start
            for (int i : result) System.out.printf("%d ", i);
            System.out.println();
            // do something End

            return;
        }
        for (int i = from; i < n; i++) {
            result[cnt] = i;
            combination(i + 1, cnt + 1);
        }
    }
}
