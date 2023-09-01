import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int count;

    public static int bfs(int n, int m, List<Node> listNode) {


        // 시작점
        Queue<Node> queue = new LinkedList<>(listNode);
        List<Integer> cntList = new ArrayList<>();

        for (int i = 0; i < listNode.size(); i++) {
            Node node = listNode.get(i);
            visited[node.y][node.x] = true;
        }

        // queue가 비었을 경우 탈출, (조건문이 false일때 탈출)
        while (!queue.isEmpty()) {
            Node visitedNode = queue.poll(); // queue에서 방문 노드 pop

            for (int dir = 0; dir < 4; dir++) { // pop한 방문 노드의 인접 노드들을 돌며 4번 체크
                int nx = visitedNode.x + dx[dir];
                int ny = visitedNode.y + dy[dir];

                if (nx < 0 || ny < 0 || nx > n - 1 || ny > m - 1) { // 좌표가 음수면 건너뜀, graph 범위를 초과하면 건너뜀
                    continue;
                }

                if (visited[ny][nx]) { // 이미 방문한 좌표면 건너뜀
                    continue;
                }

                if (graph[ny][nx] == -1) { // 그래프가 0이면 건너뜀, 방문할 수 없는 노드이므로
                    continue;
                }

                int cnt = visitedNode.cnt + 1; // 이전 느드에 비해 거리가 1 증가
                cntList.add(cnt);


                queue.add(new Node(nx, ny, cnt)); // 해당 좌표 queue에 push
                visited[ny][nx] = true; // 좌표 방문표시
                graph[ny][nx] = 1;

//                System.out.printf("visited[%s][%s]" + "\n", nx, ny);
            }
        }
        int max = cntList.stream().mapToInt(v -> v).max().orElse(0);

        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[m][n];
        visited = new boolean[m][n];
        count = 0;
        List<Node> nodeList = new ArrayList<>();
        int max;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                graph[i][j] = tomato;

                if (tomato == 1) {
                    Node node = new Node(j, i, 0);
                    nodeList.add(node);
                }
            }
        }

        // 노드에 거리값을 저장한 뒤 거리값중 가장 큰 값 반환
        max = bfs(n, m, nodeList);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) { // 0인 토마토가 하나라도 존재하면 -1
                    max = -1;
                    break;
                }
            }
        }


        System.out.println(max);
    }




    public static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
