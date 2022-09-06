package sort;

import java.util.*;

/**
 * Sort
 * Comparator
 */
public class Sol17676 {
    public String[] solution(String[] files) {
        int len = files.length;
        ArrayList<File> list = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            list.add(File.parseFile(files[i], i));
        }

        return list.stream().sorted(Comparator.comparing(File::getHead)
                        .thenComparing(File::getNum)
                        .thenComparing(File::getIndex))
                .map(File::getOriginal)
                .toArray(String[]::new);
    }

    static class File{
        String head;
        int num;
        int index;
        String original;

        public File(String head, int num, int index, String original) {
            this.head = head.toLowerCase();
            this.num = num;
            this.index = index;
            this.original = original;
        }

        public static File parseFile(String str, int index) {
            char[] arr = str.toCharArray();
            int start = 0, end = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= '0' && arr[i] <= '9') {
                    start = i;
                    end = i + 1;
                    while (end < arr.length) {
                        if(arr[end]>='0'&&arr[end]<='9') end++;
                        else break;
                    }
                    break;
                }
            }
            String head = str.substring(0, start);
            String num = str.substring(start, end);

            return new File(head, Integer.parseInt(num), index, str);
        }

        public String getHead() {
            return head;
        }

        public int getNum() {
            return num;
        }

        public int getIndex() {
            return index;
        }

        public String getOriginal() {
            return original;
        }
    }
}
