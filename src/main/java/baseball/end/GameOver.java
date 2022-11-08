package baseball.end;

import java.util.Scanner;

public class GameOver {

    private static final int VALID_LENGTH_OF_USER_INPUT = 1;
    private static final String VALID_PLAYER_INPUT_PATTERN = "^[1-2]";
    private static final String MESSAGE_TO_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String input() {
        Scanner sc = new Scanner(System.in);
        String inputData = "";

        System.out.println(MESSAGE_TO_CONTINUE);
        inputData = sc.next();

        return inputData;
    }

    public static void ExceptionProcess(String inputData) {
        if(inputData.length() != VALID_LENGTH_OF_USER_INPUT)
            throw new IllegalArgumentException();

        if(!inputData.matches(VALID_PLAYER_INPUT_PATTERN))
            throw new IllegalArgumentException();
    }
}
