import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                swap(arr, j, j + 1);
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }


    }

    static void swap(int[] arr, int a, int b) {
        if (arr[a] > arr[b]) {
            int tmp = arr[b];
            arr[b] = arr[a];
            arr[a] = tmp;
        }
    }
}
