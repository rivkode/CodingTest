import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        String n = br.readLine();
        int N  = Integer.parseInt(n);

        int sum = 0;
        for (byte b : br.readLine().getBytes()) {
            sum += (b - '0');
        }

        System.out.println(sum);

    }
}
