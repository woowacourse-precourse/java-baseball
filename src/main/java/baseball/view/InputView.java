package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String INPUT_BALL_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String DELIMITER = "";
    private static final String NUMBER_EXCEPTION_MESSAGE = "숫자가 아닙니다.";

    public static List<Integer> getBalls() {
        System.out.println(INPUT_BALL_MESSAGE);
        String number = inputNumber();
        return Arrays.stream(number.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int restart() {
        System.out.println(GAME_RESTART_MESSAGE);
        String status = inputNumber();
        return Integer.parseInt(status);
    }

    public static String inputNumber() {
        String input = Console.readLine();
        validateNumber(input);
        return input;
    }

    private static void validateNumber(String input) {
        if (!input.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
