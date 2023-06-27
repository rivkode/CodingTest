import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st1.nextToken());

        int[] origin = new int[N]; // 기존 배열
        int[] sorted = new int[N]; // 정렬할 배열
        HashMap<Integer, Integer> rankingMap = new HashMap<>(); // rank를 매길 배열



        for (int i = 0; i < N; i++) {
            sorted[i] = origin[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(sorted); // 정렬 수행

        int rank = 0;

        for (int v : sorted) {
            /**
             * 만약 앞선 원소가 이미 순위가 매겨졌다면
             * 원소의 순위가 중복되면 안되므로, 중복되지 않을 때만
             * map에 원소와 그에 대응하는 순위를 넣는다.
             */
            if (!rankingMap.containsKey(v)) {
                rankingMap.put(v, rank);
                rank++; // 다음 순위를 가르키도록 1을 더해준다
            }
        }


        for (int key : origin) {
            int ranking = rankingMap.get(key);
            bw.write(ranking + " ");
        }

        bw.flush();
        bw.close();
    }
}