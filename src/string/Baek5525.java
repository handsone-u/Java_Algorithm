package string;

import java.io.*;

public class Baek5525 {
    static int n,m,ans;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        arr = reader.readLine().toCharArray();
        reader.close();

        int i = 0;
        int pCount = 0;

        while (i<m-2){
            if (arr[i] == 'I' && arr[i+1] == 'O' && arr[i+2] == 'I') {
                pCount++;
                if(pCount==n) {
                    pCount--;
                    ans++;
                }
                i+=2;
            } else {
                pCount = 0;
                i++;
            }
        }

        writer.write(Integer.toString(ans));
        writer.flush();
        writer.close();
    }
}
