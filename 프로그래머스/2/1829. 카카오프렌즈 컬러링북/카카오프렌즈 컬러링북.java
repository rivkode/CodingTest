import java.util.*;

class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int numberOfArea;
    static int maxSizeOfOneArea;
    static int temp_cnt = 0;
    
    public int[] solution(int m, int n, int[][] picture) {
        // 1. 변수 초기화하기
        numberOfArea = 0;
        maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        // 2. DFS시 방문여부 체크
        boolean[][] visited = new boolean[m][n];
        
        // 3. 주어진 picture 배열 탐색
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                // 4. 해당 위치의 picture 이 0이 아니고 방문한적이 없다면
                // area 1 증가, dfs로 다음 상하좌우 탐색
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea+=1;
                    dfs(i, j, picture, visited);
                }
                // 한 영역이 탐색 끝났을때 조건에 따라 최대 영역의 수 증가
                if (temp_cnt > maxSizeOfOneArea)
                    maxSizeOfOneArea = temp_cnt;
                temp_cnt = 0;
            }
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public void dfs(int x, int y, int[][] picture, boolean[][] visited) {
        if (visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        temp_cnt += 1;
        
        for (int i=0; i<4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            // 좌표가 음수이거나 picture의 범위를 벗어나면 건너뜀
            if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length)
                continue;
            
            // 현좌표의 색 == 상하좌우 좌표색 && 방문한 적 없는 상하좌우 좌표라면
            // 여기서 현 좌표색과 그 다음 진행할 좌표 색을 체크하네..
            if (picture[x][y] == picture[nx][ny] && !visited[nx][ny]) {
                dfs(nx, ny, picture, visited);
            }
        }
    }
}