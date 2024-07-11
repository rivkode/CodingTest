import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        arr = new int[m];

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int start, int depth) {

        // 종료조건 끝까지 돌았다면 ?
        if (depth == m) {
            for(int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        // 주변이라는 것은 start를 제외한 숫자를 의미
        for (int i = 1; i < n + 1; i++) {
            if ((start == i)) {
                continue;
            }

            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            arr[depth] = i;
            dfs(i, depth + 1);
            visited[i] = false;
        }
    }
}
