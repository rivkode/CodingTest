import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] result = new int[len];
        
        for (int i=0; i<len - 1; i++) {
            int cnt = 1;
            for (int j=i+1; j<len - 1; j++) {
                if (prices[i] > prices[j]) {
                    break;
                } else {
                    cnt += 1;
                }
            }
            result[i] = cnt;
        }
        
        result[len - 1] = 0;
        
        return result;
    }
}