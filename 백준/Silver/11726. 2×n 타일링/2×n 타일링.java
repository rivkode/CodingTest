import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        arr = new int[1000];
        arr[0] = 1;
        arr[1] = 2;


        preprocess();

        int cal = arr[n - 1];
        sb.append(cal + " ");

        System.out.println(sb);
    }

    public static void preprocess() {
        for (int i = 2; i < 1000; i++) {
            arr[i] = (arr[i - 1] + arr[i - 2]) % 10007;
        }
    }
}
