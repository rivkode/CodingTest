class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[computers.length];
        int answer = 0;
        
        for (int i=0; i<computers.length; i++) {
            if (!visited[i]) {
                dfs(computers, i);
                answer += 1;
            }
            print(answer);
        }
        
        return answer;
    }
    
    public void dfs(int[][] computers, int j) {
        visited[j] = true;
        
        for (int i=0; i<computers.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            if ((j - 1) >= computers.length) {
                continue;
            }
            
            
            if (computers[j][i] == 1) {
                dfs(computers, i);
            }
        }
        
        
    }
    public void print(String i) {
        System.out.println(i);
    }
    public void print(int i) {
        System.out.println(i);
    }
}