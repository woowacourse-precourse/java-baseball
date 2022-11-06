package baseball.end;

import java.util.Scanner;

public class GameOver {

    private static final String INPUT_OF_CONTINUE = "0";
    private static final String INPUT_OF_END = "1";
    private static final String MESSAGE_TO_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String input() {
        Scanner sc = new Scanner(System.in);
        String inputData = "";

        System.out.println(MESSAGE_TO_CONTINUE);
        inputData = sc.next();

        return inputData;
    }
}
