import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        arr = new char[numbers.length()];
        visited = new boolean[numbers.length()];
        
        for (int i=0; i<numbers.length(); i++) {
            arr[i] = numbers.charAt(i);
        }
        
        recursion("", 0);
        
        answer = set.size();
    
        
        return answer;
        
    }
    
    // dfs 재귀로 구현, 숫자조합을 겹치지 않게 찾고 소수일 경우 set에 추가
    public void recursion(String str, int idx) {
        int num;
        // System.out.println("재귀 str:"+str+", idx: "+idx);
        
        if (str != "") {
            num = Integer.parseInt(str);
            if (isPrime(num)) {
                set.add(num);
            }
        }
        
        if (idx == arr.length) {
            return;
        }
        
        for (int i=0; i<arr.length; i++) {
            
            // 방문한 노드일 경우 넘어감
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            recursion(str+arr[i] , idx + 1);
            // 백트래킹
            visited[i] = false;
        }
    }
    
    // 소수 판별
    public boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        
        // 제곱근까지만 탐색
        for (int i=2; i*i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}