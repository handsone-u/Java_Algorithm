package sort;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek10814 {
    static int n;
    static PriorityQueue<Person> pq = new PriorityQueue<>(Comparator.comparing(Person::getAge).thenComparing(Person::getIndex));

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] s = reader.readLine().split(" ");
            int age = Integer.parseInt(s[0]);
            String name = s[1];
            pq.add(new Person(i, age, name));
        }
        reader.close();

        while (!pq.isEmpty()) {
            Person poll = pq.poll();
            writer.write(Integer.toString(poll.getAge()));
            writer.write(" ");
            writer.write(poll.getName());
            writer.write("\n");
        }

        writer.flush();
        writer.close();
    }

    static class Person{
        int index;
        int age;
        String name;

        public int getIndex() {
            return index;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public Person(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }
    }
}
