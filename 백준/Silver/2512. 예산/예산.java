import java.io.*;
import java.util.*;

public class Main {
    private static long ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n]; // 지방예산
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long left = 0, right = arr[n-1];
        long m = Long.parseLong(br.readLine()); // 총 예산
        while (left <= right) {
            long mid = (left + right) / 2; // 내야할 세금
            long budget = 0; // 모든 지방 세금 합
            for (int money : arr) {
                if (money >= mid) { // 요청한 세금을 낼 수 있는 지방
                    budget += mid;
                } else { // 요청한 세금을 낼 수 없는 지방, 가진 돈의 최대만 냄
                    budget += money;
                }
            }
            if (budget > m) { // 내라는 세금보다 많은 경우 -> 세금을 줄여본다
                right = mid - 1;
            } else { // 내라는 세금보다 적은 경우 -> 세금을 높여서 더 최고의 경우의 수를 찾는다
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
        }
        System.out.println(ans);
    }
}
