import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[][] graph;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> cntList = new ArrayList<>();
        int picNum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) { // 이미 방문한 좌표면 건너뜀
                    continue;
                } else if (graph[i][j] == 0) { // 그래프가 0이면 건너뜀
                    continue;
                } else {
                    cntList.add(bfs(j, i, n, m));
                    picNum++;
                }
            }
        }

        int max = cntList.stream().mapToInt(v -> v).max().orElse(0);

        System.out.println(picNum);
        System.out.println(max);
    }

    public static int bfs(int x, int y, int n, int m) { // Bfs 에서는 n, m 이 좌표 전체 크기였음 그래서 안되었던 것임
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(x, y);
        int cnt = 0;

        // 시작점
        queue.add(node);
        cnt++;
        visited[node.y][node.x] = true;

        // queue가 비었을 경우 탈출, (조건문이 false일때 탈출)
        while (!queue.isEmpty()) {
            Node visitedNode = queue.poll(); // queue에서 방문 노드 pop

            for (int dir = 0; dir < 4; dir++) { // pop한 방문 노드의 인접 노드들을 돌며 4번 체크
                int nx = visitedNode.x + dx[dir];
                int ny = visitedNode.y + dy[dir];

                if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1) { // 좌표가 음수면 건너뜀, graph 범위를 초과하면 건너뜀
                    continue;
                }

                if (visited[ny][nx]) { // 이미 방문한 좌표면 건너뜀
                    continue;
                }

                if (graph[ny][nx] == 0) { // 그래프가 0이면 건너뜀, 방문할 수 없는 노드이므로
                    continue;
                }

                queue.add(new Node(nx, ny)); // 해당 좌표 queue에 push
                visited[ny][nx] = true; // 좌표 방문표시
                cnt++;
            }
        }
        return cnt;
    }

    // 좌표를 표현하기 위한 클래스
    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
