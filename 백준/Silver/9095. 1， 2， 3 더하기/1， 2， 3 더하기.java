import java.io.*;
import java.util.*;

public class Main {
    static int[] answer;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트케이스 개수
        n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] input = new int[n];



        for (int i=0; i<n; i++) {
            // n개의 수가 들어옴
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            input[i] = x;
        }

        Arrays.sort(arr);
        int max = arr[n-1];
        answer = new int[max + 1];
        answer[0] = 1;
        answer[1] = 2;
        answer[2] = 4;

        // 배열 계산
        pro(max);

        for (int i=0; i<n; i++) {
            int ans = answer[input[i] - 1];
            System.out.println(ans);
        }
    }

    public static void pro(int x) {
        for (int i=3; i<x; i++) {
            // 점화식
            answer[i] = answer[i-1] + answer[i-2] + answer[i-3];
        }

    }
}
