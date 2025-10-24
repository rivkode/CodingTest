/*

대부분 로직은 작성을 했고 접근 방식도 좋았다.
하지만 핵심적으로 값 계산을 할때 헤맨다.

사람 위치를 구할때 i와 n을 사용해야한다는건 이해했지만 구체적으로 쓰지를 못했다.
그리고 현재 단어를 기준으로 해야하는데 이상하게 생각해서 다음 단어를 기준으로 로직을 시도했다.

값을 구할때 정확하게 내가 생각한대로 할 필요가 있다.

*/

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Map<String, Integer> wordMap = new HashMap<>();
        
        wordMap.put(words[0], 1);
        
        for (int i=1; i<words.length; i++) {
            String curWord = words[i-1];
            String nextWord = words[i];
            
            
            boolean isExist = wordMap.containsKey(nextWord);
            
            int curLen = curWord.length();
            char curC = curWord.charAt(curLen - 1);
            char nextC = nextWord.charAt(0);
            
            if ((curC != nextC) || isExist) {
                int share = (i % n) + 1;
                int spare = (i / n) + 1;
                answer[0] = share;
                answer[1] = spare;
                break;
            }
            
            wordMap.put(words[i], 1);
        }
        

        return answer;
    }
}