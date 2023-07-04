
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());

        int N = Integer.valueOf(st1.nextToken());
        int M = Integer.valueOf(st1.nextToken());

        int[] A = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.valueOf(st2.nextToken());
        }

        S[0] = A[0];

        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int I = Integer.valueOf(st.nextToken());
            int J = Integer.valueOf(st.nextToken());
            if (I == 1) {
                System.out.println(S[J - 1]);
            } else {
                System.out.println(S[J - 1] - S[I - 2]);
            }
        }
    }
}