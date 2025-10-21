
/**
입력 
n = 진법
t = 출력 개수
m = 참가 인원
p = 튜브 순서

규칙
- 숫자는 1씩 순차적으로 커짐
- 진법에 따라 달라야 함
- 출력 인덱스를 구하기 위해 참가 인원과 튜브의 순서를 고려해야함

숫자를 구해놓고 인덱스로 가져오자

총 숫자의 개수는 t * m 이며 이때 p, p + m, p + 2m, p + 3m ... 순으로 인덱스가 이어짐

진법을 어떻게 계산하지 ?


참고 - Integer.toString(i, n).toUpperCase();
**/

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int max = t * m;
        
        for (int i=0; i<max; i++) {
            sb.append(Integer.toString(i, n).toUpperCase());
        }
        
        StringBuilder result = new StringBuilder();
        
        for (int i=p-1; i<max; i += m) {
            result.append(sb.charAt(i));
        }
        
        return result.toString();
    }
}