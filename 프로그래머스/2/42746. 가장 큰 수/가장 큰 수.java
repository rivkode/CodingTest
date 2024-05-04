import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] arr = new String[numbers.length];
        
        for (int i=0; i<numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // 앞뒤 순서를 번갈아 가면서 비교하여 더 큰 수를 기준으로 정렬을 진행함
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        if (arr[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i=0; i<numbers.length; i++) {
            sb.append(arr[i]);
        }
        
        return sb.toString();
        
        
    }
}