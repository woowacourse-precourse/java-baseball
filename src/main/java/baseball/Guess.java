package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Integer> splitGuess(String input) {
        List<Integer> userAnswer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String digitChar = String.valueOf(input.charAt(i));
            Integer digitInt = Integer.parseInt(digitChar);
            userAnswer.add(digitInt);
        }
        return userAnswer;
    }
}
