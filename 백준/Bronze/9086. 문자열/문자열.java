import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st1.nextToken());

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            String s = st2.nextToken();
            char firstChar = s.charAt(0);
            char lastChar = s.charAt(s.length() -1);
            bw.write(firstChar);
            bw.write(lastChar);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}