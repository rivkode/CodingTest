import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st1 = new StringTokenizer(bf.readLine());

        int num = Integer.parseInt(st1.nextToken());

        int n = num / 4;

        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf("long" + " "));
        }

        bw.write(String.valueOf("int"));
        bw.flush();
        bw.close();
    }
}