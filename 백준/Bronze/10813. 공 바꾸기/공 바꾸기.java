import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        StringTokenizer st1 = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st1.nextToken());
        int m = Integer.parseInt(st1.nextToken());

        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }


        for (int t=0; t<m; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int a = list.get(i-1);
            int b = list.get(j-1);
            list.set(i-1, b);
            list.set(j-1, a);
        }

        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(list.get(i)));
            bw.write(" ");
        }

        bw.flush();
        bw.close();
    }
}