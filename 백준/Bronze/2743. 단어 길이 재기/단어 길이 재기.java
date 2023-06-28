
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        String str = st1.nextToken();

        char[] arr = str.toCharArray();
        bw.write(String.valueOf(arr.length));
        bw.flush();
        bw.close();
    }
}