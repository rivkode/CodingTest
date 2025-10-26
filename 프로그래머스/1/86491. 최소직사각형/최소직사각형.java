import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxVertical = 0;
        int maxHeight = 0;
        
        for (int i=0; i<sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            maxVertical = Math.max(maxVertical, max);
            maxHeight = Math.max(maxHeight, min);
        }
        
        int answer = maxVertical * maxHeight;
        return answer;
    }
    
}


// class Solution {
//     public int solution(int[][] sizes) {
//         int n = sizes.length;
//         List<Wallet> wList = new ArrayList<Wallet>();
        
//         for(int[] ls : sizes) {
//             int x = ls[0];
//             int y = ls[1];
            
//             // x가 항상 더 길게
//             if (y > x) {
//                 int tmp = x;
//                 x = y;
//                 y = tmp;
//             }
            
//             Wallet wallet = new Wallet(x, y);
//             wList.add(wallet);
//         }
        
//         List<Integer> xList = new ArrayList<>();
//         List<Integer> yList = new ArrayList<>();
        
//         for (Wallet w : wList) {
//             int x = w.getW();
//             xList.add(x);
//             print(x);
//         }
        
//         for (Wallet w : wList) {
//             int y = w.getH();
//             yList.add(y);
//             print(y);
//         }
        
//         Integer xMax = Collections.max(xList);
//         Integer yMax = Collections.max(yList);
        
            
//         int answer = 0;
        
//         answer = xMax * yMax;
//         return answer;
//     }
    
//     public class Wallet {
//         private int w;
//         private int h;
        
//         public Wallet(int w, int h) {
//             this.w = w;
//             this.h = h;
//         }
        
//         public int getW() {
//             return this.w;
//         }
        
//         public int getH() {
//             return this.h;
//         }
        
//     }
    
//     public static void print(int v) {
//         System.out.println(v);
//     }
// }