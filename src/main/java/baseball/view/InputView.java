package baseball.view;

import baseball.utils.Utils;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;

public class InputView {

    private static final int NUM_SIZE = 3;
    private static final String RE_GAME = "1";
    private static final String GAME_OVER = "2";
    private static final String THREE_SIZE_NUM_REGEX = "^[1-9]{3}$";

    public static String requestNum() {
        OutputView.printRequestNum();
        String input = Console.readLine();

        return validateRequestNum(input);
    }

    static String validateRequestNum(String input) {
        input = Utils.deleteAllSpace(input);
        if (!Pattern.matches(THREE_SIZE_NUM_REGEX, input) || hasDuplicatedNum(input)) {
            throw new IllegalArgumentException();
        }
        return input;
    }

    private static boolean hasDuplicatedNum(String input) {
        return Arrays.stream(input.split(""))
                .distinct()
                .count() != NUM_SIZE;
    }

    public static boolean requestIsReGame() {
        OutputView.printRequestReGame();
        return validateRequestIsReGame(Console.readLine());
    }

    static boolean validateRequestIsReGame(String input) {
        input = Utils.deleteAllSpace(input);
        if (!input.equals(RE_GAME) && !input.equals(GAME_OVER)) {
            throw new IllegalArgumentException();
        }
        return input.equals(RE_GAME);
    }
}
