
import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int n;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int houseCount;
    static int allCount;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 1; j <= n; j++) {
                arr[i][j] = s.charAt(j - 1) - '0';
            }
        }

        List<Integer> houseNumber = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    // 탐색시작
                    houseCount = 0;
                    dfs(i, j);
                    houseNumber.add(houseCount);
                    allCount++;
                }
            }
        }

        Collections.sort(houseNumber);

        System.out.println(allCount);
        for (int i = 0; i < houseNumber.size(); i++) {
            System.out.println(houseNumber.get(i));
        }

    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        houseCount++;

        for (int i = 0; i < 4; i++) {
            int x1 = dx[i] + x;
            int y1 = dy[i] + y;

            if (x1 <= 0 || y1 <= 0 || x1 > n || y1 > n) {
                continue;
            }

            if (!visited[x1][y1] && arr[x1][y1] == 1) {
                dfs(x1, y1);
            }
        }
    }
}
