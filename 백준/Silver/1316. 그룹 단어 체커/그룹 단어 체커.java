
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(bf.readLine());
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (check(bf.readLine())) {
                res++;
            }
        }
        System.out.println(res);
    }

    static boolean check(String s) {
        int n = s.length();
        List<Character> lst = new ArrayList<>();

        char c = s.charAt(0); // char 초기화
        lst.add(c);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (c == ch) { // 이전 문자열과 동일하면
                continue; // 계속
            } else { // 다르면
                if (lst.contains(ch)) { // 이전에 동일한 문자가 포함되는지 판단
                    return false;
                } else {
                    lst.add(ch); // 리스트 추가
                    c = ch; // c 초기화
                }
            }
        }
        return true;
    }
}