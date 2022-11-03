package baseball;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public static int inputNumber() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("숫자를 입력해주세요 : ");
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new IllegalArgumentException("숫자 입력 오류");
        }
    }

    public static boolean inputReplay() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int replay = Integer.parseInt(br.readLine());
            return Validate.isCommandValid(replay);
        } catch (IOException e) {
            throw new IllegalArgumentException("명령 입력 오류");
        }
    }
}
