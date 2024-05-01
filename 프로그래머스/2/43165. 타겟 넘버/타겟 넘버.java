import java.util.*;

class Solution {
    static int count;
    static int targetNum;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        targetNum = target;
        recursion(0, 0, numbers);
        
        
        answer = count;
        return answer;
    }
    
    public void recursion(int depth, int result, int[] numbers) {
        // System.out.println("depth : " + depth + " result : " +  result);
        
        // 종료 시점 정의
        if (depth == numbers.length) {
            if (result == targetNum) {
                count++;
            }
            return;
        }
        
        // 계산 시점
        int num = numbers[depth];        
        
        // plus 계산, 계산시 result에 num을 계산하여 바로 보내준다.
        // 이렇게 하는 이유는 depth 값을 비교할 경우 넘겨진 num을 연산한 결과 result 와 targetNum을 비교하기 위해서이다
        recursion(depth + 1, result + num, numbers);
        
        // minus 계산
        recursion(depth + 1, result - num, numbers);
        
    }
    
    
}