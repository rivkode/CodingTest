import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ascending = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] descending = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        int[] arr = new int[8];

        for (int i = 0; i < 8; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        String s;

        if (Arrays.equals(ascending, arr)) {
            s = "ascending";
        } else if (Arrays.equals(descending, arr)) {
            s = "descending";
        } else {
            s = "mixed";
        }

        System.out.println(s);
    }
}
