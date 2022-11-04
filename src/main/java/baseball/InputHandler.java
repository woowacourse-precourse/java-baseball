package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHandler {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static String getInput_returnMyNum() throws IOException {
        String myNum = br.readLine();
        //TODO : 도메인 test
        System.out.println("입력 수 : "+myNum);
        return myNum;
    }
    public int getRestartNum() throws IOException {
        //TODO : try_catch can String to int test
        int restartNum = Integer.parseInt(br.readLine());
        System.out.println("입력 수 : "+restartNum);
        return restartNum;
    }
}
