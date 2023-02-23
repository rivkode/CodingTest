import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        InputStream in = System.in;
        InputStreamReader reader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(reader);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        int count = 0;

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            count += search(c) + 1;
        }

        bw.write(count+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int search(char targetNum) {

        int result = 0;
        if (targetNum >= 'A' && targetNum <= 'C') {
            result = 2;
        } else if (targetNum >= 'D' && targetNum <= 'F') {
            result = 3;
        } else if (targetNum >= 'G' && targetNum <= 'I') {
            result = 4;
        } else if (targetNum >= 'J' && targetNum <= 'L') {
            result = 5;
        } else if (targetNum >= 'M' && targetNum <= 'O') {
            result = 6;
        } else if (targetNum >= 'P' && targetNum <= 'S') {
            result = 7;
        } else if (targetNum >= 'T' && targetNum <= 'V') {
            result = 8;
        } else if (targetNum >= 'W' && targetNum <= 'Z') {
            result = 9;
        }

        return result;
    }
}
