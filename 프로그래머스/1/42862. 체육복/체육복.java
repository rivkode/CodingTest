import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        
        
        for (int i=0; i<reserve.length; i++) {
            int target = reserve[i];
            for (int j=0; j<lost.length; j++) {
                if (target == lost[j]) {
                    lost[j] = 0;
                    reserve[i] = 0;
                }
            }
        }
        
        for (int i=0; i<reserve.length; i++) {
            if (reserve[i] == 0) {
                continue;
            }
            
            int target = reserve[i];
            int lTarget = target - 1;
            int rTarget = target + 1;
            boolean b = true;
            
            
            for (int j=0; j<lost.length; j++) {
                if (lost[j] == lTarget) {
                    lost[j] = 0;
                    b = false;
                    break;
                }
            }
            
            // 앞에 번호 친구를 먼저 확인 후 탐색
            if (b) {
                for (int j=0; j<lost.length; j++) {
                    if (lost[j] == rTarget) {
                        lost[j] = 0;
                        break;
                    }
                }
            }
        }
        
        int count =0;
        for (int i=0; i<lost.length; i++) {
            if (lost[i] != 0) {
                count++;
            }
        }

        n = n - count;

        return n;
    }
    
    public static void print(String v) {
        System.out.println(v);
    }
    
    public static void print(int v) {
        System.out.println(v);
    }
}