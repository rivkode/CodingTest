
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        String str = st1.nextToken();

        char[] arr = str.toCharArray();

        int m = Integer.parseInt(st2.nextToken());
        char c = arr[m-1];
        bw.write(c);
        bw.flush();
        bw.close();
    }
}