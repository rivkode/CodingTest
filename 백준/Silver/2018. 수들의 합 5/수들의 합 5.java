import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st1.nextToken());
            int count = 1;
            int start_index = 1;
            int end_index = 1;
            int sum = 1;

            while (end_index != N) {
                if (sum == N) {
                    count++;
                    end_index++;
                    sum += end_index;
                } else if (sum > N) {
                    sum -= start_index;
                    start_index++;
                } else {
                    end_index++;
                    sum += end_index;
                }
            }
            System.out.println(count);
            }
        catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
            }
        }
    }
}
