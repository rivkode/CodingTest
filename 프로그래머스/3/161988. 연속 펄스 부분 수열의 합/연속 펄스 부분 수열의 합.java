/*
dp를 사용해서 문제를 풀어본다
펄스조건이 추가되었으므로 2개의 수열을 만든 상태에서 더 큰값을 고른다

필요한 변수
dpA[] dpB[]
answer
sequence[]

메모이제이션을 활용한다
점화식 => Math.max(dp[i-1] + dp[i], dp[i]);
*/

import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        int len = sequence.length;
        
        long[] dpA = new long[len];
        long[] dpB = new long[len];
        int p = 1;
        int m = -1;
        
        for (int i=0; i<len; i++) {
            int seq = sequence[i];
            
            long longA = Long.valueOf(seq * p);
            long longB = Long.valueOf(seq * m);
            dpA[i] = longA;
            dpB[i] = longB;
            
            p *= -1;
            m *= -1;
        }
        
        
        
        for (int i=0; i<len; i++) {
            if (i == 0) {
                long a = dpA[i];
                dpA[i] = a;
                long b = dpB[i];
                dpB[i] = b;

                long seqMax = Math.max(a, b);
                answer = Math.max(answer, seqMax);
            } else {
                long a = Math.max(dpA[i - 1] + dpA[i], dpA[i]);
                dpA[i] = a;
                long b = Math.max(dpB[i - 1] + dpB[i], dpB[i]);
                dpB[i] = b;

                long seqMax = Math.max(a, b);
                answer = Math.max(answer, seqMax);
            }
        }
        
        return answer;
    }
}