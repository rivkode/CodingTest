import java.io.*;
import java.util.*;

public class Main {
    private static long ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
             st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i][0] = start;
            arr[i][1] = end;
        }

        /**
         * 2차원 배열의 2번째 자리 기준 즉, 끝나는 시간 기준으로 정렬한다
         * 끝나는 시간 기준 오름차순으로 정렬 후 이전 타임의 끝시간과 다음 타임의 시작지점이 겹치는 부분만 빼게 되면
         * 최대한 많은 개수의 회의를 진행할 수 있다
         *
         * 핵심 : 왜냐하면 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아지기 때문이다
         *
         * 동일한 시간일 경우 끝나는 시간이 느리다면 그만큼 회의를 못하기 때문 !
         */
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        
        

        int prev_end = 0;

        for (int i = 0; i < n; i++) {
            if (prev_end <= arr[i][0]) { // 이전 타임 끝나는 시간과 다음 타임 시작시간 비교
                prev_end = arr[i][1]; // 핵심 :  만약 다음 타임 시작 시간이 크거나 같다면 해당 타음 끝나는 시간으로 prev_end를 초기화 !
                ans++;
            }
        }
        System.out.println(ans);

    }
}
