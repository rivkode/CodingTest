/* 
dfs, bfs 2가지 방법으로 풀어봄

dfs의 경우 recursive() 함수를 사용해서 특정 depth까지 도달할 경우 값을 비교하고 cnt를 증가시키고 return으로 종료를 진행

bfs의 경우 queue를 사용해서 isEmpty() 조건을 사용하고 특정 depth까지 도달할경우 값을 비교하며 cnt를 증가시키고 continue로 종료를 진행


*/


import java.util.*;

class Solution {
    // static int count;
    // static int targetNum;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        
        // 초기상태
        queue.offer(new int[]{0,0});
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            
            int curSum = current[0];
            int curIdx = current[1];
            
            if (curIdx == numbers.length) {
                if (curSum == target) {
                    answer += 1;
                }
                // 여기서 continue가 들어간 이유는
                // bfs 목적이 특정 length에 도달했을때 값을 비교하는 것이므로
                // lengh에 도달했을 경우 target 조건과 맞지 않다면
                // 다음 queue로 넘어가야 하기 때문에
                // 만약 continue가 없으면 또 다시 추가 lengh를 향해서
                // 값이 추가된다.
                // 그러면 끝나지 않는 무한루프 발생
                continue;
            }
            
            
            
            queue.offer(new int[]{curSum + numbers[curIdx], curIdx + 1});
            queue.offer(new int[]{curSum - numbers[curIdx], curIdx + 1});
        }
        
        // recursion(0, 0, numbers);
        // answer = count;
        
        return answer;
    }
    
//     public void recursion(int depth, int result, int[] numbers) {
//         // System.out.println("depth : " + depth + " result : " +  result);
        
//         // 종료 시점 정의
//         if (depth == numbers.length) {
//             if (result == targetNum) {
//                 count++;
//             }
//             return;
//         }
        
//         // 계산 시점
//         int num = numbers[depth];        
        
//         // plus 계산, 계산시 result에 num을 계산하여 바로 보내준다.
//         // 이렇게 하는 이유는 depth 값을 비교할 경우 넘겨진 num을 연산한 결과 result 와 targetNum을 비교하기 위해서이다
//         recursion(depth + 1, result + num, numbers);
        
//         // minus 계산
//         recursion(depth + 1, result - num, numbers);
        
//     }
}