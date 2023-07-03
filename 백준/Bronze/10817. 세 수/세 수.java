
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[3];


        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        arr[0] = a;
        arr[1] = b;
        arr[2] = c;

        Arrays.sort(arr);
        System.out.println(arr[1]);
    }
}