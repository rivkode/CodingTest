import java.util.*;

class Solution {
    public double solution(int[] arr) {
        double length = arr.length;
        double sum = Arrays.stream(arr).sum();
        
        double answer = 0;
        
        answer = sum / length;
        System.out.println(answer);
        return answer;
    }
}