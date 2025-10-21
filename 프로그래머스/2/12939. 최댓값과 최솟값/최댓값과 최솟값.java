/**
String을 split() 을 통해 공백을 통해 배열로 분리한다.
- 이렇게되면 굳이 음수에 대한 처리를 해주지 않아도 parseInt() 가 알아서 처리한다.
배열에 위 숫자를 넣는다
Collections.min(), max() 를 통해 최소값, 최대값을 구한다.
return시 int는 " " 와 + 로 사용할 수 있다.
시간복잡도 O(n)
공간복잡도 O(n)

**/

import java.util.*;

class Solution {
    public String solution(String s) {
        String[] numStrs = s.split(" ");
        
        List<Integer> numbers = new ArrayList<>();
        
        for (String numStr: numStrs) {
            numbers.add(Integer.parseInt(numStr));
        }
        
        int minVal = Collections.min(numbers);
        int maxVal = Collections.max(numbers);
        
        return minVal + " " + maxVal;
    }
}