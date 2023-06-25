import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st1 =  new StringTokenizer(bf.readLine());
        StringTokenizer st2 =  new StringTokenizer(bf.readLine());

        int hour = Integer.parseInt(st1.nextToken());
        int minute = Integer.parseInt(st1.nextToken());
        int time = Integer.parseInt(st2.nextToken());
        int subhour = 0;
        int subminute = 0;

        if (time < 60) {
            subminute = time;
        } else {
            subhour = time / 60;
            subminute = time % 60;
        }

        hour = hour + subhour;
        minute = minute + subminute;

        if (minute < 60) {
            minute = minute;
        } else {
            hour = hour + minute / 60;
            minute = minute - 60;
        }

        if (hour < 24) {
            hour = hour;
        } else {
            hour = hour - 24;
        }

        bw.write(hour +" "+minute);


        bw.flush();
        bw.close();
    }
}
