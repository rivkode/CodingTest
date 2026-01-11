class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[computers.length];
        int answer = 0;
        
        for (int i=0; i<computers.length; i++) {
            if (!visited[i]) {
                dfs(computers, i, visited);
                answer += 1;
            }
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int i, boolean[] visited) {
        visited[i] = true;
        
        for (int j=0; j<computers.length; j++) {
            if (i == j) {
                continue;
            }
            
            if (visited[j] == true) {
                continue;
            }
            
            if (computers[i][j] == 1) {
                dfs(computers, j, visited);
            }
        }
    }
}