

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 =  new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st1.nextToken());
        int b = Integer.parseInt(st1.nextToken());
        int c = Integer.parseInt(st1.nextToken());
        int result = 0;

        int cnt = count(a, b, c);
        int max = max(a, b, c);
        int same = same(a, b, c);

        if (cnt == 3) {
            result = max * 100;
        } else if (cnt == 2) {
            result = (same * 100) + 1000;
        } else {
            result = (same*1000) + 10000;
        }

        bw.write(String.valueOf(result + "\n"));

        bw.flush();
        bw.close();
    }
    static int max(int a, int b, int c) {
        if (a <= b) {
            if (b <= c) {
                return c;
            } else {
                return b;
            }
        } else if (a <= c) {
            if (c <= b) {
                return b;
            } else {
                return c;
            }
        } else if (b <= c) {
            if (c <= a) {
                return a;
            } else {
                return c;
            }
        }
        return a;
    }



    static int same(int a, int b, int c) {
        if (a == b) {
            return a;
        } else return c;
    }

    static int count(int a, int b, int c) {
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(a);
        integerSet.add(b);
        integerSet.add(c);

        return integerSet.size();
    }
}