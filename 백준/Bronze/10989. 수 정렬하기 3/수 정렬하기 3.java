import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());

        int[] arr = new int[10001];
        for (int i = 0; i < N; i++) {
            // 해당하는 인덱스의 값을 1 증가 함으로써 숫자를 배열에 넣는 역할
            arr[Integer.parseInt(br.readLine())] ++;
        }

        br.close();

        for (int i = 1; i < 10001; i++) {
            // i 값이 개수가 0이 될때까지 출력, 동일한 수가 여러번 저장되어 1이상이 될 수 있으므로
            // 모두 없어질때까지 출력
            while (arr[i] > 0) {
                bw.write(String.valueOf(i) + "\n");
                arr[i]--;
            }
        }
        bw.flush();
        bw.close();
    }
}
