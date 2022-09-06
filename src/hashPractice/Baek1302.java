package hashPractice;

import java.io.*;
import java.util.*;

/**
 * HashMap
 * Steam Sort
 * Comparator
 */
public class Baek1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = reader.readLine();
            Integer val = map.getOrDefault(word, 0);
            map.put(word, val + 1);
        }
        reader.close();

        Book[] books = map.entrySet().stream()
                .map(e -> new Book(e.getKey(), e.getValue()))
                .sorted(Comparator.comparing(Book::getCount, Comparator.reverseOrder())
                        .thenComparing(Book::getName))
                .toArray(Book[]::new);

        writer.write(books[0].getName());
        writer.flush();
        writer.close();
    }

    static class Book{
        String name;
        int count;

        public String getName() {
            return name;
        }

        public int getCount() {
            return count;
        }

        public Book(String name, int count) {
            this.name = name;
            this.count = count;
        }
    }
}
