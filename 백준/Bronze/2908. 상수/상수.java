
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 = new StringTokenizer(bf.readLine());
        int a = Integer.parseInt(st1.nextToken());
        int b = Integer.parseInt(st1.nextToken());
        int result = 0;

        int A = reverse(a);
        int B = reverse(b);
        if (A > B) {
            result = A;
        } else {
            result = B;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static int reverse(int x) {
        String s = String.valueOf(x);
        char[] chars = s.toCharArray();
        int n = chars.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(String.valueOf(chars[i])));
        }
        for (int i = 0; i < n; i++) {
            res[i] = stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i);
        }
        String str = sb.toString();
        int integer = Integer.parseInt(str);
        return integer;
    }
}