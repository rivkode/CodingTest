import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        // queue 선언
        Queue<Integer> q = new LinkedList<>();

        // 값 추가
        for (int i = 0; i < N; i++) {
            q.offer(i + 1);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        // size가 1이 되기 전까지 반복
        while (q.size() > 1) {
            // k-1번 poll과 add를 반복하며 회전을 구현한다
            for (int i = 0; i < K - 1; i++) {
                int val = q.poll();
                q.offer(val);
            }
            // 회전이 끝나면 가장 앞에 있는 원소를 poll한다
            result.append(q.poll()).append(", ");
        }
        result.append(q.poll()).append(">");

        System.out.println(result);
    }
}
