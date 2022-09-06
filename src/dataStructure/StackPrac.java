package dataStructure;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * - Stack.
 * 2*N 번으로 해결하는 오큰 수 구하기
 * stack 에 수를 넣을 때 스택 안에 자기보다 작은 수들의 오큰수가 현재 수.
 * stack 안에있는 수는 아래로 내려갈 수록 큰 수 임이 보장된다.
 * 따라서 top 이 가장 작은 수 이고 이 수보다 작은 수 라면 그 아래 어떤 수 라도 현재 수가 오큰 수 될 수 없다.
 */
public class StackPrac {
    static int n;
    static int[] arr;
    static int[] ans;

    static void solution() {
        Stack<Num> stack = new Stack<>();
        stack.add(new Num(0, arr[0]));

        for (int i = 1; i < n; i++) {
            Num now = new Num(i, arr[i]); // 현재 수
            Num peek = stack.peek(); // 스택 탑

           // 경우(1). 현재 수: 오큰 수
            if (now.num > peek.num) {
                // 스택에서 작은 수를 찾아 오큰 수를 적어줌. 오큰 수 아닌경우 빠져나옴
                while (!stack.isEmpty()&&now.num> stack.peek().num) {
                    Num pop = stack.pop();
                    ans[pop.index] = now.num;
                }
            }
            // 경우(2). 생략
            stack.add(now);
        }

        // 경우(3). 오큰 수 없는 경우
        while (!stack.isEmpty()) {
            Num pop = stack.pop();
            ans[pop.index] = -1;
        }
    }

    static class Num{
        public int index;
        public int num;

        public Num(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        input(reader);
        solution();
        output(writer);
    }

    private static void output(BufferedWriter writer) throws IOException {
        writer.write(Arrays.stream(ans)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
        writer.flush();
        writer.close();
    }

    private static void input(BufferedReader reader) throws IOException {
        n = Integer.parseInt(reader.readLine());
        arr = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        ans = new int[n];
    }
}
