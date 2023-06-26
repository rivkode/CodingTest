
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> list = new ArrayList<>();

        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        StringTokenizer st3 = new StringTokenizer(bf.readLine());
        int count = 0;

        int n = Integer.parseInt(st1.nextToken());

        while (st2.hasMoreTokens()) {
            list.add(Integer.parseInt(st2.nextToken()));
        }

        int num = Integer.parseInt(st3.nextToken());

        for (int i = 0; i < n; i++) {
            if (list.get(i) == num) {
                count ++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}