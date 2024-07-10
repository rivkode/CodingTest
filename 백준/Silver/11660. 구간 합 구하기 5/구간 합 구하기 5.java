
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 1; k <= m; k++) {
            int sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i <= x2; i++) {
                sum = sum + (dp[i][y2] - dp[i][y1 - 1]);
            }
            sb.append(sum + "\n");
        }
        System.out.println(sb);
    }

//    static int n, m;
//    static int[][] arr;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        arr = new int[n + 1][n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            StringTokenizer st1 = new StringTokenizer(br.readLine());
//
//            for (int j = 1; j <= n; j++) {
//                arr[i][j] = Integer.parseInt(st1.nextToken());
//            }
//        }
//
//        int[][] xy = new int[m + 1][4 + 1];
//
//        for (int i = 1; i <= m; i++) {
//            StringTokenizer st1 = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= 4; j++) {
//                xy[i][j] = Integer.parseInt(st1.nextToken());
//            }
//        }
//
//        for (int i = 1; i <= m; i++) {
//            int x1 = xy[i][1];
//            int y1 = xy[i][2];
//            int x2 = xy[i][3];
//            int y2 = xy[i][4];
//
//            List<Coor> coorList = cal(x1, y1, x2, y2);
//            print(coorList);
//        }
//
//
//
//    }
//
//    public static void print(List<Coor> coorList) {
//        /**
//         * coorlist에 있는 좌표에 대해 arr를 더하면 된다.
//         */
//
//        int ans = 0;
//        for (int i = 0; i < coorList.size(); i++) {
//            int x = coorList.get(i).getX();
//            int y = coorList.get(i).getY();
//
//            ans += arr[x][y];
//        }
//
//        System.out.println(ans);
//    }
//
//    public static List<Coor> cal(int x1, int y1, int x2, int y2) {
//        Coor c1 = new Coor(x1, y1);
//        Coor c2 = new Coor(x2, y2);
//
//        List<Coor> coors = new ArrayList<>();
//
//        for (int i = c1.getX(); i <= c2.getX(); i++) {
//            for (int j = c1.getY(); j <= c2.getY(); j++) {
//                Coor coor = new Coor(i, j);
//                coors.add(coor);
//            }
//        }
//
//        return coors;
//    }
//
//    public static class Coor {
//        int x;
//        int y;
//
//        public Coor(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public int getX() {
//            return this.x;
//        }
//
//        public int getY() {
//            return this.y;
//        }
//    }
}
