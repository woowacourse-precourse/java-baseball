package baseball.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.Set;
import java.util.stream.Collectors;

public class InputUtils {

    private static final String REGEX = "[1-9]+";
    private static final String INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INVALID_INPUT_MESSAGE = "잘못된 입력입니다.";
    private static final String RESTART_GUIDE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void checkIsValidInput(String input) {
        if (!input.matches(REGEX) || input.length() != 3) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }

        Set<Integer> inputSet = input.chars()
                .mapToObj(ch -> ch - '0')
                .collect(Collectors.toSet());
        if (inputSet.size() != 3) {
            throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
        }
    }

    public static String askWhetherToRestart() {
        System.out.println(RESTART_GUIDE_MESSAGE);
        return Console.readLine();
    }

    public static String readNumbersWrittenByUser() {
        System.out.print(INPUT_GUIDE_MESSAGE);
        return Console.readLine();
    }
}
