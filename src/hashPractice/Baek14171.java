package hashPractice;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Baek14171 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int ans = 0;
        // city[2] -> city's State
        HashMap<String, ArrayList<String>> stateMap = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] line = reader.readLine().split(" ");
            String city = line[0].substring(0, 2);
            String stateCode = line[1];

            if (stateMap.containsKey(stateCode)) {
                ArrayList<String> citiesState = stateMap.get(stateCode);
                for (String s : citiesState) {
                    if (city.equals(s) && !stateCode.equals(s))
                        ans++;
                }
            }

            ArrayList<String> list = stateMap.getOrDefault(city, new ArrayList<>());
            list.add(stateCode);
            stateMap.put(city, list);
        }
        reader.close();

        writer.write(String.valueOf(ans));
        writer.flush();
        writer.close();
    }
}
