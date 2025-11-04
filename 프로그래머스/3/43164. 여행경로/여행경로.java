/*
dfs, 백트래킹을 사용
앞으로 아래와 같이 문제를 풀자.
1. 문제 이해
2. 예외 케이스 탐색
3. 알고리즘 선택
4. 문제 풀기

내가 놓친것은 dfs를 선택했을때 완전탐색을 할 생각을 못했던 것임. 예외케이스를 주요하게 생각하지 않아서 실수함.

이 문제에서는 가능한 경로가 2개 이상일 경우 알파벳순서로 선택해야한다는 조건이 있으므로 정렬을 하는 것이 포인트였음
모든 경우의 수를 고르고 정렬을 하게 되면 알파벳순으로 정렬되므로 원하는 답을 얻을 수 있음

백트래킹은 완전 탐색을 효율적으로 수행하는 기법임 이 문제에서는 지금까지의 경로를 route에 저장하여 순차적으로 저장하다가 해당 경로가 잘못된 경로라면 다시 뒤로 돌아가 이전에 저장해놓은 route로 돌아가서 다시 찾게 되는 것임
그래서 뒤로 돌아가이 위해 해당 방문 지점을 false로 설정

언제 상태를 되돌리는지에 대해 이해하고 정의해야함

visited[i] = false는 재탐색을 위한 상태 복구 과정이며, 백트래킹의 필수 요소이다.

이 문제에서 정렬이 필요한 이유는 DFS가 알파벳 순서대로 경로를 찾지 못할 수 있으므로, 모든 유효 경로를 찾은 후 문제 조건에 맞는 최적의 해답(알파벳 순서)을 걸러내기 위함이다.
*/


import java.util.*;

class Solution {
    static List<String> answer = new ArrayList<>();
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs(0, "ICN", "ICN", tickets);
        Collections.sort(answer);
        
        return answer.get(0).split(" ");
    }
    
    public void dfs(int idx, String start, String route, String[][] tickets) {
        if (idx == tickets.length) {
            answer.add(route);
            return;
        }
        
        for (int i=0; i<tickets.length; i++) {
            if (start.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(idx + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                visited[i] = false;
            }
        }
    }
}


/*
입력 데이터를 Map<String, List<String>> 으로 세팅한 뒤 각 지역 탐색시 dfs 사용
이때 key로 조회한 value List<String> 에 값이 있을 경우 값을 추가하고 Collections.sort()를 사용해 정렬
이후 dfs로 탐색시 가장 앞의 값을 탐색하게되면 조건 "2개 이상일 경우 알파베 순서가 앞서는" 을 만족할 수 있음.

dfs의 탐색종료 조건은 마지막 지역이므로 subList가 null일 경우임
Hashmap으로 사용해서 문제를 풀려고 했으나 예외케이스에 대해 실패함
이 문제는 dfs로 하는게 아니라 백트래킹을 사용했어야 했음
import java.util.*;

class Solution {
    static List<String> answer;
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String[] t : tickets) {
            List<String> subList = map.get(t[0]);
            if (subList == null) {
                List<String> list = new ArrayList<>();
                list.add(t[1]);
                map.put(t[0], list);
            } else {
                subList.add(t[1]);
                Collections.sort(subList);
                map.put(t[0], subList);
            }
        }
        
        dfs("ICN", map);
        answer.add(0, "ICN");
        String[] answerArray = answer.toArray(new String[0]);
        return answerArray;
    }
    
    public void dfs(String target, Map<String, List<String>> map) {
        List<String> subList = map.get(target);
        if (subList == null || subList.isEmpty()) {
            return;
        }
        String s = subList.remove(0);
        answer.add(s);
        dfs(s, map);
    }
}
*/
