import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/*
우선순위 큐의 동작원리를 알면 쉽게 풀 수 있다.
가장 작은 값은 큐의 루트 값을 가져오면 되므로 queue.peek()을 통해서 구한다.

그리고 공식에서의 값을 구하고 게산하기 위해
peek() 을 2번한 뒤 다시 queue에 넣어주면 자료구조에 의해 계산된다.
*/

class Solution {
    public int solution(int[] scoville, int K) {  
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i=0; i<scoville.length; i++) {
            queue.add(scoville[i]);
        }
        
        while(queue.peek() < K) {
            if (queue.size() == 1) {
                return -1;
            }
            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }
        return answer;
    }
}