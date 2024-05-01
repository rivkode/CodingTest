import java.util.*;

class Solution {
    
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    static int n, m;
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        // 방문 노드 표시
        int[][] visited = new int[maps.length][maps[0].length];
        
        // bfs 시작
        bfs(maps, visited);
        
        // visited에 값 반환
        answer = visited[maps.length-1][maps[0].length-1];
        
        if(answer == 0){
            answer = -1;
        }
        
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited){
        int x = 0;
        int y = 0;
        
        // 방문 표시
        visited[x][y] = 1;
        
        // 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        
        // 0,0 에서 큐 시작
        queue.add(new int[]{x, y});
        
        // 큐가 빌때까지 반복
        while(!queue.isEmpty()){
            
            // 현재 큐 제거
            int[] current = queue.remove();
            
            // 큐 위치
            int cX = current[0];
            int cY = current[1];
            
            // 현재 큐 위치로부터 동, 서, 남, 북 방향으로 진행
            for(int i = 0; i < 4; i++){
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                
                // 이때 위치 체크
                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)
                    continue;
                
                // 만약 방문하지 않았고, 갈 수 있는 곳이라면 방문
                if(visited[nX][nY] == 0 && maps[nX][nY] == 1){
                    // 해당 위치까지의 거리를 바로 visited에 기록
                    visited[nX][nY] = visited[cX][cY] + 1;
                    // queue에 새로운 int 배열을 생성
                    // System.out.println("nX : " + nX + " nY : " + nY);
                    queue.add(new int[]{nX, nY});
                }
            }
            
        }

// class Solution {
//     static int n;
//     static int m;
//     static int count;
//     static List<Integer> list = new ArrayList<>();
//     static boolean[][] visited;
//     public int solution(int[][] maps) {
//         int answer = 0;
        
//         n = maps[0].length;
//         m = maps.length;
        
//         // System.out.println("n : " + n + " m : " + m);
        
//         visited = new boolean[n][m];
        
//         // BFS로 큐로 변경
//         Queue<int[]> queue = new LinkedList<>();
        
//         // 동서남북 방향
//         int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
//         // 큐 시작지점
//         queue.offer(new int[]{0,0,1});
//         visited[0][0] = true;
        
//         // 큐가 빌때까지 반복, 한 번 시작한 뒤로 나아가는 방향대로 계속 추가하므로
//         // 비었다는 의미는 가장 깊은 depth로 탐색을 완료하였다는 의미
//         while(!queue.isEmpty()) {
//             // queue에 있는 위치를 가져온다. 이때 배열을 가져온다. 배열은 point 좌표임
//             int[] current = queue.peek();
//             int x = current[0];
//             int y = current[1];
//             int distance = current[2];
            
//             // 만약 도달하였다면 distance 반환
//             // 이때 큐로 진행하였기 때문에 최소 거리를 보장함
//             if (x == n-1 && y == m - 1) {
//                 return distance;
//             }
            
//             for (int[] direction : directions) {
//                 // 동서남북 방향으로 진행한다
//                 int nx = x + direction[0];
//                 int ny = y + direction[1];
                
//                 // 각 방향으로 진행시 진행할 시점을 명시한다 만약 조건에 부합하지 않으면 진행하지 않는다
//                 // nx, ny가 0보다 클 경우에만 진행
//                 // nx 가 n 보다 작을 경우, ny가 m보다 작을경우에만 진행
//                 // nx가 n 보다 크다는 것은 사각형 범위를 벗어나므로 안됨
//                 // point 위치에서 1일 경우에만 진행, 0이면 벽이므로
//                 // 방문한 내용에 대해서는 진행하지 않음 false일 경우에만 진행
//                 if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
//                     visited[nx][ny] = true;
                    
//                     // 큐를 추가할때 거리를 1 증가시킴
//                     queue.offer(new int[]{nx, ny, distance + 1});
//                 }
//             }
            
//         }
        
//         //모든 큐를 돌았음에도 불구하고 반환하지 못했다면 목적지까지 도달할 수 없으므로
//         // -1 반환
//         return -1;
        
        // recursion(0, 0, maps, 0);
        // // list.add(0);
        // if (list.size() == 0) {
        //     return -1;
        // } else {
        //     int min = Collections.min(list);
        //     answer = min;
        //     return answer;
        // }
    }
    
//     public void recursion(int i, int j, int[][] maps, int cnt) {
//         // System.out.println("cnt : " + cnt + " i : " + i + " j : " + j);
        
//         // i, j가 음수일 경우 종료
//         if (i < 0 || j < 0) {
//             return;
//         }
        
//         // i와 j가 사각형 범위를 벗어나면 종료
//         if (i >= n || j >= m) {
//             return;
//         }
        
//         // 방문한 노드는 다시 탐색하지 않음
//         if (visited[i][j]) {
//             return;
//         }
        
//         // 벽 만났을때 종료시점
//         if (maps[i][j] == 0) {
//             return;
//         }
        
//         // 적 찾는 종료시점
//         if (i == (n - 1) && j == (m - 1)) {
//             // System.out.println("final" + cnt);
//             list.add(cnt + 1);
//             return;
//         }
        
//         visited[i][j] = true;
        
//         // 다음 탐색 시작
//         recursion(i, j + 1, maps, cnt + 1);
//         recursion(i, j - 1, maps, cnt + 1);
//         recursion(i - 1, j, maps, cnt + 1);
//         recursion(i + 1, j, maps, cnt + 1);
//     }
}