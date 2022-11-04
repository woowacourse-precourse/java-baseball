package baseball;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constant.GAME_FINISH;
import static baseball.Constant.WRITE_ANSWER;

public class Guess {
    public static String takeGuess() {
        System.out.print(WRITE_ANSWER);
        return Console.readLine();
    }

    public static void checkGuess(String input) throws IllegalArgumentException {
        // 입력값이 숫자로만 이루어져 있는지 확인
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GAME_FINISH);
        }

        // 입력값이 세 글자인지 확인
        if (input.length() != 3)
            throw new IllegalArgumentException(GAME_FINISH);
    }
}
