import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        ArrayList<Integer> lst = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int pick = sc.nextInt();

            if (pick == 0) {
                lst.add(i + 1);
            } else {
                int jump = lst.size() - pick;
                lst.add(jump, i + 1);
            }
        }

        for (int i : lst) {
            System.out.print(i + " ");
        }






    }
}
