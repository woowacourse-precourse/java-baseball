package baseball.view;

import java.io.*;

public class Game {
    public int inputToQuestion() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        try {
            answer = Integer.parseInt(br.readLine());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return answer;
    }
    public void print(String output) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(output);
            bw.flush();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
//        bw.close();
    }
}
