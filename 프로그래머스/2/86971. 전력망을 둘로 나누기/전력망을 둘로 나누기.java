import java.util.*;

class Solution {
    // 각 전선들의 연결된 정보를 담고 있는 그래프
    static ArrayList<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        // 그래프 초기화
        graph = new ArrayList[n + 1];
        
        // 그래프 초기화
        for (int i=1; i<=n; i++)
            graph[i] = new ArrayList<>();
        // 그래프 양쪽으로 이어주기
        for (int i=0; i<wires.length; i++) {
            int s = wires[i][0];
            int e = wires[i][1];
            graph[s].add(e);
            graph[e].add(s);
        }
        
        // wires들을 순회하며 각 그래프들을 하나씩 제거해가며 dfs 로 탐색
        for (int i=0; i<wires.length; i++) {
            // 각 v1과 v2는 wires 에서 서로 연결된 노드이므로 wires에서 i번째를 끊기 위한 노드들
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            
            // visited 초기화
            boolean[] visited = new boolean[n + 1];
            
            // graph에서 v1과 v2요소에 대해 양쪽으로 제거해줌으로써 노드들이 서로 연결고리가 끊어짐 즉 서로의 정보를 리스트 요소로 가지고 있었지만 이를 제거함으로써 연결되지 않음
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));
            
            // 노드가 끊어진 상태로 dfs 탐색으로 한 지점에서 최대 연결 가능한 개수를 구함
            // 그리고 n 을 빼주게 되면 반대쪽도 자동으로 구해짐
            // 이 둘의 차이를 diff로 구해주게 되고 이때 절댓값을 구함
            // 그리고 answer를 초기화
            int cnt = dfs(1, visited);
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);
            
            // 제거한 v1과 v2를 다음 루프를 위해 다시 넣어줌
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        return answer;
    }
    
    // 입력받은 v에서 탐색가능한 노드의 최대수를 반환
    public int dfs(int v, boolean[] visited) {
        // 방문 표시
        visited[v] = true;
        
        // 처음 방문으로 cnt 1 로 시작
        int cnt = 1;
        for (int next: graph[v]) {
            // 그래프를 돌며 방문이 아닌 경우 dfs로 재탐색
            if (visited[next]) continue;
            // dfs로 탐색할때 모든 graph를 탐색하였다면 cnt를 반환하게 되는데 이때 여기서 개수가 누적됨
            cnt += dfs(next, visited);
        }
        
        // cnt 반환
        return cnt;
    }
}