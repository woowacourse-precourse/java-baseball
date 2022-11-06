package baseball.view;

import java.io.*;

public class Game {
    public int inputToQuestion() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = Integer.parseInt(br.readLine());

        return answer;
    }
    public void print(String output) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(output);
        bw.flush();
//        bw.close();
    }
}
