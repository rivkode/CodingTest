import java.util.*;
import java.io.*;


class Solution {
    public int solution(int []A, int [] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        reverseArray(B);
        
        int result = 0;
        
        for (int i=0; i<A.length; i++) {
            int a = A[i];
            int b = B[i];
            result += a * b;
        }
        
        return result;
    }
    
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        int tmp = 0;
        while (left < right) {
            tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            
            left += 1;
            right -= 1;
        }
        
    }
    
    public static void print(String v) {
        System.out.println(v);
    } 
}