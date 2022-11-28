package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.Set;

public class IO {
    private static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT_MSG = "숫자를 입력해주세요 : ";
    private static final String CLEAR_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final String RESULT_FORMAT_B = "%d볼";
    private static final String RESULT_FORMAT_S = "%d스트라이크";
    private static final String RESULT_FORMAT_BS = "%d볼 %d스트라이크";
    private static final String RESULT_NOTHING = "낫싱";

    public static void printStartMSG() {
        System.out.println(START_MSG);
    }

    public static void printNumberInputMSG() {
        System.out.print(NUMBER_INPUT_MSG);
    }

    public static void printClearMSG() {
        System.out.println(CLEAR_MSG);
    }

    public static void printRestartMSG() {
        System.out.println(RESTART_MSG);
    }

    public static String userInput() {
        String input = Console.readLine();
        validate(input);
        return input;
    }
    private static void validate(String input) {
        validateFormat(input);
        validateHasDuplicatedNumber(input);
    }
    private static void validateFormat(String input) {
        String format = "[1-9]{3}";
        if (!input.matches(format)) {
            throw new IllegalArgumentException();
        }
    }
    private static void validateHasDuplicatedNumber(String input) {
        Set<Integer> set = new HashSet<>();
        input.chars().forEach(set::add);
        if (set.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    public static void printResult(int ballCounts, int strikeCounts) {
        if (ballCounts != 0 && strikeCounts == 0 ) {
            System.out.println(String.format(RESULT_FORMAT_B, ballCounts));
            return;
        }
        if (ballCounts == 0 && strikeCounts != 0) {
            System.out.println(String.format(RESULT_FORMAT_S, strikeCounts));
            return;
        }
        if (ballCounts != 0 && strikeCounts != 0) {
            System.out.println(String.format(RESULT_FORMAT_BS, ballCounts, strikeCounts));
            return;
        }
        System.out.println(RESULT_NOTHING);
    }

    public static String retryInput() {
        String retryInput = Console.readLine();
        validateRetryInput(retryInput);
        return retryInput;
    }
    private static void validateRetryInput(String retryInput) {
        if (!retryInput.matches("[1]|[2]")){
            throw new IllegalArgumentException();
        }
    }
}
