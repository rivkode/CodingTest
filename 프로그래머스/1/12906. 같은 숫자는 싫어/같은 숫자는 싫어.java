import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        
        list.add(arr[0]);
        
        for (int i : arr) {
            if (list.get(list.size() - 1) == i) {
                continue;
            }
            list.add(i);
        }
        
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}