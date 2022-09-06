package dataStructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU Node 검색 O(1)
 * 순서를 보장하는 HashMap
 * removeEldestEntry() true 일 경우 LRU 를 제거함
 */
public class LRULinkedHashMap {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LRU lru = new LRU(cacheSize);

        for (String city : cities) {
            city = city.toLowerCase();
            if(lru.containsKey(city)) answer++;
            else answer += 5;

            lru.remove(city);
            lru.put(city, 0);
        }

        return answer;
    }

    static class LRU extends LinkedHashMap<String, Integer> {
        private final int size;

        public LRU(int size) {
            super(size, 0.75F, true);
            this.size = size;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
            return this.size() > size;
        }
    }
}
