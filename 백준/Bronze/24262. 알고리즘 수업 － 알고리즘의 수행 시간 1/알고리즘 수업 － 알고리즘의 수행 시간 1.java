import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        OutputStream out = System.out;
        InputStreamReader reader = new InputStreamReader(in);
        OutputStreamWriter writer = new OutputStreamWriter(out);

        BufferedReader br = new BufferedReader(reader);
        BufferedWriter bw = new BufferedWriter(writer);

        int n = Integer.parseInt(br.readLine());

        bw.write(1+"\n");
        bw.write(MenOfPassion(n)+"");
        bw.flush();
        bw.close();
    }

    static int MenOfPassion(int n) {
        return 0;
    }
}
