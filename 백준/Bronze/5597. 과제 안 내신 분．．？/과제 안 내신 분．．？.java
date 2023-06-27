import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new ArrayList<>();


        for (int i = 0; i < 30; i++) {
            list.add(String.valueOf(i+1));
        }


        for (int t=0; t<28; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            list.remove(st.nextToken());
        }

        for (String string : list) {
            bw.write(string + "\n");
        }

        bw.flush();
        bw.close();
    }
}