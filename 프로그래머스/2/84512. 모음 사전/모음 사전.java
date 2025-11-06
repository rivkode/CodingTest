/*

1. 문제 이해

이 문제는 단어를 만들고 만든 사전에서 해당하는 인덱스를 뽑는 문제다.
사전을 어떻게 만들것인지가 포인트이다.
조건을 보면 depth가 5로 정해져있고 순차적으로 탐색한다는 것을 알 수 있다.

2. 예외 케이스 탐색

예외 케이스는 딱히 보이지 않는다. 문자 인덱스 크기 정도가 될 수 있는데
총 5글자이므로
각 자릿수별로 경우의 수를 5씩 곱하면
5, 25, 125, 625, 3125, ... 이므로 1억을 넘지 않으므로 괜찮다고 판단

3. 알고리즘 선택

순차적으로 1 depth 씩 들어가면서 상태를 저장하는 것이므로 dfs를 선택


4. 문제 풀이

변수 정의
단어 리스트, 단어 글자

각 상태들을 모두 저장하고 나중에 해당 사전에서 단어의 위치를 찾도록 구현

*/

import java.util.*;

class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static List<String> dict = new ArrayList<>();
    
    public int solution(String word) {
        dfs("", 0);
        int answer = 0;
        for (int i=0; i<dict.size(); i++) {
            String w = dict.get(i);
            if (w.equals(word)) {
                // 첫 단어가 "" 이므로 1을 빼지 않아도 됨
                answer = dict.indexOf(w);
                break;
            }
        }
        return answer;
    }
    
    public void dfs(String w, int depth) {
        dict.add(w);
        if (depth == 5) {
            return;
        }
        
        for (int i=0; i<5; i++) {
            dfs(w + words[i], depth + 1);
        }
    }
}
