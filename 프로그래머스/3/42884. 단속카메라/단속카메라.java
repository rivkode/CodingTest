/*
정렬이 핵심이다. 차량 끝 지점을 기준으로 routes 2차원 배열을 정렬해야한다.

2차원 배열의 두번째 요소 기준 오름차순 점점 커지길 원하면
Arrays.sort(targetArr, (o1, o2) -> {return (o1[1] - o2[1]);});

1차원은 ?
Arrays.sort(targetArr, (o1, o2) -> {return o1 - o2;});

ArrayList 정렬은 ?
List<String> strList = new ArrayList<>(); 일 경우 스트링 길이 기준 오름차순하고싶으면 ?
Collections.sort(strList, (o1, o2) -> o1.length() - o2.length());

List는 Collections 이기때문에 이걸 사용한다고 생각하자.
*/

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2) -> {
            return (o1[1] - o2[1]);
        });
        
        int end = routes[0][1];
        int cnt = 1;
        for (int i=1; i<routes.length; i++) {
            int start = routes[i][0];
            
            if (start > end) {
                cnt += 1;
                end = routes[i][1];
            } else {
                continue;
            }
        }
        
        return cnt;
    }
}