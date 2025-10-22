/*
제이지 - 도시 맛집 게시물 데이터 조회
어피치 - 성능수행
제이지 캐시 사용

LRU - 제거기준: 리스트의 가장 앞부분 = 가장 오래된 것 / 새로 들어온 내용은 항상 마지막에 추가되므로
이때 cache hit 되면 가장 앞으로 이동
*/

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        List<String> cache = new ArrayList<>();
        
        for (int i=0; i<cities.length; i++) {
            String s = cities[i].toLowerCase();
            
            
            if (cache.contains(s)) {
                answer += 1;
                int index = cache.indexOf(s);
                cache.remove(index);
                cache.add(s);
            } else {
                answer += 5;
                cache.add(s);
                if (cache.size() > cacheSize) {
                    cache.remove(0);
                }
            }
        }
        
        return answer;
    }
}